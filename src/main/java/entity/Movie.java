package entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

    @Column(insertable = false, updatable = false, columnDefinition = "serial", unique = true)
    private Integer id;
    @Id
    private String title;
    private String director;
    private String productionCountry;
    private Integer productionYear;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_genre",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private List<Genre> genreTypes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_actor",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")})
    private List<Actor> actors = new ArrayList<>();

    public Movie() {

    }
//    public  Movie(String title){
//        this.title=title;
//    }

    public Movie(String title, String director, String productionCountry, Integer productionYear) {
        this.title = title;
        this.director = director;
        this.productionCountry = productionCountry;
        this.productionYear = productionYear;
    }

    public List<Actor> getActors() {
        return actors;
    }


    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Genre> getGenreTypes() {
        return genreTypes;
    }

    public void setGenreTypes(List<Genre> genreTypes) {
        this.genreTypes = genreTypes;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addActor(Actor actor){
        this.actors.add(actor);
        actor.getMovies().add(this);
    }

    public void addReview(Review review) {
        this.reviews.add(review);
        review.setMovie(this);
    }

    public void addGenre(Genre genre){
        this.genreTypes.add(genre);
        genre.getMovies().add(this);
    }

    public Integer getId() {
        return id;
    }


    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "Director")
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Column(name = "ProductionCountry")
    public String getProductionCountry() {
        return productionCountry;
    }

    public void setProductionCountry(String productionCountry) {
        this.productionCountry = productionCountry;
    }

    @Column(name = "ProductionYear")
    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", productionCountry='" + productionCountry + '\'' +
                ", productionYear=" + productionYear +
                ", genreTypes=" + genreTypes +
                ", reviews=" + reviews +
                ", actors=" + actors +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
