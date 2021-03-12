package us.peaksoft.loginservice.services;

import us.peaksoft.loginservice.models.dto.AccountDto;

/**
 * Created by Sayfullah on 12.03.2021.
 */
public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto updateAccount(AccountDto accountDto);
}
