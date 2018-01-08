package com.zking.bookstore.mapper;

import com.zking.bookstore.model.Book;

import java.util.List;

/**
 * 图书数据访问对象扩展类
 *
 * @Author Zeng LongFeng
 * @CreateTime 2017/1/4 15:20
 * @Version 1.0
 */
public interface BookMapperCustom {


    /**
     * 查询全部图书
     *
     * @param book 图书信息
     * @return 图书集合
     */
    List<Book> selectAll(Book book);

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
}