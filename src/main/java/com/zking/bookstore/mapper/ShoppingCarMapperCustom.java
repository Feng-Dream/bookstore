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
    List<ShoppingCar> selectAll(Long userId);
}
