package pl.michalwieczorek.restaurantservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.michalwieczorek.restaurantservice.Model.AdminAccount;
import pl.michalwieczorek.restaurantservice.Model.Meal;
import pl.michalwieczorek.restaurantservice.Repository.AdminAccountRepository;
import pl.michalwieczorek.restaurantservice.Repository.MealRepository;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {
    private final MealRepository mealRepository;
    private final AdminAccountRepository adminAccountRepository;
    @Autowired
    public DbInit(MealRepository mealRepository, AdminAccountRepository adminAccountRepository) {
        this.mealRepository = mealRepository;
        this.adminAccountRepository = adminAccountRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        this.mealRepository.saveAll(List.of(
                new Meal("Kotlet Schabowy", "Delikatny kotlet schabowy panierowany w chrupiącej bułce tartej, podawany z miękkimi, gotowanymi ziemniakami. Do tego świeża surówka z marchewki, kapusty i ogórka z delikatnym dressingiem. Danie pełne tradycyjnych smaków, które rozpieści Twoje podniebienie.",
                        "https://www.tasteatlas.com/images/dishes/7c83f24ab48449c2a6f70784285b8e3f.jpg", new BigDecimal(40)),
                new Meal("Kotlet Schabowy", "Delikatny kotlet schabowy panierowany w chrupiącej bułce tartej, podawany z miękkimi, gotowanymi ziemniakami. Do tego świeża surówka z marchewki, kapusty i ogórka z delikatnym dressingiem. Danie pełne tradycyjnych smaków, które rozpieści Twoje podniebienie.",
                        "https://www.tasteatlas.com/images/dishes/7c83f24ab48449c2a6f70784285b8e3f.jpg", new BigDecimal(40))
        ));
        this.adminAccountRepository.save(new AdminAccount("admin", "password"));
    }
}
