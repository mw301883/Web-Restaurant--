package pl.michalwieczorek.restaurantservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.michalwieczorek.restaurantservice.Model.Customer;
import pl.michalwieczorek.restaurantservice.Model.Meal;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
