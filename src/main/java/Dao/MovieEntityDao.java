package Dao;

import Entity.MovieEntity;
import org.hibernate.SessionFactory;

import java.util.List;

public class MovieEntityDao {

    private SessionFactory sessionFactory;

    public static void main(String[] args) {

        MovieEntity movieEntity = new MovieEntity("Top Gun","Tony Scott","USA",1986);


    }

    public  void save(){



    }

}
