package us.peaksoft.loginservice.services.impl;

import org.mapstruct.ap.shaded.freemarker.template.utility.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.peaksoft.loginservice.dao.SessionRepository;
import us.peaksoft.loginservice.exceptions.IncorrectPassword;
import us.peaksoft.loginservice.exceptions.SessionNotFound;
import us.peaksoft.loginservice.exceptions.UserIsNotActive;
import us.peaksoft.loginservice.mappers.SessionMapper;
import us.peaksoft.loginservice.mappers.UserMapper;
import us.peaksoft.loginservice.models.domain.Session;
import us.peaksoft.loginservice.models.dto.SessionDto;
import us.peaksoft.loginservice.models.dto.UserDto;
import us.peaksoft.loginservice.services.PasswordService;
import us.peaksoft.loginservice.services.SessionService;
import us.peaksoft.loginservice.services.UserService;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Service
public class SessionServiceImpl implements SessionService {


    @Autowired
    private PasswordService passwordService;

    @Autowired
    private UserService userService;

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public SessionDto appendNewSession(UserDto userDto) {
        closeSession(userDto);
        Session session = new Session();
        session.setStartDate(new Date());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 5);

        session.setEndDate(calendar.getTime());
        session.setUser(UserMapper.INSTANCE.userDtoToUser(userDto));
        session.setToken(UUID.randomUUID().toString());
        session = sessionRepository.save(session);
        return SessionMapper.INSTANCE.sessionToSessionDto(session);
    }

    @Override
    public boolean closeSession(UserDto userDto) {
        Session session = sessionRepository.findByUserAndEndDateIsAfter(UserMapper.INSTANCE.userDtoToUser(userDto), new Date());
        if (session != null) {
            session.setEndDate(new Date());
            sessionRepository.save(session);
        }
        return true;
    }

    @Override
    public SessionDto login(String login, String password) {
        UserDto userDto = userService.findUserByLogin(login);
        if (!userDto.isActive()) {
            throw new UserIsNotActive("Пользователь не активен");
        }

        password = passwordService.generatePassword(password);

        if (!userDto.getAccountDto().getPassword().equals(password)) {
            throw new IncorrectPassword("Неверный пароль");
        }

        return appendNewSession(userDto);
    }

    @Override
    public boolean closeSession(String auth) {
        Session session = sessionRepository.findByToken(auth);

        if (session != null) {
            session.setEndDate(new Date());
            session = sessionRepository.save(session);
        }
        return true;
    }

    @Override
    public SessionDto findSessionByToken(String token) {
        Session session = sessionRepository.findByToken(token);

        if (session == null) {
            throw new SessionNotFound("Сессия не найдена");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 5);

        session.setEndDate(calendar.getTime());
        session = sessionRepository.save(session);
        return SessionMapper.INSTANCE.sessionToSessionDto(session);
    }
}
