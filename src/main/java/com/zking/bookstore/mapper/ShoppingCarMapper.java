package com.zking.bookstore.mapper;

import com.zking.bookstore.model.ShoppingCar;

public interface ShoppingCarMapper {
    int deleteByPrimaryKey(Long shoppingcarId);

    int insert(ShoppingCar record);

    int insertSelective(ShoppingCar record);

    ShoppingCar selectByPrimaryKey(Long shoppingcarId);

    int updateByPrimaryKeySelective(ShoppingCar record);

    int updateByPrimaryKey(ShoppingCar record);
}