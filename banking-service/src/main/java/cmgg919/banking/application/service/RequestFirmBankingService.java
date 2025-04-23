package cmgg919.banking.application.service;

import cmgg919.banking.adaptor.out.persistence.FirmBankingRequestMapper;
import cmgg919.banking.application.port.in.RequestFirmBankingCommand;
import cmgg919.banking.application.port.in.RequestFirmBankingUseCase;
import cmgg919.banking.application.port.out.RegisterBankAccountPort;
import cmgg919.banking.application.port.out.RequestBankAccountInfoPort;

import cmgg919.banking.domain.FirmBankingRequest;
import com.cmgg919.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestFirmBankingService implements RequestFirmBankingUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;

    private final FirmBankingRequestMapper mapper;

    private final RequestBankAccountInfoPort requestBankAccountInfoPort;


    @Override
    public FirmBankingRequest requestFirmBanking(RequestFirmBankingCommand command) {
        return null;
    }
}
