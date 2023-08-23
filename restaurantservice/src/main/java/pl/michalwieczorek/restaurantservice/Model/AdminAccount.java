package pl.michalwieczorek.restaurantservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class AdminAccount {
    @Id
    @GeneratedValue
    private Long Id;
    private String Username;
    private String Password;
    public AdminAccount(String Username, String Password){
        this.Username = Username;
        this.Password = Password;
    }
}
