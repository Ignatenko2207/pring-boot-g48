package ua.mainacademy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.mainacademy.factory.HibernateSessionFactory;
import ua.mainacademy.model.Order;

import javax.persistence.Query;

@Component
public class OrderDAO extends BaseDAO<Order>{

    @Autowired
    public OrderDAO(HibernateSessionFactory hibernateSessionFactory) {
        super(hibernateSessionFactory);
    }

    public Order finddOpenOrderByUserId(Integer userId) {
        SessionFactory sessionFactory = super.getHibernateSessionFactory().getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        String sql = "" +
                "SELECT * " +
                "FROM orders " +
                "WHERE user_id=?1 " +
                "AND status=?2";
        Query query = session.createNativeQuery(sql, Order.class);
        query.setParameter(1, userId);
        query.setParameter(2, 0);
        Order result = (Order) query.getSingleResult();
        session.close();
        return result;
    }
}
