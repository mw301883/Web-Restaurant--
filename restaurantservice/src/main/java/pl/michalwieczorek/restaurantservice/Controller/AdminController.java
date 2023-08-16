package pl.michalwieczorek.restaurantservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.michalwieczorek.restaurantservice.Model.Meal;
import pl.michalwieczorek.restaurantservice.Repository.MealRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final MealRepository mealRepository;

    @Autowired
    public AdminController(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @GetMapping
    public String AdminPage(Model model){
        model.addAttribute( "meals", mealRepository.findAll());
        return "admin/adminview";
    }
    @PostMapping
    public String AddMeal(Meal NewMeal){
        mealRepository.save(NewMeal);
        return "redirect:/";
    }

    @GetMapping("/orders")
    String OrdersPage(){ return "admin/orders"; }

    @GetMapping("/password")
    String PasswordPage(){ return "admin/password"; }

    @GetMapping("/login")
    String LoginPage(){ return "admin/login"; }

}
