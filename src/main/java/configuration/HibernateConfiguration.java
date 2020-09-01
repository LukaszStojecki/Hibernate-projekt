package configuration;

import entity.Actor;
import entity.Genre;
import entity.Movie;
import entity.Review;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null){
            try {
                sessionFactory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Genre.class)
                        .addAnnotatedClass(Movie.class)
                        .addAnnotatedClass(Actor.class)
                        .addAnnotatedClass(Review.class)
                        .buildSessionFactory();

            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
