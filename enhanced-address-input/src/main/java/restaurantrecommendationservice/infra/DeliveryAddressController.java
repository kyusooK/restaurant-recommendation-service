package restaurantrecommendationservice.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurantrecommendationservice.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/deliveryAddresses")
@Transactional
public class DeliveryAddressController {

    @Autowired
    DeliveryAddressRepository deliveryAddressRepository;

    @RequestMapping(
        value = "/deliveryAddresses/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public DeliveryAddress updateDeliveryAddress(
        @PathVariable(value = "id") Address id,
        @RequestBody UpdateDeliveryAddressCommand updateDeliveryAddressCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /deliveryAddress/updateDeliveryAddress  called #####"
        );
        Optional<DeliveryAddress> optionalDeliveryAddress = deliveryAddressRepository.findById(
            id
        );

        optionalDeliveryAddress.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        DeliveryAddress deliveryAddress = optionalDeliveryAddress.get();
        deliveryAddress.updateDeliveryAddress(updateDeliveryAddressCommand);

        deliveryAddressRepository.save(deliveryAddress);
        return deliveryAddress;
    }
}
//>>> Clean Arch / Inbound Adaptor
