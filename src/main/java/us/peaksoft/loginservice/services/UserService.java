package us.peaksoft.loginservice.services;

import us.peaksoft.loginservice.exceptions.ResourseNotFoundException;
import us.peaksoft.loginservice.models.dto.UserDto;

import java.util.List;

/**
 * Created by Sayfullah on 12.03.2021.
 */
public interface UserService {
    UserDto createUSer(String auth, UserDto userDto);

    UserDto updateUser(String auth, UserDto userDto);

    UserDto findUserByLogin(String login) throws ResourseNotFoundException;

    UserDto findUserById(Long id);

    boolean deactivateUser(String auth, Long userId);

    List<UserDto> findAllUser();

    UserDto findUserById(String auth, Long id);

    List<UserDto> findAllUsers(String auth);


}
