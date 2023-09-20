package pl.michalwieczorek.restaurantservice.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@IdClass(CustomerOrderId.class)
public class CustomerOrder {
    @Id
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Id
    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;
    private boolean isPaid;
    private boolean isCompleted;
    private Calendar BeginDate;
    private Calendar EndDate;
}
