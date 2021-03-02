package ua.mainacademy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.mainacademy.factory.HibernateSessionFactory;
import ua.mainacademy.model.OrderItem;

@Component
public class OrderItemDAO extends BaseDAO<OrderItem>{

    @Autowired
    public OrderItemDAO(HibernateSessionFactory hibernateSessionFactory) {
        super(hibernateSessionFactory);
    }
}
