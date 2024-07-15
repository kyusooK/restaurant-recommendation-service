package restaurantrecommendationservice.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import restaurantrecommendationservice.EnhancedAddressInputApplication;

@Entity
@Table(name = "DeliveryAddress_table")
@Data
//<<< DDD / Aggregate Root
public class DeliveryAddress {

    @Id
    private Address address;

    private DateTime deliveryTime;

    @PrePersist
    public void onPrePersist() {}

    public static DeliveryAddressRepository repository() {
        DeliveryAddressRepository deliveryAddressRepository = EnhancedAddressInputApplication.applicationContext.getBean(
            DeliveryAddressRepository.class
        );
        return deliveryAddressRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateDeliveryAddress(
        UpdateDeliveryAddressCommand updateDeliveryAddressCommand
    ) {
        //implement business logic here:

        DeliveryAddressUpdated deliveryAddressUpdated = new DeliveryAddressUpdated(
            this
        );
        deliveryAddressUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
