package pl.michalwieczorek.restaurantservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalwieczorek.restaurantservice.Model.CustomerOrder;
import pl.michalwieczorek.restaurantservice.Repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    @Autowired
    OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    public void addOrder(CustomerOrder customerOrder){
        orderRepository.save(customerOrder);
    }
    public CustomerOrder getCustomerOrderById(Long customerId, Long mealId) {
        return orderRepository.findByCustomer_IdAndMeal_Id(customerId, mealId).orElse(null);
    }
}
