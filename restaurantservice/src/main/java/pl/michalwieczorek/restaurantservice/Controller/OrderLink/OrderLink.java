package pl.michalwieczorek.restaurantservice.Controller.OrderLink;

import pl.michalwieczorek.restaurantservice.Model.Customer;
import pl.michalwieczorek.restaurantservice.Model.CustomerOrder;
import pl.michalwieczorek.restaurantservice.Model.Meal;

import java.math.BigDecimal;
import java.util.List;

public class OrderLink {
    private CustomerOrder order;
    private Customer customer;
    List<Meal> meals;
    BigDecimal price = BigDecimal.ZERO;
    public OrderLink(CustomerOrder order, Customer customer, List<Meal> meals){
        this.order = order;
        this.customer = customer;
        this.meals = meals;
        for(Meal meal : meals){
            this.price.add(meal.getPrice());
        }
    }
}
