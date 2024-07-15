package restaurantrecommendationservice.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import restaurantrecommendationservice.SimplifiedOrderProcessApplication;
import restaurantrecommendationservice.domain.OrderPlaced;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    private String orderId;

    private Restaurant restaurant;

    private Address deliveryAddress;

    @Embedded
    private RestaurantId restaurantId;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {
        // 비즈니스 로직 추가
        if (this.restaurant == null || this.deliveryAddress == null) {
            throw new IllegalArgumentException('All fields must be supplied');
        }
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = SimplifiedOrderProcessApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
}
//>>> DDD / Aggregate Root
