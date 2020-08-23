package configuration;

import Entity.MovieEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateConfiguration {

    private static Logger logger = LoggerFactory.getLogger(HibernateConfiguration.class);

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

//        Transaction transaction = session.beginTransaction();
//        MovieEntity movieEntity = new MovieEntity("Top Gun","Tony Scott","USA",1986);
//        session.save(movieEntity);
//        transaction.commit();
//        session.close();

    }

}
