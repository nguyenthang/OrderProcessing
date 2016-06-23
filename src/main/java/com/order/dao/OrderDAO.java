package com.order.dao;

import com.order.dto.Order;

import java.sql.SQLException;

/**
 * Created by thangnguyen-imac on 6/23/16.
 */
public interface OrderDAO {

    int create(Order order) throws SQLException;

    Order read(int id) throws SQLException;

    int update(Order order) throws SQLException;

    int delete(int id) throws SQLException;

}
