package ua.mainacademy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.mainacademy.factory.HibernateSessionFactory;
import ua.mainacademy.model.Item;

import javax.persistence.Query;
import java.util.List;

@Component
public class ItemDAO extends BaseDAO<Item>{

    @Autowired
    public ItemDAO(HibernateSessionFactory hibernateSessionFactory) {
        super(hibernateSessionFactory);
    }

    public List<Item> findAll() {
        SessionFactory sessionFactory = super.getHibernateSessionFactory().getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        String sql = "" +
                "SELECT * " +
                "FROM items";
        Query query = session.createNativeQuery(sql, Item.class);
        List<Item> result = query.getResultList();
        session.close();
        return result;
    }
}
