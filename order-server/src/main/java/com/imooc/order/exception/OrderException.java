/**
 * @program: order
 * @description:
 * @author: Francis
 * @create: 2018-04-13 11:36
 **/

package com.imooc.order.exception;

import com.imooc.order.enums.ResultEnum;

public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
