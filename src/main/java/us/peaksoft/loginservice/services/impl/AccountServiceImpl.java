package us.peaksoft.loginservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.peaksoft.loginservice.dao.AccountRepository;
import us.peaksoft.loginservice.exceptions.ResourseNotFoundException;
import us.peaksoft.loginservice.mappers.AccountMapper;
import us.peaksoft.loginservice.models.domain.Account;
import us.peaksoft.loginservice.models.dto.AccountDto;
import us.peaksoft.loginservice.services.AccountService;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.INSTANCE.accountDtoToAccount(accountDto);
        account = accountRepository.save(account);
        return AccountMapper.INSTANCE.accountToAccountDto(account);
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto) {
        Account account = accountRepository.findById(accountDto.getId()).orElseThrow(()-> new ResourseNotFoundException("Account not found ->" + accountDto));
        account.setLogin(accountDto.getLogin());
        account.setPassword(accountDto.getPassword());
        account = accountRepository.save(account);
        return AccountMapper.INSTANCE.accountToAccountDto(account);
    }
}
