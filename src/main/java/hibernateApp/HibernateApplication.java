package hibernateApp;

import dao.MovieDao;
import entity.Genre;
import entity.Movie;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class HibernateApplication {

    public static void main(String[] args) {

        MovieDao movieDao = new MovieDao();

        //Genre genre = new Genre();
        Movie movie = new Movie("Top Gun", "Tony Scott", "USA", 1986);
        Movie movie1 = new Movie("Golden Eye", "Martin Campbell", "USA", 1995);
        Movie movie2 = new Movie("Top Gun", "Tony Scott", "USA", 1986);
        Movie movie3 = new Movie("Top Gun", "Tony Scott", "USA", 1986);
        Movie movie4 = new Movie("Top Gun", "Tony Scott", "USA", 1986);
        Movie movie5 = new Movie("Top Gun", "Tony Scott", "USA", 1986);

        movieDao.save(movie);
//        List<Movie> movies = movieDao.readAll();
//        movies.forEach(System.out::println);
        movieDao.delete("TOp");




    }
}
