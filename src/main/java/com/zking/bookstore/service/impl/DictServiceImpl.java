package com.zking.bookstore.service.impl;

import com.zking.bookstore.mapper.DictMapperCustom;
import com.zking.bookstore.model.Dict;
import com.zking.bookstore.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典业务接口实现类
 *
 * @Author Zeng LongFeng
 * @CreateTime 2017-12-28 15:10
 * @Version 1.0
 */
@Service
public class DictServiceImpl implements IDictService {

    @Autowired
    private DictMapperCustom dictMapperCustom;

    @Override
    public Dict selectByDictNameAndValue(Dict dict) {
        return dictMapperCustom.selectByDictNameAndValue(dict);
    }

    @Override
    public List<Dict> selectAllByDictName(String dictName) {
        return dictMapperCustom.selectAllByDictName(dictName);
    }
}
