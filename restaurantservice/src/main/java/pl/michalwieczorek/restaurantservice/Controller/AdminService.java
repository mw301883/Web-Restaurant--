package pl.michalwieczorek.restaurantservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminService {
    @GetMapping("/adminview")
    String AdminPage(){ return "adminview"; }
}
