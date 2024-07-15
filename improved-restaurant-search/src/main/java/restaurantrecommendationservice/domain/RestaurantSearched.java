package restaurantrecommendationservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import restaurantrecommendationservice.domain.*;
import restaurantrecommendationservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RestaurantSearched extends AbstractEvent {

    private Integer count;
    private List<Restaurant> result;

    public RestaurantSearched(Restaurant aggregate) {
        super(aggregate);
    }

    public RestaurantSearched() {
        super();
    }
}
//>>> DDD / Domain Event
