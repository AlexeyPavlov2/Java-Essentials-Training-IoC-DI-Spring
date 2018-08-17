package com.spring.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

import static com.spring.training.config.AppConstants.*;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.spring.training.**"})
@ComponentScan(value = "com.spring.training.**")

public class AppConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);

        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setUrl(DATABASE_IN_MEMORY_CONNECTION_URL);

        Resource initSchema = new ClassPathResource(INIT_DATABASE_SCRIPT);
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);

        Resource populateSchema = new ClassPathResource(POPULATE_DATABASE_SCRIPT);
        databasePopulator = new ResourceDatabasePopulator(populateSchema);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);
        return dataSource;
    }

    @Bean
    public Properties hibernateProperties(){
        final Properties properties = new Properties();

        properties.put( "hibernate.dialect", DATABASE_DIALECT );
        properties.put( "hibernate.connection.driver_class", DRIVER_CLASS_NAME);
        properties.put( "hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);
        //properties.p

        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(DATABASE_TYPE);
        //vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
        emFactory.setJpaVendorAdapter(vendorAdapter);
        emFactory.setPackagesToScan("com.spring.training.**");
        emFactory.setDataSource(dataSource());
        emFactory.setJpaProperties(hibernateProperties());
        return emFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
