package org.example.config;

import org.example.model.User;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "org.example")
public class Database {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/auth");
        ds.setUsername("root");
        ds.setPassword("");
        return ds;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean (){
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(dataSource());
        sf.setHibernateProperties(hibernateProperties());
        sf.setAnnotatedClasses(User.class);
        return sf;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MariaDBDialect");
        properties.put("hibernate.show_sql",true);
//        properties.put("hibernate.format_sql",true);
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

    @Bean
    public HibernateTemplate hibernateTemplate(SessionFactory sf){
        HibernateTemplate ht = new HibernateTemplate();
        ht.setSessionFactory(sf);
        ht.setCheckWriteOperations(false);
        return ht;
    }

    @Bean
    public HibernateTransactionManager
            hibernateTransactionManager(SessionFactory sf){
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sf);
        return htm;
    }
}
