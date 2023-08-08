package pl.michalwieczorek.restaurantservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.michalwieczorek.restaurantservice.Model.Meal;

import java.math.BigDecimal;

@Controller
public class HomeService {
    @GetMapping("/")
    public String HomePage(Model model){
        model.addAttribute( "meal", new Meal("Kotlet Schabowy", "Delikatny kotlet schabowy panierowany w chrupiącej bułce tartej, podawany z miękkimi, gotowanymi ziemniakami. Do tego świeża surówka z marchewki, kapusty i ogórka z delikatnym dressingiem. Danie pełne tradycyjnych smaków, które rozpieści Twoje podniebienie.",
                "https://www.tasteatlas.com/images/dishes/7c83f24ab48449c2a6f70784285b8e3f.jpg", new BigDecimal(40)));
        return "home";
    }
}
