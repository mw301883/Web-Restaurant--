package pl.michalwieczorek.restaurantservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import pl.michalwieczorek.restaurantservice.Model.Customer;
import pl.michalwieczorek.restaurantservice.Repository.CustomerRepository;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public void addCustomer(Customer customer){
        Example<Customer> example = Example.of(customer);
        if(!customerRepository.exists(example)){
            customerRepository.save(customer);
        }
    }
    public Long findID(Customer customer) {
        Example<Customer> example = Example.of(customer);
        Optional<Customer> one = customerRepository.findOne(example);
        return one.map(Customer::getId).orElse(null);
    }
    public void addOrder(Long Id, Long OrderId){
        Customer customer = customerRepository.findById(Id).get();
        customer.addOrderID(OrderId);
        customerRepository.save(customer);
    }
}
