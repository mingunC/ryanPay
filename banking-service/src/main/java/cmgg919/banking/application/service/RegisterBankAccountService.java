package cmgg919.banking.application.service;

import cmgg919.banking.adaptor.out.external.bank.BankAccount;
import cmgg919.banking.adaptor.out.external.bank.GetBankAccountRequest;
import cmgg919.banking.adaptor.out.persistence.RegisteredBankAccountJpaEntity;
import cmgg919.banking.adaptor.out.persistence.FirmBankingRequestMapper;
import cmgg919.banking.application.port.in.FirmBankingRequestCommand;
import cmgg919.banking.application.port.in.RegisterBankAccountUseCase;
import cmgg919.banking.application.port.out.RegisterBankAccountPort;
import cmgg919.banking.application.port.out.RequestBankAccountInfoPort;
import cmgg919.banking.domain.RegisteredBankAccount;
import com.cmgg919.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;

    private final FirmBankingRequestMapper mapper;

    private RequestBankAccountInfoPort requestBankAccountInfoPort;

    @Override
    public RegisteredBankAccount registerBankAccount(FirmBankingRequestCommand command) {

        //은행 계좌를 등록해야하는 서비스( 비즈니스 로직)
        // 1. 외부 실제 은행에 등록이 가능한 계좌인지(정상인지) 확인한다
        //command.getMembershipId();

        // 외부의 은행에 이 계좌 정상인지? 확인을 해야한다
        // Biz logic -> external system
        // Port -> Adaptor -> external system
        // Port
        //command.getBankName();
        //command.getBankAccountNumber();

        //실제 외부의 은행계좌 정보를 Get
        BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
        boolean accountIsValid = accountInfo.isValid();

        // 2. 등록가능한 계좌라면, 등록한다. 성공하면, 등록에 성공한 등록 정보를 리턴
        // 2-1. 등록가능하지 않은 계좌라면 에러를 리턴

        //받은 정보가 유효 하다면 등록 정보 저장
        if (accountIsValid) {
            RegisteredBankAccountJpaEntity savedAccountInfo = registerBankAccountPort.createRegisteredBankAccount(
                    new RegisteredBankAccount.MembershipId(command.getMembershipId() + ""),
                    new RegisteredBankAccount.BankName(command.getBankName()),
                    new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisteredBankAccount.LinkedStatusIsValid(command.isValid())
            );

            return mapper.mapToDomainEntity(savedAccountInfo);
        } else {
            return null;
        }
    }
}
