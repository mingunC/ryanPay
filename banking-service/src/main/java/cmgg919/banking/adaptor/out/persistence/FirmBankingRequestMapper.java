package cmgg919.banking.adaptor.out.persistence;

import cmgg919.banking.domain.FirmBankingRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FirmBankingRequestMapper {

    public FirmBankingRequest mapToDomainEntity(FirmBankingRequestJpaEntity registeredBankAccountJpaEntity, UUID uuid) {
        return FirmBankingRequest.generateFirmBankingRequest(
                new FirmBankingRequest.FirmBankingRequestId(registeredBankAccountJpaEntity.getRequestFirmBankingId() + ""),
                new FirmBankingRequest.FromBankName(registeredBankAccountJpaEntity.getFromBankName()),
                new FirmBankingRequest.FromBankAccountNumber(registeredBankAccountJpaEntity.getFromBankAccountNumber()),
                new FirmBankingRequest.ToBankName(registeredBankAccountJpaEntity.getToBankName()),
                new FirmBankingRequest.ToBankAccountNumber(registeredBankAccountJpaEntity.getToBankAccountNumber()),
                new FirmBankingRequest.MoneyAmount(registeredBankAccountJpaEntity.getMoneyAmount()),
                new FirmBankingRequest.FirmBankingStatus(registeredBankAccountJpaEntity.getFirmBankingStatus()),
                uuid
        );
    }
}
