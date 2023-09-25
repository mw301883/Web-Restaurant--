package pl.michalwieczorek.restaurantservice.Controller.OrderLink;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.michalwieczorek.restaurantservice.Model.Customer;
import pl.michalwieczorek.restaurantservice.Model.CustomerOrder;
import pl.michalwieczorek.restaurantservice.Model.Meal;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderLink {
    private CustomerOrder order;
    private Customer customer;
    List<Meal> meals;
    BigDecimal price;
    private BigDecimal calculateTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Meal meal : meals) {
            totalPrice = totalPrice.add(meal.getPrice());
        }
        return totalPrice;
    }
    public OrderLink(CustomerOrder order, Customer customer, List<Meal> meals){
        this.order = order;
        this.customer = customer;
        this.meals = meals;
        this.price = calculateTotalPrice();
    }
}
