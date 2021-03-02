package ua.mainacademy.factory.impl;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ua.mainacademy.factory.HibernateSessionFactory;
import ua.mainacademy.model.Item;
import ua.mainacademy.model.Order;
import ua.mainacademy.model.OrderItem;
import ua.mainacademy.model.User;

import java.util.Properties;

import static java.util.Objects.isNull;

public class H2SessionFactory implements HibernateSessionFactory {

    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getHibernateSessionFactory() {
        if (isNull(sessionFactory)) {
            Configuration configuration = new Configuration();

            Properties properties = new Properties();
            properties.put("hibernate.connection.driver_class", "org.h2.Driver");
            properties.put("hibernate.connection.url", "jdbc:h2:~/spring-boot-g48");
            properties.put("hibernate.connection.username", "alex");
            properties.put("hibernate.connection.password", "123456");
            properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            properties.put("hibernate.hbm2ddl.auto", "update");
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.format_sql", "true");
            configuration.addProperties(properties);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).build();

            configuration.addAnnotatedClass(Item.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Order.class);
            configuration.addAnnotatedClass(OrderItem.class);

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }
        return sessionFactory;
    }

}
