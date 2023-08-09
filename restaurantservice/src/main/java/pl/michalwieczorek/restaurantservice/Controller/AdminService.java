package pl.michalwieczorek.restaurantservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.michalwieczorek.restaurantservice.Model.Meal;

@Controller
@RequestMapping("/admin")
public class AdminService {
    @GetMapping
    public String AdminPage(){ return "adminview"; }
    @PostMapping
    public String AddMeal(Meal NewMeal){
        HomeService.Meals.add(NewMeal);
        return "redirect:/";
    }
}
