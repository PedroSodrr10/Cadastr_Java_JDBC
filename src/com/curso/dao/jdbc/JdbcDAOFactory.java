package com.curso.dao.jdbc;

import com.curso.dao.ClienteDAO;
import com.curso.dao.DAOFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcDAOFactory extends DAOFactory {

    private Connection connection;

    public JdbcDAOFactory(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/cadastro_cliente", "root","root");

        } catch(Exception e){
            throw new RuntimeException("Erro recuperando conexao com o banco.", e);
        }
    }

    @Override
    public ClienteDAO getClienteDAO() {
        return new JdbcClienteDAO(connection);
    }
}
