package com.zking.bookstore.service;

import com.zking.bookstore.model.Order;
import com.zking.bookstore.model.OrderShipping;
import com.zking.bookstore.utils.PageBean;

import java.util.List;

/**
 * 订单业务接口
 *
 * @Author LongFeng Zeng
 * @CreateTime 2018/1/7 19:59
 * @Version 1.0
 */
public interface IOrderService {
    /**
     * 查询全部订单
     *
     * @param order    订单信息
     * @param pageBean 分页Bean
     * @return 订单集合
     */
    List<Order> selectAll(Order order, PageBean pageBean);

    /**
     * 新增订单
     *
     * @param order         订单信息
     * @param orderShipping 订单发货
     * @param bookId        图书编号
     */
    void insert(Order order, OrderShipping orderShipping, Long bookId);
}
