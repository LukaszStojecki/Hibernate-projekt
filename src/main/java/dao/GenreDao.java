package dao;

import configuration.HibernateConfiguration;
import entity.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenreDao {

    public void getGenres(Movie movie){

//    Session session = null;
//        try {
//            session = HibernateConfiguration.getSessionFactory().openSession();
//            Transaction transaction = session.beginTransaction();
//            Movie movies = session.get(Movie.class, movie.getTitle());
//            movies.getGenreTypes().forEach(genre -> System.out.println(genre.getGenreType()));
//            transaction.commit();
//        }catch (Exception e){
//            if (session != null){
//                session.close();
//        }
//
//        }
    }
}
