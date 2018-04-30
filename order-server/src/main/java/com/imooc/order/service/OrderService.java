/**
 * @program: order
 * @description:
 * @author: Francis
 * @create: 2018-04-13 11:03
 **/

package com.imooc.order.service;

import com.imooc.order.dto.OrderDto;

public interface OrderService {

    /**
     * 创建订单
     * @param orderDto
     * @return
     */
    OrderDto create(OrderDto orderDto);

    /**
     * 完结订单（只能卖家操作）
     * @param orderId
     * @return
     */
    OrderDto finish(String orderId);
}
