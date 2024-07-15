package restaurantrecommendationservice.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import restaurantrecommendationservice.domain.*;

@Component
public class DeliveryAddressHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DeliveryAddress>> {

    @Override
    public EntityModel<DeliveryAddress> process(
        EntityModel<DeliveryAddress> model
    ) {
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );

        return model;
    }
}
