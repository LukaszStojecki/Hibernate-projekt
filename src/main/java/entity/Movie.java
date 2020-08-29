package entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "Movie")

public class Movie {

    private Integer id;
    private String title;
    private String director;
    private String productionCountry;
    private Integer productionYear;

    @OneToMany
    @JoinColumn(name = "genre_id")
    private List<Genre> genre;


    public Movie() {
    }

    public Movie( String title, String director, String productionCountry, Integer productionYear) {
        this.title = title;
        this.director = director;
        this.productionCountry = productionCountry;
        this.productionYear = productionYear;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name ="increment", strategy = "increment")
    @Column(name = "movie_id")
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
        return "MovieEntity{" +
                "Title='" + title + '\'' +
                ", Director='" + director + '\'' +
                ", ProductionCountry='" + productionCountry + '\'' +
                ", ProductionYear=" + productionYear +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
