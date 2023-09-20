package pl.michalwieczorek.restaurantservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.michalwieczorek.restaurantservice.Repository.MealRepository;

@Controller
@RequestMapping("/")
public class HomeController {
    private final MealRepository mealRepository;

    public HomeController(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @GetMapping("/")
    public String HomePage(Model model){
        model.addAttribute( "meals", mealRepository.findAll());
        return "shop/home";
    }
    @GetMapping("/cart")
    public String CartPage(){ return "shop/cart"; }
    @GetMapping("/summary")
    public String SummaryPage(){ return "shop/summary"; }
    @GetMapping("/login")
    public String LoginPage(){ return "shop/login"; }
    @PostMapping("/addtoCart")
    public void addtoCart(@RequestParam Long Id){

    }
}
