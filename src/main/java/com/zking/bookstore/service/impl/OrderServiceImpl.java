package com.zking.bookstore.service.impl;

import com.zking.bookstore.mapper.*;
import com.zking.bookstore.model.*;
import com.zking.bookstore.service.IOrderService;
import com.zking.bookstore.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单业务接口实现类
 *
 * @Author LongFeng Zeng
 * @CreateTime 2018-01-07 19:58
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderMapperCustom orderMapperCustom;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private OrderShippingMapper orderShippingMapper;
    @Autowired
    private ShoppingCarMapperCustom shoppingCarMapperCustom;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Order> selectAll(Order order, PageBean pageBean) {
        return orderMapperCustom.selectAll(order);
    }

    @Override
    public void insert(Order order, OrderShipping orderShipping, Long bookId) {
        //新增订单 (得到订单编号 存在 orderId 属性中).
        orderMapper.insert(order);
        //设置订单编号
        orderShipping.setOrderId(order.getOrderId());
        //新增订单发货
        orderShippingMapper.insert(orderShipping);

        if (null == bookId) {
            //查询购物车
            List<ShoppingCar> shoppingCarList = shoppingCarMapperCustom.selectByUserId(order.getUserId());
            if (null != shoppingCarList) {
                //订单总价
                Float totalPrice = 0.00F;
                OrderItem orderItem = null;
                //遍历购物车
                for (ShoppingCar shoppingCar : shoppingCarList) {
                    //创建订单项
                    orderItem = new OrderItem();
                    //设置订单编号
                    orderItem.setOrderId(order.getOrderId());
                    //设置图书编号
                    orderItem.setBookId(shoppingCar.getBookId());
                    //设置图书价格
                    orderItem.setBookPrice(shoppingCar.getBook().getBookPrice());
                    //设置图书数量
                    orderItem.setBookNum(shoppingCar.getBookNum());
                    //设置图书总价
                    orderItem.setTotalFee(shoppingCar.getBook().getBookPrice() * shoppingCar.getBookNum());

                    //新增订单项
                    orderItemMapper.insert(orderItem);

                    //计算订单总价
                    totalPrice += orderItem.getTotalFee();
                }
                //设置订单总价
                order.setTotalPrice(totalPrice);
                //修改订单总价
                orderMapperCustom.updateTotalPriceByPrimaryKey(order);
            }
        } else {
            //查询图书的详细信息
            Book book = bookMapper.selectByPrimaryKey(bookId);
            //创建订单项
            OrderItem orderItem = new OrderItem();
            //设置订单编号
            orderItem.setOrderId(order.getOrderId());
            //设置图书编号
            orderItem.setBookId(bookId);
            //设置图书价格
            orderItem.setBookPrice(book.getBookPrice());
            //设置图书数量
            orderItem.setBookNum(1);
            //设置图书总价
            orderItem.setTotalFee(book.getBookPrice());

            //新增订单项
            orderItemMapper.insert(orderItem);

            //设置订单总价
            order.setTotalPrice(book.getBookPrice());
            //修改订单总价
            orderMapperCustom.updateTotalPriceByPrimaryKey(order);
        }

        //清空购物车
        shoppingCarMapperCustom.deleteByUserId(order.getUserId());
    }
}
