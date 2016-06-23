package com.order.bo;

import com.order.bo.exception.BOException;
import com.order.dto.Order;


/**
 * Created by thangnguyen-imac on 6/23/16.
 */
public interface OrderBO {

    boolean placeOrder(Order order) throws BOException;

    boolean cancelOrder(int orderId)throws BOException;

    boolean deleteOrder(int orderId)throws BOException;
}
