package pl.michalwieczorek.restaurantservice.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private List<Long> MealsIDs;
    private boolean isCompleted;
    private Calendar BeginDate;
    private Calendar EndDate;

    public CustomerOrder(Long Customer_Id, List<Long> MealsIDs) {
        this.Customer_Id = Customer_Id;
        this.MealsIDs = MealsIDs;
        this.isCompleted = false;
        this.BeginDate = Calendar.getInstance();
        this.EndDate = null;
    }
}
