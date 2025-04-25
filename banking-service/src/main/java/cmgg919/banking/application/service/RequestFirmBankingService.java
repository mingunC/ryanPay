package cmgg919.banking.application.service;

import cmgg919.banking.adaptor.out.external.bank.ExternalFirmBankingRequest;
import cmgg919.banking.adaptor.out.external.bank.FirmBankingResult;
import cmgg919.banking.adaptor.out.persistence.FirmBankingRequestJpaEntity;
import cmgg919.banking.adaptor.out.persistence.FirmBankingRequestMapper;
import cmgg919.banking.application.port.in.RequestFirmBankingCommand;
import cmgg919.banking.application.port.in.RequestFirmBankingUseCase;
import cmgg919.banking.application.port.out.RegisterBankAccountPort;
import cmgg919.banking.application.port.out.RequestBankAccountInfoPort;

import cmgg919.banking.application.port.out.RequestExternalFirmBankingPort;
import cmgg919.banking.application.port.out.RequestFirmBankingPort;
import cmgg919.banking.domain.FirmBankingRequest;
import com.cmgg919.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static java.util.UUID.randomUUID;


@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestFirmBankingService implements RequestFirmBankingUseCase {

    private final FirmBankingRequestMapper mapper;

    private final RequestFirmBankingPort requestFirmBankingPort;
    private final RequestExternalFirmBankingPort requestExternalFirmBankingPort;


    @Override
    public FirmBankingRequest requestFirmBanking(RequestFirmBankingCommand command) {
        UUID uuid = randomUUID();

        // Business Logic
        // a -> b account
        // 1. 요청에 대해 정보를 먼저 write, 요청상태로
        FirmBankingRequestJpaEntity requestedEntity = requestFirmBankingPort.createFirmBankingRequest(
                new FirmBankingRequest.FromBankName(command.getFromBankName()),
                new FirmBankingRequest.FromBankAccountNumber(command.getFromBankAccountNumber()),
                new FirmBankingRequest.ToBankName(command.getToBankName()),
                new FirmBankingRequest.ToBankAccountNumber(command.getToBankAccountNumber()),
                new FirmBankingRequest.MoneyAmount(command.getMoneyAmount()),
                new FirmBankingRequest.FirmBankingStatus(0) // 0: requested
        );
        // 2. 외부 은행에 펌뱅킹 요청
        FirmBankingResult result = requestExternalFirmBankingPort.requestExternalFirmBanking(new ExternalFirmBankingRequest(
                command.getFromBankName(),
                command.getFromBankAccountNumber(),
                command.getToBankName(),
                command.getToBankAccountNumber(),
                command.getMoneyAmount()  // Add the missing parameter
        ));

        // Transactional UUID
        UUID randomUUID = randomUUID();
        requestedEntity.setUuid(randomUUID.toString());
        // 3. 결과에 따라서 1번에서 작성했던 FirmBankingRequest 정보를 Update
        if(result.getResultCode() == 0) {
            //success

            requestedEntity.setFirmBankingStatus(1);
        } else {
            //failure
            requestedEntity.setFirmBankingStatus(2);
        }

        // 4. 결과를 리턴하기 전에 바뀐 상태 값을 기준으로 다시 save
        return mapper.mapToDomainEntity(requestFirmBankingPort.modifyFirmBankingRequest(requestedEntity), randomUUID);
    }
}

