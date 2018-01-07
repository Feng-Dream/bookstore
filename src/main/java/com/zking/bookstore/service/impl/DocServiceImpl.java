package com.zking.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zking.bookstore.mapper.DocMapper;
import com.zking.bookstore.model.Doc;
import com.zking.bookstore.service.IDocService;

/**
 * 文件上传业务接口实现类
 *
 * @Author Zeng LongFeng
 * @CreateTime 2017-12-29 19:02
 * @Version 1.0
 */
@Service
public class DocServiceImpl implements IDocService {

    @Autowired
    private DocMapper docMapper;

    @Override
    public void deleteByPrimaryKey(String docid) {
        docMapper.deleteByPrimaryKey(docid);
    }

    @Override
    public void insert(Doc doc) {
        docMapper.insert(doc);
    }

    @Override
    public Doc selectByPrimaryKey(String docid) {
        return docMapper.selectByPrimaryKey(docid);
    }

    @Override
    public void updateByPrimaryKey(String docid, Doc doc) {
        doc.setDocid(docid);// 设置文件编号
        docMapper.updateByPrimaryKey(doc);
    }
}
