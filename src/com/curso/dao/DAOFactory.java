package com.curso.dao;

import com.curso.dao.jdbc.JdbcDAOFactory;

public abstract class DAOFactory {

    public static DAOFactory getDAOFactory(){
        return new JdbcDAOFactory();
    }

    public abstract ClienteDAO getClienteDAO();
}
