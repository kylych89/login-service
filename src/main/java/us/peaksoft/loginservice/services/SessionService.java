package us.peaksoft.loginservice.services;

import us.peaksoft.loginservice.models.dto.SessionDto;
import us.peaksoft.loginservice.models.dto.UserDto;

/**
 * Created by Sayfullah on 12.03.2021.
 */
public interface SessionService {

    SessionDto appendNewSession(UserDto userDto);
    boolean closeSession(UserDto userDto);
    SessionDto login(String login, String password);
    boolean closeSession(String auth);
    SessionDto findSessionByToken(String token);
}
