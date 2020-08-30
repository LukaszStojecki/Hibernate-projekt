package dao;

import entity.Movie;
import configuration.HibernateConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovieDao {

    public void save(Movie movie) {

        Session session = null;
        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(movie);
            transaction.commit();
        }
        finally {
            session.close();
        }
    }

    public List<Movie> readAll() {
        List<Movie> entities = new ArrayList<>();
        Session session = null;
        try{
            session = HibernateConfiguration.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query<Movie> entities1 = session.createQuery("FROM Movie");
            entities = entities1.list();
            transaction.commit();
        } finally {
            if (session !=null){
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
            query.setParameter("Title",title);
            query.executeUpdate();
            transaction.commit();
        } finally {
            if (session !=null){
                session.close();
            }
        }
    }

    public Movie getMovieByTitle(String title) {
        Movie movie;
        Session session = null;
        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            movie = session.get(Movie.class, title);
            return movie;

        } finally {
            session.close();
        }
    }
}

