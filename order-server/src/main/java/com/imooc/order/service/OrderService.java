/**
 * @program: order
 * @description:
 * @author: Francis
 * @create: 2018-04-13 11:03
 **/

package com.imooc.order.service;

import com.imooc.order.dto.OrderDto;

public interface OrderService {

    OrderDto create(OrderDto orderDto);
}
