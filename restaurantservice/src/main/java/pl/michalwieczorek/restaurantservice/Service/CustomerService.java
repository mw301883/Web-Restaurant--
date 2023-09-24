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
        boolean isSame = false;
        for(Customer cus : customerRepository.findAll()){
            if( cus.getName().equals(customer.getName())){
                if(cus.getSurname().equals(customer.getSurname())){
                    if(cus.getCity().equals(customer.getCity())){
                        if(cus.getAdress().equals(customer.getAdress())){
                            if(cus.getCode().equals(customer.getCode())){
                                if(cus.getPhone().equals(customer.getPhone())){
                                    isSame = true;
                                }
                            }
                        }
                    }
                }
            }
            if(isSame){
                break;
            }
        }
        if(!isSame){
            customerRepository.save(customer);
        }
    }
    public Long findID(Customer customer) {
        boolean isSame = false;
        Long ID = null;
        for(Customer cus : customerRepository.findAll()){
            if( cus.getName().equals(customer.getName())){
                if(cus.getSurname().equals(customer.getSurname())){
                    if(cus.getCity().equals(customer.getCity())){
                        if(cus.getAdress().equals(customer.getAdress())){
                            if(cus.getCode().equals(customer.getCode())){
                                if(cus.getPhone().equals(customer.getPhone())){
                                    ID = cus.getId();
                                }
                            }
                        }
                    }
                }
            }
        }
        return ID;
    }
    public void addOrder(Long Id, Long OrderId){
        Customer customer = customerRepository.findById(Id).get();
        customer.addOrderID(OrderId);
        customerRepository.save(customer);
    }
}
