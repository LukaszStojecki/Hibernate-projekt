package dao;

import entity.Movie;
import configuration.HibernateConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MovieDao {

    public void save(Movie movie) {
        try {
            Session session = HibernateConfiguration.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(movie);
//            transaction.commit();
//            transaction = session.beginTransaction();
//            Movie movie1 = session.get(Movie.class, movie.getId());
//            if (movie.getTitle().equals(movie1.getTitle())){
//                movie.setTitle("TOPPER");
//            }
//            session.saveOrUpdate(movie1);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Movie> readAll() {
        List<Movie> entities = new ArrayList<>();
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Query<Movie> entities1 = session.createQuery("FROM Movie");
            entities = entities1.list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return entities;
    }

    public void delete(String title) {
        try {
            Session session = HibernateConfiguration.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("delete from Movie where Title = :Title");
            query.setParameter("Title",title);
            query.executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

