package dao;

import configuration.HibernateConfiguration;
import entity.Actor;
import entity.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MovieDao {

    //private SessionFactory sessionFactory;

//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    public void save(Movie movie) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(movie);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Movie> readAll() {
        List<Movie> entities = new ArrayList<>();
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query<Movie> entities1 = session.createQuery("FROM Movie");
            entities = entities1.list();
            List<Movie> movies = entities1.getResultList();
            movies.forEach(System.out::println);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return entities;
    }

    public void delete(String title) {
        Session session = null;
        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("delete from Movie where Title = :Title");
            query.setParameter("Title", title);
            query.executeUpdate();
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void getActorsFromMovie(Actor actor) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT m FROM Movie m JOIN m.actors a WHERE a.lastName = :lastName");
            query.setParameter("lastName", actor.getLastName());
            List<Movie> listResult = query.getResultList();
            listResult.forEach(r -> System.out.println(r.getTitle()));
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
}

