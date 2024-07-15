package restaurantrecommendationservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import restaurantrecommendationservice.domain.*;
import restaurantrecommendationservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryAddressUpdated extends AbstractEvent {

    private Address address;
    private DateTime deliveryTime;

    public DeliveryAddressUpdated(DeliveryAddress aggregate) {
        super(aggregate);
    }

    public DeliveryAddressUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
