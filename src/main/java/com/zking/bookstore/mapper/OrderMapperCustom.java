package com.zking.bookstore.mapper;

import com.zking.bookstore.model.Order;

import java.util.List;

public interface OrderMapperCustom {
    /**
     * 查询全部订单
     *
     * @param order 订单信息
     * @return 订单集合
     */
    List<Order> selectAll(Order order);

    void updateTotalPriceByPrimaryKey(Order order);
}
