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
}
