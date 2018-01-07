package com.zking.bookstore.mapper;

import com.zking.bookstore.model.ShoppingCar;

import java.util.List;

/**
 * 购物车数据访问对象扩展类
 *
 * @Author LongFeng Zeng
 * @CreateTime 2018-01-06 20:24
 * @Version 1.0
 */
public interface ShoppingCarMapperCustom {
    /**
     * 查询用户的购物车
     *
     * @param userId 用户编号
     * @return 购物车集合
     */
    List<ShoppingCar> selectByUserId(Long userId);

    /**
     * 清空用户的购物车
     *
     * @param userId 用户编号
     */
    void deleteByUserId(Long userId);

    /**
     * 根据用户编号和图书编号查询购物车
     *
     * @param shoppingCar 购物车(包含用户编号和图书编号)
     */
    ShoppingCar selectByUserIdAndBookId(ShoppingCar shoppingCar);

    /**
     * 修改图书数量
     *
     * @param shoppingCar 购物车信息
     */
    void updateBookNum(ShoppingCar shoppingCar);


    /**
     * 据用户编号和图书编号删除购物车
     *
     * @param shoppingCar
     */
    void deleteByUserIdAndBookId(ShoppingCar shoppingCar);
}
