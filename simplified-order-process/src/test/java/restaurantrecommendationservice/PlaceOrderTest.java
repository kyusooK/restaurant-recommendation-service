
package restaurantrecommendationservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MimeTypeUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import restaurantrecommendationservice.config.kafka.KafkaProcessor;
import restaurantrecommendationservice.domain.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlaceOrderTest {

   private static final Logger LOGGER = LoggerFactory.getLogger(CommandTest.class);
   
   @Autowired
   private KafkaProcessor processor;
   @Autowired
   private MessageCollector messageCollector;
   @Autowired
   private ApplicationContext applicationContext;

   @Autowired
   public OrderRepository repository;

   @Test
   @SuppressWarnings("unchecked")
   public void test0() {

      //given:  
      Order existingEntity = new Order();

      existingEntity.setOrderId("주문ID");
      existingEntity.setRestaurant([object Object]);
      existingEntity.setDeliveryAddress([object Object]);
      existingEntity.setRestaurantId("레스토랑 ID");

      repository.save(existingEntity);

      //when:  

  
      
      try {


      Order newEntity = new Order();

         newEntity.setRestaurant([object Object]);
         newEntity.setDeliveryAddress([object Object]);

      repository.save(newEntity);


   
           

         //then:

         Message<String> received = (Message<String>) messageCollector.forChannel(processor.outboundTopic()).poll();

         assertNotNull("Resulted event must be published", received);

         OrderPlaced outputEvent = objectMapper.readValue(received.getPayload(), OrderPlaced.class);


         LOGGER.info("Response received: {}", received.getPayload());

         assertEquals(outputEvent.getOrderId(), "주문ID");
         assertEquals(outputEvent.getRestaurant(), [object Object]);
         assertEquals(outputEvent.getDeliveryAddress(), [object Object]);


      } catch (JsonProcessingException e) {
         // TODO Auto-generated catch block
         assertTrue("exception", false);
      }

     
   }

}
