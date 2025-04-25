package cmgg919.banking.adaptor.out.external.bank;

import cmgg919.banking.adaptor.out.persistence.SpringDataRegisteredBankAccountRepository;
import cmgg919.banking.application.port.out.RequestBankAccountInfoPort;
import cmgg919.banking.application.port.out.RequestExternalFirmBankingPort;
import cmgg919.banking.domain.FirmBankingRequest;
import com.cmgg919.common.ExternalSystemAdaptor;
import lombok.RequiredArgsConstructor;


@ExternalSystemAdaptor
@RequiredArgsConstructor
public class BankAccountAdaptor implements RequestBankAccountInfoPort, RequestExternalFirmBankingPort {

    private final SpringDataRegisteredBankAccountRepository bankAccountRepository;

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {

        //실제로 외부 은행에 http를 통해서
        //실제 은행 계좌 정보를 가져오고

        //실제 은행 계좌 -> BankAccount
         return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }

    @Override
    public FirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest request) {
        //실제로 외부 은행에 http 통신을 통해서
        // 펌뱅킹 요청을 하고

        // 그 결과를
        // 외부은행의 실제 결과를 -> ryanPay의 FirmBankingResult로 파싱 받는다.

        //FirmBankingResult result = new FirmBankingResult(0);

        return new FirmBankingResult(0);
    }

}
