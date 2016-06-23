package com.order.bo.exception;

import java.sql.SQLException;

/**
 * Created by thangnguyen-imac on 6/23/16.
 */
public class BOException extends Exception {
    public BOException(SQLException e) {
        super(e);
    }
}
