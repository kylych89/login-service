package us.peaksoft.loginservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import us.peaksoft.loginservice.models.domain.User;
import us.peaksoft.loginservice.models.dto.UserDto;

import java.util.List;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

    List<User> userDtosToUsers(List<UserDto> userDtos);

    List<UserDto> usersToUserDtos(List<User> users);
}
