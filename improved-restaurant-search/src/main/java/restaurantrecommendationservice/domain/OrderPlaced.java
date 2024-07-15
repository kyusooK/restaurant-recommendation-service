package restaurantrecommendationservice.domain;

import java.util.*;
import lombok.*;
import restaurantrecommendationservice.domain.*;
import restaurantrecommendationservice.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private String orderId;
    private Object restaurant;
    private Object deliveryAddress;
}
