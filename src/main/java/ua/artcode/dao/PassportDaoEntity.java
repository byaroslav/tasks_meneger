package ua.artcode.dao;

import ua.artcode.db.EntityFactory;
import ua.artcode.model.Passport;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Yaroslav on 23.12.2014.
 */
public class PassportDaoEntity {
    EntityManager entityManager = EntityFactory.getInstance();

    public void addPassport(Passport passport) {
        entityManager.getTransaction().begin();
        entityManager.persist(passport);
        entityManager.getTransaction().commit();
    }



    public Passport getPassport (String login) {
        Query query = entityManager.createQuery("SELECT p FROM Passport as p where p.login = :log");
        query.setParameter("log", login);
        List<Passport> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }
}
