package com.evdelacruz.samples.dataentitymanager.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;

@Configuration
@ComponentScan("com.evdelacruz.samples.dataentitymanager.service")
public class DataSourceContext {

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setJdbcUrl(String.format("jdbc:postgresql://%s/%s", "localhost", "dataentitymanager"));
        dataSource.setUsername("user");
        dataSource.setPassword("pass");
        dataSource.setMaximumPoolSize(10);
        dataSource.setConnectionTimeout(5000);
        dataSource.setMaxLifetime(1200000);
        dataSource.setPoolName("pool-connections");
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
        vendor.setGenerateDdl(false);
        vendor.setShowSql(false);
        vendor.setDatabase(Database.POSTGRESQL);
        return vendor;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean manager = new LocalContainerEntityManagerFactoryBean();
        manager.setDataSource(dataSource());
        manager.setPackagesToScan("com.evdelacruz.samples.dataentitymanager.service.datasource.domain");
        manager.setMappingResources("com/evdelacruz/samples/dataentitymanager/service/datasource/queries/Queries.xml");
        manager.setJpaVendorAdapter(vendorAdapter());
        return manager;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory().getObject());
        manager.setJpaDialect(new HibernateJpaDialect());
        return manager;
    }
}
