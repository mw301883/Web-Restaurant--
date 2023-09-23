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
    public Long addOrder(CustomerOrder customerOrder){
        customerOrder = orderRepository.save(customerOrder);
        return customerOrder.getId();
    }
    public Long returnSize(){
        return orderRepository.count();
    }
}
