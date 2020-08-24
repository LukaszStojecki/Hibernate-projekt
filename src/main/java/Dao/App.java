package Dao;

import Entity.MovieEntity;

import java.util.List;

public class App {

    public static void main(String[] args) {

        MovieEntityDao dao = new MovieEntityDao();
        MovieEntity movieEntity = new MovieEntity("Top Gun", "Tony Scott", "USA", 1986);
        //zad5
        dao.save(movieEntity);
        //zad6
        List<MovieEntity> movieEntitiesList = dao.readAll();
        movieEntitiesList.forEach(System.out::println);
        //zad9
        dao.delete(movieEntity);

    }
}
