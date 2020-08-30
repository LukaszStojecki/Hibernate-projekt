package entity;


import dao.MovieDao;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Movie {

    @Column(insertable = false, updatable = false, columnDefinition = "serial", unique = true)
    private Integer id;
    @Id
    private String title;
    private String director;
    private String productionCountry;
    private Integer productionYear;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Genre> genreTypes;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_actor",
            joinColumns = {@JoinColumn(name = "movie")},
            inverseJoinColumns = {@JoinColumn(name = "actor")})
    private List<Actor> actors = new ArrayList<>();

    public Movie() {

    }
    public  Movie(String title){
        this.title=title;
    }

    public Movie(String title, String director, String productionCountry, Integer productionYear, List<Review> reviews) {
        this.title = title;
        this.director = director;
        this.productionCountry = productionCountry;
        this.productionYear = productionYear;
        this.reviews = reviews;
    }

    public List<Actor> getActors() {
        return actors;
    }


    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

//    public List<Genre> getGenreTypes() {
//        return genreTypes;
//    }

//    public void setGenreTypes(List<Genre> genreTypes) {
//        this.genreTypes = genreTypes;
//    }

    public void addActor(Actor actor) {
        actors.add(actor);
        MovieDao movieDao = new MovieDao();
        movieDao.save(this);
    }

//    public void addActor(Actor actor){
//        actors.add(actor);
//        actor.getMovies().add(this);
//    }

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
                ", reviews=" + reviews +
                ", actors=" + actors +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
