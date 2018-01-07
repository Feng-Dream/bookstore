package com.zking.bookstore.controller;

import com.zking.bookstore.model.Dict;
import com.zking.bookstore.model.ShoppingCar;
import com.zking.bookstore.model.User;
import com.zking.bookstore.service.IDictService;
import com.zking.bookstore.service.IShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 购物车控制器
 *
 * @Author Zeng LongFeng
 * @CreateTime 2017-12-28 15:24
 * @Version 1.0
 */
@Controller
@RequestMapping("/shoppingCar")
public class ShoppingCarController {

    @Autowired
    private IShoppingCarService shoppingCarService;
    @Autowired
    private IDictService dictService;

    /**
     * 初始化操作
     *
     * @param model Model
     */
    public void init(Model model) {
        List<Dict> bookTypeList = dictService.selectAllByDictName("图书类别");// 查询所有的图书类别
        model.addAttribute("bookTypeList", bookTypeList);// 存到model中
    }

    /**
     * 将图书添加到购物车
     *
     * @param session     会话
     * @param bookId      图书编号
     * @param shoppingCar 购物车
     * @return 逻辑视图名
     */
    @RequestMapping("/add2ShoppingCar/{bookId:[0-9]+}")
    public String add2ShoppingCar(HttpSession session, @PathVariable Long bookId, ShoppingCar shoppingCar) {
        if (null == getCurrentUser(session)) {
            return "redirect:/input/login";
        }

        //设置图书编号
        shoppingCar.setBookId(bookId);
        //设置用户编号
        shoppingCar.setUserId(getCurrentUser(session).getUserId());

        //根据用户编号和图书编号查询购物车
        ShoppingCar sc = shoppingCarService.selectByUserIdAndBookId(shoppingCar);

        //如果购物车为空
        if (null == sc) {
            //新增
            shoppingCarService.insert(shoppingCar);
        } else {//如果不为空
            //图书数量加一
            shoppingCar.setBookNum(sc.getBookNum() + 1);
            //修改图书数量
            shoppingCarService.updateBookNum(bookId, shoppingCar);
        }

        //重定向到我的购物车
        return "redirect:/shoppingCar/myShoppingcar";
    }

    /**
     * 我的购物车
     *
     * @param model   Model
     * @param session 会话
     * @return 逻辑视图名
     */
    @RequestMapping("/myShoppingcar")
    public String myShoppingcar(Model model, HttpSession session) {
        if (null == getCurrentUser(session)) {
            return "redirect:/input/login";
        }
        init(model);
        //根据用户编号查询购物车
        List<ShoppingCar> shoppingCarList = shoppingCarService.selectByUserId(getCurrentUser(session).getUserId());
        //存到 Model.
        model.addAttribute("shoppingCarList", shoppingCarList);

        //跳转到购物车
        return "show/shoppingCar";
    }

    /**
     * 清空购物车
     *
     * @param model   Model
     * @param session 会话
     * @return 逻辑视图名
     */
    @RequestMapping("/emptiedShoppingcar")
    public String emptiedShoppingcar(Model model, HttpSession session) {
        if (null == getCurrentUser(session)) {
            return "redirect:/input/login";
        }
        //清空用户的购物车
        shoppingCarService.deleteByUserId(getCurrentUser(session).getUserId());

        //重定向到我的购物车
        return "redirect:myShoppingcar";
    }

    /**
     * 删除图书
     *
     * @param session     会话
     * @param bookId      图书编号
     * @param shoppingCar 购物车
     * @return 逻辑视图名
     */
    @RequestMapping("/deleteBook/{bookId:[0-9]+}")
    public String deleteBook(HttpSession session, @PathVariable Long bookId, ShoppingCar shoppingCar) {
        if (null == getCurrentUser(session)) {
            return "redirect:/input/login";
        }

        //设置图书编号
        shoppingCar.setBookId(bookId);
        //设置用户编号
        shoppingCar.setUserId(getCurrentUser(session).getUserId());

        //删除图书
        shoppingCarService.deleteByUserIdAndBookId(shoppingCar);

        //重定向到我的购物车
        return "redirect:/shoppingCar/myShoppingcar";
    }

    /**
     * 修改图书数量
     *
     * @param session     会话
     * @param bookId      图书编号
     * @param shoppingCar 购物车
     * @return 逻辑视图名
     */
    @RequestMapping("/updateShoppingCar/{bookId:[0-9]+}/{bookNum:[0-9]+}")
    public String updateShoppingCar(HttpSession session, @PathVariable Long bookId, @PathVariable Integer bookNum, ShoppingCar shoppingCar) {
        if (null == getCurrentUser(session)) {
            return "redirect:/input/login";
        }

        //设置图书编号
        shoppingCar.setBookId(bookId);
        //设置用户编号
        shoppingCar.setUserId(getCurrentUser(session).getUserId());
        //设置图书数量
        shoppingCar.setBookNum(bookNum);

        //修改图书数量
        shoppingCarService.updateBookNum(bookId, shoppingCar);

        //重定向到我的购物车
        return "redirect:/shoppingCar/myShoppingcar";
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

}
