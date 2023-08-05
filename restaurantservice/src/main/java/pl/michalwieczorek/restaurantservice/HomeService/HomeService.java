package pl.michalwieczorek.restaurantservice.HomeService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeService {
    @GetMapping("/")
    public String HomePage(){
        return "home";
    }
}
