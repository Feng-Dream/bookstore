package com.zking.bookstore.service;

import com.zking.bookstore.model.ShoppingCar;

import java.util.List;

/**
 * 购物车业务接口
 *
 * @Author LongFeng Zeng
 * @CreateTime 2018/1/6 21:12
 * @Version 1.0
 */
public interface IShoppingCarService {

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
     * 添加
     *
     * @param shoppingCar 购物车信息
     */
    void insert(ShoppingCar shoppingCar);

    /**
     * 根据图书编号修改
     *
     * @param bookId      图书编号
     * @param shoppingCar 购物车信息
     */
    void updateBookNum(Long bookId, ShoppingCar shoppingCar);

    /**
     * 根据用户编号和图书编号查询购物车
     *
     * @param shoppingCar 购物车(包含用户编号和图书编号)
     */
    ShoppingCar selectByUserIdAndBookId(ShoppingCar shoppingCar);

    /**
     * 据用户编号和图书编号删除购物车
     *
     * @param shoppingCar
     */
    void deleteByUserIdAndBookId(ShoppingCar shoppingCar);
}
