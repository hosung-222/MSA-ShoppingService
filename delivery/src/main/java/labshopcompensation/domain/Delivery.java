package labshopcompensation.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import labshopcompensation.DeliveryApplication;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    private String customerId;

    private Integer quantity;

    private Long orderId;

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }


    //<<< Clean Arch / Port Method
    public static void addToDeliveryList(OrderPlaced orderPlaced) {
 
        Delivery delivery = new Delivery();
        delivery.setOrderId(orderPlaced.getId());
        delivery.setQuantity( orderPlaced.getQty());
        repository().save(delivery);


    }

    public static void removeDelivery(OrderCancelled orderCancelled) {
  
        
        repository().findByOrderId(orderCancelled.getId()).ifPresent(delivery->{
            
            
            repository().delete(delivery);


         });
        

    }

}
//>>> DDD / Aggregate Root
