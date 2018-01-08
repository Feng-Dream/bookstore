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

    /**
     * 根据主键 (订单编号) 修改订单总价
     *
     * @param order 订单信息 (包含订单编号和订单总价)
     */
    void updateTotalPriceByPrimaryKey(Order order);

    /**
     * 根据主键 (订单编号) 修改订单状态
     *
     * @param order 订单信息 (包含订单编号和订单状态)
     */
    void updateStatusByPrimaryKey(Order order);

    /**
     * 假删
     *
     * @param order 订单信息 (包含订单编号和是否删除)
     */
    void doFalseDel(Order order);
}
