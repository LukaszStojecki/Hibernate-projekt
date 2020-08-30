package dao;

import configuration.HibernateConfiguration;
import entity.Actor;
import entity.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.w3c.dom.html.HTMLDOMImplementation;

import javax.persistence.Query;
import java.util.Calendar;
import java.util.List;

public class ActorDao {

    public void getActorWithMovies(Actor actor) {
        Session session = null;
        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            Query query = session.createQuery("SELECT m FROM Movie m JOIN m.actors c WHERE c.lastName = :lastName");
            query.setParameter("lastName", actor.getLastName());
            List<Movie> movieList = query.getResultList();
            movieList.forEach(movie -> System.out.println(movie.getTitle()));

        } finally {
            session.close();
        }
    }
}
