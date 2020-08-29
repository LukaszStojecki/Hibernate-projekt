package entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "Movie")

public class Movie {

    @Column(insertable = false, updatable = false, columnDefinition="serial")
    private Integer id;
    @Id
    private String title;
    private String director;
    private String productionCountry;
    private Integer productionYear;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Genre> genreTypes;


    public List<Genre> getGenreTypes() {
        return genreTypes;
    }

    public void setGenreTypes(List<Genre> genreTypes) {
        this.genreTypes = genreTypes;
    }

    public Movie() {
    }

    public Movie(String title, String director, String productionCountry, Integer productionYear, List<Genre> genreTypes) {
        this.title = title;
        this.director = director;
        this.productionCountry = productionCountry;
        this.productionYear = productionYear;
        this.genreTypes =genreTypes;
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
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
