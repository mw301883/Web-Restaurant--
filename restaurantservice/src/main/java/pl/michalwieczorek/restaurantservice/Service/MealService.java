package pl.michalwieczorek.restaurantservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalwieczorek.restaurantservice.Model.Meal;
import pl.michalwieczorek.restaurantservice.Repository.MealRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MealService {
    private final MealRepository mealRepository;
    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }
    public List<Meal> findAll(){
        return mealRepository.findAll();
    }
    public void addMeal(Meal NewMeal){
        mealRepository.save(NewMeal);
    }
    public void deleteMeal(Long Id){
        this.mealRepository.deleteById(Id);
    }
    public long MealsCount(){
        return mealRepository.count();
    }
    public Meal findByID(Long ID){
        return mealRepository.findById(ID).get();
    }
    public BigDecimal calculateTotalPrice(List<Long> MealsIDs) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Long ID : MealsIDs) {
            totalPrice = totalPrice.add(mealRepository.findById(ID).get().getPrice());
        }
        return totalPrice;
    }
}
