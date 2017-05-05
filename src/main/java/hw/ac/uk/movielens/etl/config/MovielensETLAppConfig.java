package hw.ac.uk.movielens.etl.config;

import hw.ac.uk.movielens.etl.util.MovielensAppConstants;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <pre>
 * <b>Description : </b>
 * The Spring bean configuration for the Movielens ETL application.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "hw.ac.uk.movielens.etl", excludeFilters = { @ComponentScan.Filter(Configuration.class) })
@PropertySource({ "classpath:movielens-app-config.properties" })
public class MovielensETLAppConfig {

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Value("${db.driver.classname}")
    private String driverClass;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Bean(name = "appProperty")
    public static PropertySourcesPlaceholderConfigurer appProperty() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Instantiates and returns a data source with the given DB driver details.
     * 
     * @return
     * </pre>
     */
    @Bean
    public DataSource dataSource() {
        BasicDataSource datasource = new BasicDataSource();
        datasource.setDriverClassName(driverClass);
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDefaultAutoCommit(false);
        return datasource;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Instantiates and return the session factory object to be used by Hibernate.
     * 
     * @return
     * @throws Exception
     * </pre>
     */
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory() throws Exception {
        Properties properties = new Properties();
        properties.put(MovielensAppConstants.HIBERNATE_DIALECT_PROPERTY, hibernateDialect);
        properties.put(MovielensAppConstants.HIBERNATE_SHOW_SQL_PROPERTY, "true");
        properties.put(MovielensAppConstants.HIBERNATE_CURRENT_SESSION_CONTEXT_CLASS_PROPERTY, "thread");
        properties.put("dynamic-update", "true");
        properties.put("shutdown", "false");
        properties.put("hibernate.hbm2ddl.auto", "update");
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(dataSource());
        factory.setHibernateProperties(properties);
        factory.setPackagesToScan("hw.ac.uk.movielens.etl.entities");
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Returns the instance of transaction manager to be used by Hibernate.
     * 
     * @return
     * @throws Exception
     * </pre>
     */
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager() throws Exception {
        return new HibernateTransactionManager(getSessionFactory());
    }

}
