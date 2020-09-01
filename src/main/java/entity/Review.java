package entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name ="increment", strategy = "increment")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ReviewName reviewEnum;

    @ManyToOne
    private Movie movie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Review() {
    }

    public Review(ReviewName reviewEnum) {
        this.reviewEnum = reviewEnum;
    }

    public ReviewName getReviewEnum() {
        return reviewEnum;
    }

    public void setReviewEnum(ReviewName reviewEnum) {
        this.reviewEnum = reviewEnum;
    }
}
