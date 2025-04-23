package cmgg919.banking.adaptor.out.external.bank;

import cmgg919.banking.adaptor.out.persistence.SpringDataRegisteredBankAccountRepository;
import cmgg919.banking.application.port.out.RequestBankAccountInfoPort;
import com.cmgg919.common.ExternalSystemAdaptor;
import lombok.RequiredArgsConstructor;


@ExternalSystemAdaptor
@RequiredArgsConstructor
public class BankAccountAdaptor implements RequestBankAccountInfoPort {

    private final SpringDataRegisteredBankAccountRepository bankAccountRepository;

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {

        //실제로 외부 은행에 http를 통해서
        //실제 은행 계좌 정보를 가져오고

        //실제 은행 계좌 -> BankAccount
         return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }
}
