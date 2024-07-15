package restaurantrecommendationservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import restaurantrecommendationservice.domain.*;
import restaurantrecommendationservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private String orderId;
    private String restaurantName;
    private Address deliveryAddress;

    public OrderPlaced(Order aggregate) {
        super(aggregate);
    }

    public OrderPlaced() {
        super();
    }
}
//>>> DDD / Domain Event
