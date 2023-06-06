package com.alura.api.infra;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.*;
import javax.sql.*;

public class DatabaseConfig {
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUsername;
    @Value("${spring.datasource.password}")
    private String dbPassword;
    @Bean
    public DataSource dataSource(){

        // Configurar el origen de datos utilizando DriverManagerDataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        // Establecer el controlador de base de datos
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // Establecer la URL de la base de datos, el nombre de usuario y la contraseña
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);

        return dataSource;
    }
}