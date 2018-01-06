package com.zking.bookstore.mapper;

import com.zking.bookstore.model.Book;

public interface BookMapper {
	int deleteByPrimaryKey(Long bookId);

	int insert(Book record);

	int insertSelective(Book record);

	Book selectByPrimaryKey(Long bookId);

	int updateByPrimaryKeySelective(Book record);

	int updateByPrimaryKeyWithBLOBs(Book record);

	int updateByPrimaryKey(Book record);
}