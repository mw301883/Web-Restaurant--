package pl.michalwieczorek.restaurantservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.michalwieczorek.restaurantservice.Model.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
}
