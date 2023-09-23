package pl.michalwieczorek.restaurantservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.michalwieczorek.restaurantservice.Model.Customer;
import pl.michalwieczorek.restaurantservice.Model.CustomerOrder;
import pl.michalwieczorek.restaurantservice.Model.Meal;
import pl.michalwieczorek.restaurantservice.Repository.CustomerRepository;
import pl.michalwieczorek.restaurantservice.Repository.MealRepository;
import pl.michalwieczorek.restaurantservice.Repository.OrderRepository;
import pl.michalwieczorek.restaurantservice.Service.CustomerService;
import pl.michalwieczorek.restaurantservice.Service.OrderService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {
    private final MealRepository mealRepository;
    private final CustomerService customerService;
    private final OrderService orderService;
    private List<Long> MealsIDs = new ArrayList<>();
    @Autowired
    public HomeController(MealRepository mealRepository, CustomerService customerService, OrderService orderService) {
        this.mealRepository = mealRepository;
        this.customerService = customerService;
        this.orderService = orderService;
    }
    private BigDecimal CalculateCartVal(){
        BigDecimal price = BigDecimal.ZERO;
        for(Long id : MealsIDs){
            price = price.add(mealRepository.findById(id).get().getPrice());
        }
        return price;
    }
    private List<Meal> returnCart(){
        List<Meal> Cart = new ArrayList<>();
        for(Long id : MealsIDs){
            Cart.add(mealRepository.findById(id).get());
        }
        return Cart;
    }
    @GetMapping("/")
    public String HomePage(Model model){
        model.addAttribute( "meals", mealRepository.findAll());
        model.addAttribute("price", CalculateCartVal());
        model.addAttribute("count", MealsIDs.size());
        return "shop/home";
    }
    @GetMapping("/cart")
    public String CartPage(Model model){
        model.addAttribute( "cart", returnCart());
        model.addAttribute("price", CalculateCartVal());
        model.addAttribute("count", MealsIDs.size());
        return "shop/cart";
    }
    @GetMapping("/summary")
    public String SummaryPage(Model model){
        model.addAttribute("price", CalculateCartVal());
        model.addAttribute("count", MealsIDs.size());
        return "shop/summary";
    }
    @PostMapping("/addtoCart")
    public String addtoCart(@RequestParam Long Id){
        MealsIDs.add(Id);
        return "redirect:/";
    }
    @PostMapping("/removefromCart")
    public String removefromCart(@RequestParam Long Id){
        MealsIDs.remove(MealsIDs.indexOf(Id));
        return "redirect:/cart";
    }
    @PostMapping("/makeOrder")
    public String makeOrder(Customer customer){
        customerService.addCustomer(customer);
        if(customer.getId() != null){
            Long CustomerID = customer.getId();
            CustomerOrder order = new CustomerOrder(CustomerID, MealsIDs);
            Long OrderID = orderService.addOrder(order);
            customerService.addOrder(CustomerID, OrderID);
        }
        else{
            Long CustomerID = customerService.findID(customer);
            CustomerOrder order = new CustomerOrder(CustomerID, MealsIDs);
            Long OrderID = orderService.addOrder(order);
            customerService.addOrder(CustomerID, OrderID);
        }
        MealsIDs.clear();
        return "redirect:/";
    }
}
