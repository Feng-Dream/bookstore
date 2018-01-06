package com.zking.bookstore.mapper;

/**
 * @Description 文件数据访问对象扩展类
 * @Author Zeng LongFeng
 * @CreateTime 2017-12-30 10:12
 * @Version 1.0
 */
public interface DocMapperCustom {

	/**
	 * 根据图书编号删除文件
	 * 
	 * @param docFwxx
	 * @return
	 */
	int deleteByDocBook(Integer docBook);
}
