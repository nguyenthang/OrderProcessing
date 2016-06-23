package com.order.junit;

import static org.junit.Assert.*;


import com.order.bo.OrderBOImpl;
import com.order.bo.exception.BOException;
import com.order.dao.OrderDAO;
import com.order.dto.Order;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.mockito.Mockito.*;
/**
 * Unit test for simple App.
 */
public class OrderBOTest
{
    public static final int ID = 123;
    @Mock
    OrderDAO dao;

    private OrderBOImpl orderBO;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        orderBO = new OrderBOImpl();
        orderBO.setOrderDAO(dao);
    }

    @Test
    public void place_order_should_create_an_order() throws BOException, SQLException {


        Order order  = new Order();
        when(dao.create(order)).thenReturn(new Integer(1));

        boolean result = orderBO.placeOrder(order);

        assertTrue(result);
        verify(dao).create(order);
    }

    @Test
    public void place_order_should_not_create_an_order() throws BOException, SQLException {


        Order order  = new Order();
        when(dao.create(order)).thenReturn(new Integer(0));

        boolean result = orderBO.placeOrder(order);

        assertFalse(result);
        verify(dao).create(order);
    }

    @Test(expected = BOException.class)
    public void place_order_should_throw_bo_exception() throws BOException, SQLException {

        Order order  = new Order();
        when(dao.create(order)).thenThrow(SQLException.class);

        boolean result = orderBO.placeOrder(order);
    }

    @Test
    public void  cancelOrder_should_Cancel_The_order() throws SQLException, BOException {
        Order order = new Order();
        when(dao.read(123)).thenReturn(order);
        when(dao.update(order)).thenReturn(1);

        boolean result = orderBO.cancelOrder(123);

        assertTrue(result);
        verify(dao).read(123);
        verify(dao).update(order);
    }

    @Test
    public void  cancelOrder_should_NOT_Cancel_The_order() throws SQLException, BOException {
        Order order = new Order();
        when(dao.read(123)).thenReturn(order);
        when(dao.update(order)).thenReturn(0);

        boolean result = orderBO.cancelOrder(123);

        assertFalse(result);
        verify(dao).read(123);
        verify(dao).update(order);
    }

    @Test(expected = BOException.class)
    public void  cancelOrder_should_throw_BOException_On_Read() throws SQLException, BOException {
        when(dao.read(123)).thenThrow(SQLException.class);
        orderBO.cancelOrder(123);
    }

    @Test(expected = BOException.class)
    public void  cancelOrder_should_Throw_BOExceptionUpdate() throws SQLException, BOException {
        Order order = new Order();
        when(dao.read(123)).thenReturn(order);
        when(dao.update(order)).thenThrow(SQLException.class);

        boolean result = orderBO.cancelOrder(123);
    }

    @Test
    public void  deleteOrder_deletes_the_order() throws SQLException, BOException {

        when(dao.delete(ID)).thenReturn(1);
        boolean result = orderBO.deleteOrder(123);
        assertTrue(result);
        verify(dao).delete(123);
    }
}
