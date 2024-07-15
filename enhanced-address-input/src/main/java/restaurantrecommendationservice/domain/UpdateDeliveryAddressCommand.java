package restaurantrecommendationservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateDeliveryAddressCommand {

    private Address address;
    private DateTime deliveryTime;
}
