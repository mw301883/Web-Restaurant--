package pl.michalwieczorek.restaurantservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.michalwieczorek.restaurantservice.Controller.OrderLink.OrderLink;
import pl.michalwieczorek.restaurantservice.Model.Customer;
import pl.michalwieczorek.restaurantservice.Model.CustomerOrder;
import pl.michalwieczorek.restaurantservice.Model.Meal;
import pl.michalwieczorek.restaurantservice.Service.AdminAccountService;
import pl.michalwieczorek.restaurantservice.Service.CustomerService;
import pl.michalwieczorek.restaurantservice.Service.MealService;
import pl.michalwieczorek.restaurantservice.Service.OrderService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final MealService mealService;
    private final AdminAccountService adminAccountService;
    private final OrderService orderService;
    private final CustomerService customerService;
    @Autowired
    public AdminController(MealService mealService, AdminAccountService adminAccountService, OrderService orderService, CustomerService customerService) {
        this.mealService = mealService;
        this.adminAccountService = adminAccountService;
        this.orderService = orderService;
        this.customerService = customerService;
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
    String OrdersPage(Model model){
        List<OrderLink> orders = new ArrayList<>();
        for (Long i = 1L; i < orderService.returnSize() + 1; ++i){
            CustomerOrder order = orderService.findByID(i);
            List<Meal> meals = new ArrayList<>();
            for(Long ID : order.getMealsIDs()){
                meals.add(mealService.findByID(ID));
            }
            Customer customer = customerService.findByID(order.getCustomer_Id());
            orders.add(new OrderLink(order, customer, meals));
        }
        model.addAttribute("count", orderService.returnSize());
        model.addAttribute("orders", orders);
        return "admin/orders";
    }
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
