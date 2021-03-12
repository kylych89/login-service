package us.peaksoft.loginservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import us.peaksoft.loginservice.dao.UserRepository;
import us.peaksoft.loginservice.exceptions.ResourseNotFoundException;
import us.peaksoft.loginservice.mappers.UserMapper;
import us.peaksoft.loginservice.models.domain.User;
import us.peaksoft.loginservice.models.dto.AccountDto;
import us.peaksoft.loginservice.models.dto.UserDto;
import us.peaksoft.loginservice.services.AccountService;
import us.peaksoft.loginservice.services.SessionService;
import us.peaksoft.loginservice.services.UserService;

import java.util.List;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private AccountService accountService;

    @Override
    public UserDto createUSer(String auth, UserDto userDto) {

        UserDto naviUser = sessionService.findSessionByToken(auth).getUserDto();

        AccountDto accountDto = accountService.createAccount(userDto.getAccountDto());
        userDto.setAccountDto(accountDto);

        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        user = userRepository.save(user);

        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public UserDto updateUser(String auth, UserDto userDto) {

        UserDto naviUser = sessionService.findSessionByToken(auth).getUserDto();

        UserDto currUserDto = findUserById(userDto.getId());

        AccountDto accountDto = accountService.updateAccount(userDto.getAccountDto());
        userDto.setAccountDto(accountDto);

        User user = UserMapper.INSTANCE.userDtoToUser(userDto);

        user = userRepository.save(user);

        return UserMapper.INSTANCE.userToUserDto(user);
    }


    @Override
    public UserDto findUserByLogin(String login) {
        User user = userRepository.findUserByLogin(login);

        if (user == null) {
            throw new ResourseNotFoundException("Учетная запись не найдена!");
        }

        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public UserDto findUserById(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Пользователь не найден!"));

        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public boolean deactivateUser(String auth, Long userId) {

        UserDto userDto = findUserById(userId);
        userDto.setActive(false);

        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        user = userRepository.save(user);

        return !user.isActive();
    }

    @Override
    public List<UserDto> findAllUser() {

        List<User> list = userRepository.findAll(Sort.by(Sort.Direction.ASC, "active", "name"));

        return UserMapper.INSTANCE.usersToUserDtos(list);
    }

    @Override
    public UserDto findUserById(String auth, Long id) {
        UserDto naviUser = sessionService.findSessionByToken(auth).getUserDto();
        return findUserById(id);
    }

    @Override
    public List<UserDto> findAllUsers(String auth) {
        UserDto naviUser = sessionService.findSessionByToken(auth).getUserDto();
        return findAllUser();
    }
}
