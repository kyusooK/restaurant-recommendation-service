package restaurantrecommendationservice.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import restaurantrecommendationservice.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "deliveryAddresses",
    path = "deliveryAddresses"
)
public interface DeliveryAddressRepository
    extends PagingAndSortingRepository<DeliveryAddress, Address> {}
