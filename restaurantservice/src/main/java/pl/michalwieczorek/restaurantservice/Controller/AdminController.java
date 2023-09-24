package pl.michalwieczorek.restaurantservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.michalwieczorek.restaurantservice.Model.Meal;
import pl.michalwieczorek.restaurantservice.Service.AdminAccountService;
import pl.michalwieczorek.restaurantservice.Service.MealService;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final MealService mealService;
    private final AdminAccountService adminAccountService;
    @Autowired
    public AdminController(MealService mealService, AdminAccountService adminAccountService) {
        this.mealService = mealService;
        this.adminAccountService = adminAccountService;
    }
    @GetMapping
    public String AdminPage(Model model){
        model.addAttribute( "meals", mealService.findAll());
        model.addAttribute("count", mealService.MealsCount());
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

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam String Password, @RequestParam String Password_re) throws Exception {
        if(Password.equals(Password_re)){
            adminAccountService.SetPassword(Password.substring(1));
            return "redirect:/admin";
        }else{
            return "admin/password";
        }
    }
}
