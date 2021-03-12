package us.peaksoft.loginservice.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Data
@JsonIgnoreProperties(value = "id, startDate, userDto")
public class SessionDto {


    private Long id;

    private String token;

    private Date startDate;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private Date endDate;

    private UserDto userDto;
}
