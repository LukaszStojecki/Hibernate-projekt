package Dao;

import Entity.MovieEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class MovieEntityDao {


    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        MovieEntityDao dao = new MovieEntityDao();
        MovieEntity movieEntity = new MovieEntity("Top Gun","Tony Scott","USA",1986);
        //zad5
        Integer id = dao.save(movieEntity);
        //zad 6
        List<MovieEntity> entities = dao.readAll();
        entities.forEach(System.out::println);
    }

    public MovieEntityDao() {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        try {
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(MovieEntity.class)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Integer save(MovieEntity movieEntity) {
        Session session = null;
        Integer id = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            id = (Integer) session.save(movieEntity);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    public List<MovieEntity> readAll() {
        Session session = null;
        List<MovieEntity> entities = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            Query<MovieEntity> query = session.createQuery("FROM MovieEntity");
            entities = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return entities;
    }

}

