package us.peaksoft.loginservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import us.peaksoft.loginservice.models.domain.Session;
import us.peaksoft.loginservice.models.dto.SessionDto;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Mapper
public interface SessionMapper {
    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

    Session sessionDtoToSession(SessionDto sessionDto);

    SessionDto sessionToSessionDto(Session session);
}
