package us.peaksoft.loginservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.peaksoft.loginservice.models.domain.Account;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
