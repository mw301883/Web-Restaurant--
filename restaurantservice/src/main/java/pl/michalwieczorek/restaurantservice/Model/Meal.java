package pl.michalwieczorek.restaurantservice.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    @Lob
    private String Description;
    private  String ImgURL;
    private BigDecimal Price;
    public Meal(String Name, String Description, String ImgURL, BigDecimal Price){
        this.Name = Name;
        this.Description = Description;
        this.ImgURL = ImgURL;
        this.Price = Price;
    }
}
