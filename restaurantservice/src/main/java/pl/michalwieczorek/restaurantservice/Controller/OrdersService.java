package pl.michalwieczorek.restaurantservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersService {
    @GetMapping("/orders")
    String OrdersPage(){ return "orders"; }
}
