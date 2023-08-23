package pl.michalwieczorek.restaurantservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.michalwieczorek.restaurantservice.Model.Meal;
import pl.michalwieczorek.restaurantservice.Service.MealService;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final MealService mealService;
    @Autowired
    public AdminController(MealService mealService) {
        this.mealService = mealService;
    }
    @GetMapping
    public String AdminPage(Model model){
        model.addAttribute( "meals", mealService.findAll());
        return "admin/adminview";
    }
    @PostMapping("/add")
    public String AddMeal(Meal NewMeal){
        mealService.addMeal(NewMeal);
        return "redirect:/admin";
    }
    @PostMapping("/delete")
    public String RemoveMeal(@RequestParam Long Id){
        System.out.println(Id);
        mealService.deleteMeal(Id);
        return "redirect:/admin";
    }
    @GetMapping("/orders")
    String OrdersPage(){ return "admin/orders"; }
    @GetMapping("/password")
    String PasswordPage(){ return "admin/password"; }

}
