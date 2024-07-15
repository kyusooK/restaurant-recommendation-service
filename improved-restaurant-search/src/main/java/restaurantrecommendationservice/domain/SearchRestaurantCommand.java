package restaurantrecommendationservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SearchRestaurantCommand {

    private String keyword;
}
