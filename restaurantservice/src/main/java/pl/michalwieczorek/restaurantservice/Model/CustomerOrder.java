package pl.michalwieczorek.restaurantservice.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long Customer_Id;
    private List<String> MealsNames;
    private boolean isCompleted;
    private Calendar BeginDate;
    private Calendar EndDate;
    private BigDecimal Price;
    public CustomerOrder(Long Customer_Id, List<String> MealsNames, BigDecimal Price) {
        this.Customer_Id = Customer_Id;
        this.MealsNames = MealsNames;
        this.isCompleted = false;
        this.BeginDate = Calendar.getInstance();
        this.EndDate = null;
        this.Price = Price;
    }
}
