package pl.michalwieczorek.restaurantservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    private Long Id;
    private List<Meal> Meals = new ArrayList<Meal>();
    private boolean isPaid;
    private boolean isCompleted;
    private Calendar BeginDate;
    private Calendar EndDate;
    private Customer OrderOwner;
}
