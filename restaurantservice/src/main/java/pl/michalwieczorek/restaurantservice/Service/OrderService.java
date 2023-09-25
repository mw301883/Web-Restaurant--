package pl.michalwieczorek.restaurantservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalwieczorek.restaurantservice.Model.CustomerOrder;
import pl.michalwieczorek.restaurantservice.Repository.OrderRepository;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

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
    public List<CustomerOrder> findAll(){
        return orderRepository.findAll();
    }
    public void changeOrderStatus(Long OrderID){
        Optional<CustomerOrder> order = orderRepository.findById(OrderID);
        order.get().setCompleted(true);
        order.get().setEndDate(Calendar.getInstance());
    }
    public void cancelOrderStatus(Long OrderID){
        Optional<CustomerOrder> order = orderRepository.findById(OrderID);
        order.get().setCompleted(false);
        order.get().setEndDate(null);
    }
    public CustomerOrder findByID(Long ID){
        return orderRepository.findById(ID).get();
    }
}
