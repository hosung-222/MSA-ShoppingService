package labshopcompensation.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "MyPage_table")
@Data
public class MyPage {
    @Id
    private Long orderId;
    private String productId;
    private String orderStatus;
    private String deliveryStatus;
}
