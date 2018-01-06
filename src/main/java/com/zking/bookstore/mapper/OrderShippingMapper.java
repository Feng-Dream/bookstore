package com.zking.bookstore.mapper;

import com.zking.bookstore.model.OrderShipping;

public interface OrderShippingMapper {
    int deleteByPrimaryKey(Long orderShippingId);

    int insert(OrderShipping record);

    int insertSelective(OrderShipping record);

    OrderShipping selectByPrimaryKey(Long orderShippingId);

    int updateByPrimaryKeySelective(OrderShipping record);

    int updateByPrimaryKey(OrderShipping record);
}