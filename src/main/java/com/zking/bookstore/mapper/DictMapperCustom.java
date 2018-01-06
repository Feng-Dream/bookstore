package com.zking.bookstore.mapper;

import com.zking.bookstore.model.Dict;

import java.util.List;

/**
 * 字典数据访问对象扩展类
 *
 * @Author Zeng LongFeng
 * @CreateTime 2017/12/28 15:21
 * @Version 1.0
 */
public interface DictMapperCustom {

    Dict selectByDictNameAndValue(Dict dict);

    List<Dict> selectAllByDictName(String dictName);

}