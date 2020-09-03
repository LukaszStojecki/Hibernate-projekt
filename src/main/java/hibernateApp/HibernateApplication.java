package hibernateApp;

import dao.MovieDao;
import entity.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class HibernateApplication {

    public static void main(String[] args) {

        MovieDao movieDao = new MovieDao();
        //movieDao.setSessionFactory(HibernateConfiguration.getSessionFactory());

        Genre genre1 = new Genre(GenreType.SENSACYJNY);
        Genre genre2 = new Genre(GenreType.ROMANS);
        Genre genre3 = new Genre(GenreType.MUSICAL);
        Genre genre4 = new Genre(GenreType.KOMEDIA_ROMANTYCZNA);
        Genre genre5 = new Genre(GenreType.DRAMAT);
        Genre genre6 = new Genre(GenreType.KOMEDIA);
        Genre genre7 = new Genre(GenreType.GANGSTERSKI);
        Genre genre8 = new Genre(GenreType.WOJENNY);

        Review review1 = new Review(ReviewName.REWELACYJNY);
        Review review2 = new Review(ReviewName.NAJGORSZY);
        Review review3 = new Review(ReviewName.SREDNI);

        Movie movie1 = new Movie("Top Gun", "Tony Scott", "USA", 1986);
        Movie movie2 = new Movie("Golden Eye", "Martin Campbell", "POL", 1995);
        Movie movie3 = new Movie("Mamma Mia!", "Phyllida Lloyd", "GER", 1995);
        Movie movie4 = new Movie("Pani Doubtfire", "Chris Columbus", "USA", 1993);
        Movie movie5 = new Movie("Ojciec Chrzestny", "Francis Ford Coppola", "USA", 1972);
        Movie movie6 = new Movie("Forrest Gump", "Robert Zemeckis", "USA", 1994);
        Movie movie7 = new Movie("Szeregowiec Ryan", "Steven Spielberg", "USA", 1998);



        Actor actor1 = new Actor("Tom", "Hanks");
        Actor actor2 = new Actor("Tom", "Cruise");
        Actor actor3 = new Actor("Val", "Kilmer");
        Actor actor4 = new Actor("Meryl", "Streep");
        Actor actor5 = new Actor("Robin", "Wright");


        movie1.addReview(review1);
        movie2.addReview(review2);
        movie1.addReview(review3);
        movie1.addGenre(genre1);
        movie1.addGenre(genre2);
        movie2.addGenre(genre4);
        movie2.addGenre(genre2);
        movie1.addActor(actor1);
        movie2.addActor(actor3);
        movie2.addActor(actor1);

        movieDao.save(movie1);
        movieDao.save(movie2);


        List<Movie> movies = Arrays.asList(
                movie1,
                movie2,
                movie3,
                movie4,
                movie5,
                movie6,
                movie7
        );

        movieDao.readAll();

        Optional<Movie> movieReviews = movies.stream()
                .filter(r->r.getTitle().contains("Top Gun"))
                .findAny();

        if (movieReviews.isPresent()){
            Movie movie = movieReviews.get();
            movie.getReviews().forEach(review -> System.out.println(review.getReviewEnum()));
        }


        movieDao.getActorsFromMovie(actor1);

       // movieDao.delete("Top Gun");

    }
}
