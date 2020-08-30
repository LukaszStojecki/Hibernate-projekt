package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Genre {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name ="increment", strategy = "increment")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private GenreType genreType;

    public Genre() {
    }

    public Genre(GenreType genreType) {
        this.genreType = genreType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GenreType getGenreType() {
        return genreType;
    }

    public void setGenreType(GenreType genreType) {
        this.genreType = genreType;
    }
}
