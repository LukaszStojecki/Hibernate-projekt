package Dao;

import Entity.MovieEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class MovieEntityDao {

    private static SessionFactory sessionFactory;

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

    public void save(MovieEntity movieEntity) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(movieEntity);
            MovieEntity movieEntity1 = session.get(MovieEntity.class,movieEntity.getId());
            if (movieEntity.getTitle().equals(movieEntity1.getTitle())){
                movieEntity1.setTitle("TOPPER");
            }
            session.saveOrUpdate(movieEntity1);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MovieEntity> readAll() {
        List<MovieEntity> entities = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<MovieEntity> entities1 = session.createQuery("FROM MovieEntity");
            entities = entities1.list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return entities;
    }

    public void delete(MovieEntity movieEntity) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            MovieEntity deleteMovie = session.get(MovieEntity.class,movieEntity.getId());
            session.delete(deleteMovie);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

