package us.peaksoft.loginservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import us.peaksoft.loginservice.models.domain.User;

import java.util.Optional;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.account.login = ?1")
    User findUserByLogin(String login);

    Optional<User> findById(Long id);
}
