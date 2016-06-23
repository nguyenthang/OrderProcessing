package com.order.bo;

import com.order.bo.exception.BOException;
import com.order.dao.OrderDAO;
import com.order.dto.Order;

import java.sql.SQLException;

/**
 * Created by thangnguyen-imac on 6/23/16.
 */
public class OrderBOImpl implements OrderBO {

    private OrderDAO orderDAO;

    public boolean placeOrder(Order order) throws BOException {
        try {
            int result = orderDAO.create(order);
            if(result == 0){
                return false;
            }
        } catch (SQLException e) {
            throw new BOException(e);
        }

        return true;
    }

    public boolean cancelOrder(int orderId) throws BOException {
        try {
            Order order = orderDAO.read(orderId);
            order.setStatus("cancelled");
            int result = orderDAO.update(order);
            if(result == 0){
                return  false;
            }
        } catch (SQLException e) {
            throw  new BOException(e);
        }
        return true;
    }

    public boolean deleteOrder(int orderId) throws BOException {

        try {
            int result = orderDAO.delete(orderId);
            if(result == 0){
                return false;
            }
        } catch (SQLException e) {
            throw new BOException(e);
        }
        return true;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
