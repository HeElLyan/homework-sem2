package com.he.springios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
//(basePackages = "com.he")
@ComponentScan(basePackages = "com.he")
//@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages = "com.he")
public class AppConfig {

//    @Autowired
//    private Environment environment;

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        vendorAdapter.setShowSql(Boolean.FALSE);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.he");
        factory.setDataSource(driverManagerDataSource());
        factory.afterPropertiesSet();
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        return factory.getObject();
    }

    @Bean
    public DataSource driverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/javalab_spring_homework1?useUnicode=true&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("vjhrjdm[fym");
        return dataSource;
    }

//    @Bean
//    public HikariConfig hikariConfig() {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl(environment.getProperty("db.url"));
//        config.setUsername(environment.getProperty("db.username"));
//        config.setPassword(environment.getProperty("db.password"));
//        config.setDriverClassName(environment.getProperty("db.driverClassName"));
//        return config;
//    }
//
//    @Bean
//    public DataSource hikariDataSource() {
//        return new HikariDataSource(hikariConfig());
//    }

}
