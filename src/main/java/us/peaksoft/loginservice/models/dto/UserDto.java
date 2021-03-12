package us.peaksoft.loginservice.models.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Data
public class UserDto {


    private Long id;

    private String name;

    private boolean active;

    private RoleDto roleDto;

    private AccountDto accountDto;

    private List<PhoneDto> phoneDtos;

}
