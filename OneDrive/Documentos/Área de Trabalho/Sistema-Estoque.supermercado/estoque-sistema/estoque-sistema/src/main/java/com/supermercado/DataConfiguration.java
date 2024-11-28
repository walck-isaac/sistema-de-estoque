package com.supermercado;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource; 
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;

@Configuration
public class DataConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/estoque_supermercado");
        dataSource.setUsername("root");
        dataSource.setPassword("Javaspringboot@23");
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL); // Definindo o banco como MySQL
        adapter.setShowSql(true); // Corrigido o método de exibição de SQL
        adapter.setGenerateDdl(true); // Gerar DDL automaticamente
        adapter.setDatabasePlatform("org.hibernate.dialect.MariaDBDialect"); // Dialeto para MariaDB/MySQL
        return adapter;
    }
}
