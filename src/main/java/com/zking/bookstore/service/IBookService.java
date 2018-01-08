package com.zking.bookstore.service;

import com.zking.bookstore.model.Book;
import com.zking.bookstore.utils.PageBean;

import java.util.List;

/**
 * 图书业务接口
 *
 * @Author Zeng LongFeng
 * @CreateTime 2017/12/28 15:20
 * @Version 1.0
 */
public interface IBookService {

    /**
     * 查询全部图书(模糊查询、分页).
     *
     * @param book     图书信息
     * @param pageBean Bean
     * @return 全部图书的集合
     */
    List<Book> selectAll(Book book, PageBean pageBean);

    /**
     * 查询新书前五的图书
     *
     * @return 图书集合
     */
    List<Book> selectTop5NewBook();

    /**
     * 查询销量前五的图书
     *
     * @return 图书集合
     */
    List<Book> selectTop5SalesVolume();

    /**
     * 新增图书.
     *
     * @param book 图书信息
     */
    void insert(Book book);

    /**
     * 根据主键查询图书完整信息.
     *
     * @param bookId 主键(图书编号)
     * @return 图书完整信息
     */
    Book selectByPrimaryKey(Long bookId);

    /**
     * 根据主键(图书编号)修改图书信息
     *
     * @param bookId 主键(图书编号)
     * @param book   图书信息
     */
    void updateByPrimaryKey(Long bookId, Book book);

    /**
     * 根据主键(图书编号)删除图书
     *
     * @param bookId 主键(图书编号)
     */
    void deleteByPrimaryKey(Long bookId);

    /**
     * 根据主键(图书编号)修改图书状态
     *
     * @param bookId 主键(图书编号)
     * @param book   图书信息(包含图书状态)
     */
    void updateStatusByPrimaryKey(Long bookId, Book book);

}
