package pl.michalwieczorek.restaurantservice.BasketService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasketService {
@GetMapping("/basket")
    public String BasketPage(){ return "basket"; }
}
