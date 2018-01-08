package com.zking.bookstore.controller;

import com.zking.bookstore.exception.CustomException;
import com.zking.bookstore.model.Book;
import com.zking.bookstore.model.Dict;
import com.zking.bookstore.model.Doc;
import com.zking.bookstore.model.User;
import com.zking.bookstore.service.IBookService;
import com.zking.bookstore.service.IDictService;
import com.zking.bookstore.service.IDocService;
import com.zking.bookstore.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 图书控制器
 *
 * @Author Zeng LongFeng
 * @CreateTime 2017-12-28 15:24
 * @Version 1.0
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;
    @Autowired
    private IDocService docService;
    @Autowired
    private IDictService dictService;

    /**
     * 初始化操作
     *
     * @param model
     */
    public void init(Model model) {
        List<Dict> bookTypeList = dictService.selectAllByDictName("图书类别");// 查询所有的图书类别
        model.addAttribute("bookTypeList", bookTypeList);// 存到model中
    }

    /**
     * 跳转到首页
     *
     * @param model
     * @return
     */
    @RequestMapping("/toIndex")
    public String toIndex(Model model) {
        init(model);

        List<Book> top5NewBookList = bookService.selectTop5NewBook();
        model.addAttribute("top5NewBookList", top5NewBookList);// 存到model中

        List<Book> top5SalesVolumeList = bookService.selectTop5SalesVolume();
        model.addAttribute("top5SalesVolumeList", top5SalesVolumeList);// 存到model中

        // 跳转到首页
        return "index";
    }

    /**
     * 跳转到新增图书页面
     *
     * @param model Model
     * @return 逻辑视图名
     */
    @RequestMapping("/toAddBook")
    public String toAddBook(Model model) {
        init(model);

        // 跳转到新增图书页面
        return "manager/addBook";
    }

    /**
     * 新增图书
     *
     * @param model         Model
     * @param book          图书信息
     * @param bindingResult 保存一些错误消息
     * @return 逻辑视图名
     */
    @RequestMapping("/addBook")
    public String addBook(Model model, @ModelAttribute @Validated Book book, BindingResult bindingResult) {

        // 如果验证不通过
        if (bindingResult.hasErrors()) {
            // 回到新增页面
            return "manager/addBook";
        }
        bookService.insert(book);// 新增图书

        // 重定向到未上架状态的展示全部图书页面
        return "redirect:/book/selectAllBookByStatus/1";
    }


    /**
     * 跳转到图片上传页面
     *
     * @param model
     * @param bookId 图书编号
     * @return 逻辑视图名
     */
    @RequestMapping("/toUploadBookImage/{bookId:[0-9]+}")
    public String toUploadBookImage(Model model, @ModelAttribute @PathVariable Long bookId) {
        // 跳转到修改图书页面
        return "manager/uploadBookImage";
    }

    @RequestMapping("/doUploadBookImage")
    public String doUploadBookImage(HttpSession session, Long bookId, MultipartFile bookPic) throws CustomException {
        //原始图片名称
        String docName = bookPic.getOriginalFilename();

        //如果文件不为空
        if (null != bookPic && null != docName && docName.trim().length() > 0) {
            //上传图片

            Date date = new Date(System.currentTimeMillis());
            //存储图片的物理路径
            String fwtpPath = "D:\\temp\\upload\\" + (date.getYear() + 1900) + "\\" + (date.getMonth() + 1) + "\\" + date.getDate() + "\\";

            File file1 = new File("D:\\temp\\upload\\" + (date.getYear() + 1900));
            File file2 = new File("D:\\temp\\upload\\" + (date.getYear() + 1900) + "\\" + (date.getMonth() + 1));
            File file3 = new File("D:\\temp\\upload\\" + (date.getYear() + 1900) + "\\" + (date.getMonth() + 1) + "\\" + date.getDate());
            if (!file1.exists()) {
                file1.mkdir();
                if (!file2.exists()) {
                    file2.mkdir();
                    if (!file3.exists()) {
                        file3.mkdir();
                    }
                }
            }

            //新的图片名称
            String docId = getDocId();

            //图片路径
            String docPath = fwtpPath + docId;
            //新图片
            File newFile = new File(docPath);

            try {
                //将内存中的数据写入磁盘
                bookPic.transferTo(newFile);
            } catch (IOException e) {
                throw new CustomException("文件上传失败", e);
            }
            //文件
            Doc doc = new Doc();
            doc.setDocid(docId);//设置文件编号
            doc.setDocname(docName);//设置文件名称
            doc.setDocpath(docPath);//设置文件路径
            doc.setDoctype(bookPic.getContentType());//设置文件类型
            doc.setDocbook(bookId);//设置文件所属房屋信息编号
            doc.setDocman(getCurrentUser(session).getUserId());//设置文件上传人编号

            docService.insert(doc);//新增文件
        }

        // 重定向到未上架状态的展示全部图书页面
        return "redirect:/book/selectAllBookByStatus/1";
    }

    /**
     * 跳转到修改图书页面
     *
     * @param model  Model
     * @param bookId 图书编号
     * @return 逻辑视图名
     */
    @RequestMapping("/toEditBook/{bookId:[0-9]+}")
    public String toEditBook(Model model, @PathVariable Long bookId) {
        init(model);

        // 根据主键查询图书完整信息并且存到Model中.
        selectByPrimaryKey(model, bookId);

        // 跳转到修改图书页面
        return "manager/editBook";
    }

    /**
     * 修改图书
     *
     * @param model         Model
     * @param bookId        图书编号
     * @param book          图书信息
     * @param bindingResult 保存一些错误消息
     * @return 逻辑视图名
     */
    @RequestMapping("/editBook")
    public String editBook(Model model, Long bookId, @ModelAttribute @Validated Book book,
                           BindingResult bindingResult) {

        // 如果验证不通过
        if (bindingResult.hasErrors()) {
            // 回到修改页面
            return "manager/editBook";
        }
        bookService.updateByPrimaryKey(bookId, book);// 修改图书

        // 重定向到未上架状态的展示全部图书页面
        return "redirect:/book/selectAllBookByStatus/1";
    }

    /**
     * 删除图书
     *
     * @param bookId 图书编号
     * @return 逻辑视图名
     */
    @RequestMapping("/deleteBook/{bookId:[0-9]+}")
    public String deleteBook(@PathVariable Long bookId) {

        // 根据主键(图书编号)删除图书
        bookService.deleteByPrimaryKey(bookId);

        // 重定向到未上架状态的展示全部图书页面
        return "redirect:/book/selectAllBookByStatus/1";
    }

    /**
     * 图书上架
     *
     * @param bookId 图书编号
     * @return 逻辑视图名
     */
    @RequestMapping("/putaway/{bookId:[0-9]+}")
    public String putaway(@PathVariable Long bookId, Book book) {

        // 设置图书状态为上架状态
        book.setStatus(2L);
        // 根据主键(图书编号)修改图书状态
        bookService.updateStatusByPrimaryKey(bookId, book);

        // 重定向到已上架状态的展示全部图书页面
        return "redirect:/book/selectAllBookByStatus/2";
    }

    /**
     * 图书下架
     *
     * @param bookId 图书编号
     * @return 逻辑视图名
     */
    @RequestMapping("/soldOut/{bookId:[0-9]+}")
    public String soldOut(@PathVariable Long bookId, Book book) {

        // 设置图书状态为下架状态
        book.setStatus(3L);
        // 根据主键(图书编号)修改图书状态
        bookService.updateStatusByPrimaryKey(bookId, book);

        // 重定向到已下架状态的展示全部图书页面
        return "redirect:/book/selectAllBookByStatus/3";
    }

    /**
     * 根据图书类别查询全部图书
     *
     * @param request  请求
     * @param model    Model
     * @param book     图书信息
     * @param bookType 图书类别
     * @return 逻辑视图名
     */
    @RequestMapping("/selectAllByBookType/{bookType:[0-9]+}")
    public String selectAllByBookType(HttpServletRequest request, Model model, Book book, @PathVariable Long bookType) {
        init(model);

        book.setStatus(2L);// 设置图书状态为上架状态，只能查看上架状态的图书
        book.setBookType(bookType);// 设置图书类型

        selectAll(model, book, request);// 查询全部图书并且存到Model中

        // 跳转到根据图书类别展示全部图书页面
        return "show/findBook";
    }

    /**
     * 根据图书状态查询全部图书
     *
     * @param request 请求
     * @param model   Model
     * @param book    图书信息
     * @param status  图书状态
     * @return 逻辑视图名
     */
    @RequestMapping("/toListBook/{status:[0-9]+}")
    public String toListBook(HttpServletRequest request, Model model, Book book,
                             @ModelAttribute @PathVariable Long status) {
        init(model);

        book.setStatus(status);// 设置图书状态
        selectAll(model, book, request);// 查询全部图书并且存到Model中

        // 跳转到根据图书状态展示全部图书页面
        return "manager/listBook";
    }

    /**
     * 根据主键查询图书完整信息并且存到Model中.
     *
     * @param model  Model
     * @param bookId 主键(图书编号)
     */
    private void selectByPrimaryKey(Model model, Long bookId) {
        Book b = bookService.selectByPrimaryKey(bookId);
        model.addAttribute("book", b);
    }

    /**
     * 查询全部图书并且存到Model中
     *
     * @param model   Model
     * @param book    图书信息
     * @param request 请求
     */
    private void selectAll(Model model, Book book, HttpServletRequest request) {
        List<Book> bookList = bookService.selectAll(book, handlerPageBean(request));// 查询全部图书
        model.addAttribute("bookList", bookList);// 存到model中
    }

    /**
     * 获得 DocId(UUID)
     *
     * @return DocId
     */
    private String getDocId() {
        // 1. UUID
        String s = UUID.randomUUID().toString();
        s = s.replace("-", "");

        // 2. 时间戳
        // String s = System.currentTimeMillis() + "";
        return s;
    }

    /**
     * 从会话中获得当前登录的用户
     *
     * @param session 会话
     * @return 当前登录的用户
     */
    private User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute("currentUser");
    }


    /**
     * 初始化分页 Bean (PageBean) .
     *
     * @param request 请求.
     * @return PageBean
     */
    private PageBean handlerPageBean(HttpServletRequest request) {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);

        request.setAttribute("pageBean", pageBean);

        return pageBean;
    }
}
