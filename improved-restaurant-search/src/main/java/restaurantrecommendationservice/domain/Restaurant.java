package restaurantrecommendationservice.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import restaurantrecommendationservice.ImprovedRestaurantSearchApplication;
import restaurantrecommendationservice.domain.RestaurantSearched;

@Entity
@Table(name = "Restaurant_table")
@Data
//<<< DDD / Aggregate Root
public class Restaurant {

    @Id
    private String name;

    private String description;

    private Rating rating;

    private Tags tags;

    @PostPersist
    public void onPostPersist() {
        RestaurantSearched restaurantSearched = new RestaurantSearched(this);
        restaurantSearched.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static RestaurantRepository repository() {
        RestaurantRepository restaurantRepository = ImprovedRestaurantSearchApplication.applicationContext.getBean(
            RestaurantRepository.class
        );
        return restaurantRepository;
    }
}
//>>> DDD / Aggregate Root
