package cmgg919.banking.application.port.out;

import cmgg919.banking.adaptor.out.persistence.FirmBankingRequestJpaEntity;
import cmgg919.banking.adaptor.out.persistence.RegisteredBankAccountJpaEntity;
import cmgg919.banking.domain.FirmBankingRequest;
import cmgg919.banking.domain.RegisteredBankAccount;


public interface RequestFirmBankingPort {

    FirmBankingRequestJpaEntity createFirmBankingRequest(
        FirmBankingRequest.FromBankName fromBankName,
        FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber,
        FirmBankingRequest.ToBankName toBankName,
        FirmBankingRequest.ToBankAccountNumber toBankAccountNumber,
        FirmBankingRequest.MoneyAmount moneyAmount,
        FirmBankingRequest.FirmBankingStatus firmBankingStatus
    );

    FirmBankingRequestJpaEntity modifyFirmBankingRequest(
        FirmBankingRequestJpaEntity entity
    );
}
