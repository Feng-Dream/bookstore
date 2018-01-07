package com.zking.bookstore.service.impl;

import com.zking.bookstore.mapper.ShoppingCarMapper;
import com.zking.bookstore.mapper.ShoppingCarMapperCustom;
import com.zking.bookstore.model.ShoppingCar;
import com.zking.bookstore.service.IShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购物车业务接口实现类
 *
 * @Author LongFeng Zeng
 * @CreateTime 2018-01-06 21:12
 * @Version 1.0
 */
@Service
public class ShoppingCarServiceImpl implements IShoppingCarService {

    @Autowired
    private ShoppingCarMapperCustom shoppingCarMapperCustom;
    @Autowired
    private ShoppingCarMapper shoppingCarMapper;

    @Override
    public List<ShoppingCar> selectByUserId(Long userId) {
        return shoppingCarMapperCustom.selectByUserId(userId);
    }

    @Override
    public void deleteByUserId(Long userId) {
        shoppingCarMapperCustom.deleteByUserId(userId);
    }

    @Override
    public void insert(ShoppingCar shoppingCar) {
        shoppingCarMapper.insert(shoppingCar);
    }

    @Override
    public void updateBookNum(Long bookId, ShoppingCar shoppingCar) {
        shoppingCar.setBookId(bookId);
        shoppingCarMapperCustom.updateBookNum(shoppingCar);
    }

    @Override
    public ShoppingCar selectByUserIdAndBookId(ShoppingCar shoppingCar) {
        return shoppingCarMapperCustom.selectByUserIdAndBookId(shoppingCar);
    }

    @Override
    public void deleteByUserIdAndBookId(ShoppingCar shoppingCar) {
        shoppingCarMapperCustom.deleteByUserIdAndBookId(shoppingCar);
    }
}
