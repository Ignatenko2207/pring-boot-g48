//package ua.mainacademy.factory.impl;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import ua.mainacademy.factory.HibernateSessionFactory;
//import ua.mainacademy.model.Item;
//import ua.mainacademy.model.Order;
//import ua.mainacademy.model.OrderItem;
//import ua.mainacademy.model.User;
//
//import static java.util.Objects.isNull;
//
//public class PostgresSessionFactory implements HibernateSessionFactory {
//
//    private SessionFactory sessionFactory;
//
//    @Override
//    public SessionFactory getHibernateSessionFactory() {
//        if (isNull(sessionFactory)) {
//            Configuration configuration = new Configuration();
//
//            configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
//            configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/spring-boot-48");
//            configuration.setProperty("hibernate.connection.username", "postgres");
//            configuration.setProperty("hibernate.connection.password", "248842");
//            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
//            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
//            configuration.setProperty("hibernate.show_sql", "true");
//            configuration.setProperty("hibernate.format_sql", "true");
//
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
//                    applySettings(configuration.getProperties()).build();
//
//            configuration.addAnnotatedClass(Item.class);
//            configuration.addAnnotatedClass(User.class);
//            configuration.addAnnotatedClass(Order.class);
//            configuration.addAnnotatedClass(OrderItem.class);
//
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            return sessionFactory;
//        }
//        return sessionFactory;
//    }
//}
