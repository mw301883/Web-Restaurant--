package pl.michalwieczorek.restaurantservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.michalwieczorek.restaurantservice.Model.AdminAccount;
import pl.michalwieczorek.restaurantservice.Repository.AdminAccountRepository;

import java.util.Optional;

@Service
public class AdminAccountService {
    private final AdminAccountRepository adminAccountRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    AdminAccountService(AdminAccountRepository adminAccountRepository, PasswordEncoder passwordEncoder){
        this.adminAccountRepository = adminAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public String GetLogin(){
        Optional<AdminAccount> obj = adminAccountRepository.findById(1L);
        return obj.get().getUsername();
    }
    public String GetPassword(){
        Optional<AdminAccount> obj = adminAccountRepository.findById(1L);
        return obj.get().getPassword();
    }
    public void SetPassword(String newPassword){
        Optional<AdminAccount> optionalAdmin = adminAccountRepository.findById(1L);

        if (optionalAdmin.isPresent()) {
            AdminAccount admin = optionalAdmin.get();
            String encodedPassword = passwordEncoder.encode(newPassword);
            admin.setPassword(encodedPassword);
            adminAccountRepository.save(admin);
        }
    }
}
