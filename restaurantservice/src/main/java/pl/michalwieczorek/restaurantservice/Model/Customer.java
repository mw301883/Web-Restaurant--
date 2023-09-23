package pl.michalwieczorek.restaurantservice.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    private String Surname;
    private String City;
    private String Adress;
    private int Code;
    private int Phone;
    private Set<Long> Order_IDs = new HashSet<>();

    public Customer(String name, String surname, String city, String adress, int code, int phone) {
        Name = name;
        Surname = surname;
        City = city;
        Adress = adress;
        Code = code;
        Phone = phone;
    }
}
