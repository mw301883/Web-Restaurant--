package pl.michalwieczorek.restaurantservice.Model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class CustomerOrderId implements Serializable {
    private Long customer;
    private Long meal;
}
