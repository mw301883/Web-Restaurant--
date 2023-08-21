package pl.michalwieczorek.restaurantservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalwieczorek.restaurantservice.Model.Meal;
import pl.michalwieczorek.restaurantservice.Repository.MealRepository;

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
}
