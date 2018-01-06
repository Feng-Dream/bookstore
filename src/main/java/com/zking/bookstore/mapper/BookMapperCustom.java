package com.zking.bookstore.mapper;

import java.util.List;

import com.zking.bookstore.model.Book;

/**
 * 图书数据访问对象扩展类
 *
 * @Author Zeng LongFeng
 * @CreateTime 2017/1/4 15:20
 * @Version 1.0
 */
public interface BookMapperCustom {

	List<Book> selectAll(Book book);
}