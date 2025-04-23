package cmgg919.banking.adaptor.out.persistence;

import cmgg919.banking.application.port.out.RegisterBankAccountPort;
import cmgg919.banking.application.port.out.RequestFirmBankingPort;
import cmgg919.banking.domain.FirmBankingRequest;
import cmgg919.banking.domain.RegisteredBankAccount;
import com.cmgg919.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;


@PersistenceAdapter
@RequiredArgsConstructor
public class FirmBankingRequestPersistentAdaptor implements RequestFirmBankingPort {

    private final SpringDataRegisteredBankAccountRepository firmBankingRequestRepository;

    @Override
    public FirmBankingRequestJpaEntity createFirmBankingRequest(FirmBankingRequest.FromBankName fromBankName, FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber, FirmBankingRequest.ToBankName toBankName, FirmBankingRequest.ToBankAccountNumber toBankAccountNumber, FirmBankingRequest.MoneyAmount moneyAmount, FirmBankingRequest.FirmBankingStatus firmBankingStatus) {
        FirmBankingRequestJpaEntity entity = firmBankingRequestRepository.save(new FirmBankingRequestJpaEntity(
               fromBankName.getFromBankName(),
               fromBankAccountNumber.getFromBankAccountNumber(),
               toBankName.getToBankName(),
               toBankAccountNumber.getToBankAccountNumber(),
                moneyAmount.getMoneyAmount(),
                firmBankingStatus.getFirmBankingStatus())
        );


        return entity;
    }
}
