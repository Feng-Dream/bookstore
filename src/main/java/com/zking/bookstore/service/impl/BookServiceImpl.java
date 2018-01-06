package com.zking.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zking.bookstore.mapper.BookMapper;
import com.zking.bookstore.mapper.BookMapperCustom;
import com.zking.bookstore.model.Book;
import com.zking.bookstore.service.IBookService;
import com.zking.bookstore.utils.PageBean;

/**
 * 图书业务接口实现类
 *
 * @Author Zeng LongFeng
 * @CreateTime 2017/12/28 15:20
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private BookMapperCustom bookMapperCustom;

	@Override
	public List<Book> selectAll(Book book, PageBean pageBean) {
		return bookMapperCustom.selectAll(book);
	}

	@Override
	public Book selectByPrimaryKey(Long bookId) {
		return bookMapper.selectByPrimaryKey(bookId);
	}

	@Override
	public void insert(Book book) {
		bookMapper.insert(book);
	}

	@Override
	public void updateByPrimaryKey(Long bookId, Book book) {
		book.setBookId(bookId);// 设置图书编号
		bookMapper.updateByPrimaryKey(book);
	}

	@Override
	public void deleteByPrimaryKey(Long bookId) {
		bookMapper.deleteByPrimaryKey(bookId);
	}

	@Override
	public void updateStatusByPrimaryKey(Long bookId, Book book) {
		book.setBookId(bookId);// 设置图书编号
		bookMapper.updateByPrimaryKeySelective(book);
	}

}
