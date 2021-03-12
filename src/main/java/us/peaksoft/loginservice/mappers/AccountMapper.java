package us.peaksoft.loginservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import us.peaksoft.loginservice.models.domain.Account;
import us.peaksoft.loginservice.models.dto.AccountDto;

/**
 * Created by Sayfullah on 12.03.2021.
 */
@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account accountDtoToAccount(AccountDto accountDto);

    AccountDto accountToAccountDto(Account account);
}
