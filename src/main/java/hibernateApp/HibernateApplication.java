package hibernateApp;

import dao.ActorDao;
import dao.MovieDao;
import entity.*;

import java.util.*;

public class HibernateApplication {

    public static void main(String[] args) {

        MovieDao movieDao = new MovieDao();
        //GenreDao genreDao = new GenreDao();
        ActorDao actorDao = new ActorDao();

//        Genre genre1 = new Genre(GenreType.SENSACYJNY);
//        Genre genre2 = new Genre(GenreType.ROMANS);
//        Genre genre3 = new Genre(GenreType.MUSICAL);
//        Genre genre4 = new Genre(GenreType.KOMEDIA_ROMANTYCZNA);
//        Genre genre5 = new Genre(GenreType.DRAMAT);
//        Genre genre6 = new Genre(GenreType.KOMEDIA);
//        Genre genre7 = new Genre(GenreType.GANGSTERSKI);
//        Genre genre8 = new Genre(GenreType.WOJENNY);

        Review review1 = new Review(ReviewName.REWELACYJNY);
        Review review2 = new Review(ReviewName.NAJGORSZY);

//        List<Genre> genreList = Arrays.asList(
//                genre1,
//                genre2,
//                genre3,
//                genre4,
//                genre5,
//                genre6,
//                genre7,
//                genre8);

        Movie movie1 = new Movie("Top Gun", "Tony Scott", "USA", 1986, List.of(review2));
//        Movie movie2 = new Movie("Golden Eye", "Martin Campbell", "POL", 1995, List.of(genre1));
        Movie movie3 = new Movie("Mamma Mia!", "Phyllida Lloyd", "GER", 1995, List.of(review1));
//        Movie movie4 = new Movie("Pani Doubtfire", "Chris Columbus", "USA", 1993, List.of(genre5, genre6));
//        Movie movie5 = new Movie("Ojciec Chrzestny", "Francis Ford Coppola", "USA", 1972, List.of(genre5, genre7));
//        Movie movie6 = new Movie("Forrest Gump", "Robert Zemeckis", "USA", 1994, List.of(genre5, genre6));
//        Movie movie7 = new Movie("Szeregowiec Ryan", "Steven Spielberg", "USA", 1998, List.of(genre5, genre8));
        movieDao.save(movie1);
        movieDao.save(movie3);

//        List<Movie> movies = movieDao.readAll();
//        movies.forEach(System.out::println);

        Actor actor1 = new Actor("Tom", "Hanks");
//        Actor actor2 = new Actor("Tom", "Cruise");
        Actor actor3 = new Actor("Val", "Kilmer");
//        Actor actor4 = new Actor("Meryl", "Streep");
//        Actor actor5 = new Actor("Robin", "Wright");

        movie1.addActor(actor1);
        actorDao.getActorWithMovies(actor1);
        movie3.addActor(actor3);
        actorDao.getActorWithMovies(actor3);

//        genreDao.getGenres(movie1);
//        genreDao.getGenres(movie1);
//        genreDao.getGenres(movie3);
//        genreDao.getGenres(movie4);
//        genreDao.getGenres(movie5);
//        genreDao.getGenres(movie6);
//        genreDao.getGenres(movie7);

        //movieDao.delete("TOp");


    }
}
