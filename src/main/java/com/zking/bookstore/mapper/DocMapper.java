package com.zking.bookstore.mapper;

import com.zking.bookstore.model.Doc;

public interface DocMapper {
    int deleteByPrimaryKey(String docid);

    int insert(Doc record);

    int insertSelective(Doc record);

    Doc selectByPrimaryKey(String docid);

    int updateByPrimaryKeySelective(Doc record);

    int updateByPrimaryKeyWithBLOBs(Doc record);

    int updateByPrimaryKey(Doc record);
}