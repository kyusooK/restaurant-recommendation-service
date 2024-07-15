package restaurantrecommendationservice.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import restaurantrecommendationservice.domain.*;

@Component
public class RestaurantHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Restaurant>> {

    @Override
    public EntityModel<Restaurant> process(EntityModel<Restaurant> model) {
        return model;
    }
}
