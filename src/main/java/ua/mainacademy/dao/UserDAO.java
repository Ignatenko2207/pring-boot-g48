package ua.mainacademy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.mainacademy.factory.HibernateSessionFactory;
import ua.mainacademy.model.User;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
public class UserDAO extends BaseDAO<User> {

    @Autowired
    public UserDAO(HibernateSessionFactory hibernateSessionFactory) {
        super(hibernateSessionFactory);
    }

    public Optional<User> findOneByLoginAndPassword(String login, String password) {
        if (isBlank(login) || isBlank(password)) {
            return Optional.empty();
        }
        SessionFactory sessionFactory = super.getHibernateSessionFactory().getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        String sql = "" +
                "SELECT * " +
                "FROM users " +
                "WHERE login=?1 AND password=?2";
        Query query = session.createNativeQuery(sql, User.class);
        query.setParameter(1, login);
        query.setParameter(2, password);
        Optional result = Optional.of(query.getSingleResult());
        session.close();
        return result;
    }

    public List<User> findAllByLogin(String login) {
        if (isBlank(login)) {
            throw new RuntimeException("Login can not be null!");
        }
        SessionFactory sessionFactory = super.getHibernateSessionFactory().getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        String sql = "" +
                "SELECT * " +
                "FROM users " +
                "WHERE login=?1";
        Query query = session.createNativeQuery(sql, User.class);
        query.setParameter(1, login);
        List<User> result = query.getResultList();
        session.close();
        return result;
    }

}
