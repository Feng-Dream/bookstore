package com.zking.bookstore.service;

import com.zking.bookstore.model.Doc;

/**
 * @Description 文件上传业务接口
 * @Author Zeng LongFeng
 * @CreateTime 2017/12/29 19:01
 * @Version 1.0
 */
public interface IDocService {

	/**
	 * 根据主键(文件编号)删除文件
	 * 
	 * @param docid
	 *            文件编号
	 */
	void deleteByPrimaryKey(String docid);

	/**
	 * 新增文件
	 * 
	 * @param doc
	 *            文件信息
	 */
	void insert(Doc doc);

	/**
	 * 根据主键(文件编号)查询文件完整信息
	 * 
	 * @param docid
	 *            文件编号
	 * @return 文件完整信息
	 */
	Doc selectByPrimaryKey(String docid);

	/**
	 * 根据主键(文件编号)修改文件
	 * 
	 * @param docid
	 *            文件编号
	 * @param doc
	 *            文件信息
	 */
	void updateByPrimaryKey(String docid, Doc doc);
}
