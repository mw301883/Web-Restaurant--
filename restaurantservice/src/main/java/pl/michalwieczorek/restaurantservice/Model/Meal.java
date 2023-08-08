package pl.michalwieczorek.restaurantservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Meal {
    private String Name;
    private String Description;
    private  String ImgURL;
    private BigDecimal Price;


}
