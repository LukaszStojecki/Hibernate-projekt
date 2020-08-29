package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Genre")
public class Genre {
    
    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;

    private String name;

    public Genre() {
    }


    public Genre( String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
