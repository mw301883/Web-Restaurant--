package pl.michalwieczorek.restaurantservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalwieczorek.restaurantservice.Controller.AdminController;
import pl.michalwieczorek.restaurantservice.Model.AdminAccount;
import pl.michalwieczorek.restaurantservice.Repository.AdminAccountRepository;

import java.util.Optional;

@Service
public class AdminAccountService {
    private final AdminAccountRepository adminAccountRepository;
    @Autowired
    AdminAccountService(AdminAccountRepository adminAccountRepository){
        this.adminAccountRepository = adminAccountRepository;
    }
    public String GetLogin(){
        Optional<AdminAccount> obj = adminAccountRepository.findById(1L);
        return obj.get().getUsername();
    }
    public String GetPassword(){
        Optional<AdminAccount> obj = adminAccountRepository.findById(1L);
        return obj.get().getPassword();
    }
    public void SetPassword(String Password){
        Optional<AdminAccount> obj = adminAccountRepository.findById(1L);
        System.out.println(Password);
        obj.get().setPassword(Password);
        adminAccountRepository.save(obj.get());
    }
}
