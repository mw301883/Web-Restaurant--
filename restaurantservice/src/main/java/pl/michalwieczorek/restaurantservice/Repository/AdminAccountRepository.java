package pl.michalwieczorek.restaurantservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.michalwieczorek.restaurantservice.Model.AdminAccount;
@Repository
public interface AdminAccountRepository extends JpaRepository<AdminAccount, Long> {
}
