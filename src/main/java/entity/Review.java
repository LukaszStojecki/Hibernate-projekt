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
