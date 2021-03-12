package us.peaksoft.loginservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.peaksoft.loginservice.models.domain.Session;
import us.peaksoft.loginservice.models.domain.User;

import java.util.Date;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Session findByUserAndEndDateIsAfter(User user, Date date);
    Session findByToken(String auth);
}
