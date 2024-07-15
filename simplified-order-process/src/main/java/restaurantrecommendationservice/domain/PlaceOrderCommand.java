package restaurantrecommendationservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class PlaceOrderCommand {

    private Restaurant restaurant;
    private Address deliveryAddress;
}
