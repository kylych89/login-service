package us.peaksoft.loginservice.models.dto;

import lombok.Data;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Data
public class AccountDto {


    private Long id;

    private String login;

    private String password;
}
