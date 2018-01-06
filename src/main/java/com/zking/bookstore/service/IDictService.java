package com.zking.bookstore.service;

import com.zking.bookstore.model.Dict;

import java.util.List;

/**
 * 字典业务接口
 *
 * @Author Zeng LongFeng
 * @CreateTime 2017/12/28 15:20
 * @Version 1.0
 */
public interface IDictService {

	/**
	 * 根据字典名字和字典项值查询字典
	 * 
	 * @param dict
	 *            字典信息(包含字典名字和字典项值)
	 * @return 字典
	 */
	Dict selectByDictNameAndValue(Dict dict);

	/**
	 * 根据字典名字查询相关的所有字典
	 * 
	 * @param dictName
	 *            字典名字
	 * @return 所有的相关字典
	 */
	List<Dict> selectAllByDictName(String dictName);
}
