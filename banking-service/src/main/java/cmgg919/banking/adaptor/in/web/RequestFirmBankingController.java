package cmgg919.banking.adaptor.in.web;

import cmgg919.banking.application.port.in.RequestFirmBankingUseCase;
import cmgg919.banking.application.port.in.RequestFirmBankingCommand;
import cmgg919.banking.domain.FirmBankingRequest;
import com.cmgg919.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmBankingController {

    private final RequestFirmBankingUseCase requestFirmBankingUseCase;

    @PostMapping(path="/banking/firmBanking/request")
    FirmBankingRequest registerMembership(@RequestBody RequestFirmBankingRequest request) {
        RequestFirmBankingCommand command = RequestFirmBankingCommand.builder()
                .toBankName(request.getToBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .fromBankName(request.getFromBankName())
                .fromBankAccountNumber(request.getFromBankAccountNumber())
                .moneyAmount(request.getMoneyAmount())
                .build();



        return requestFirmBankingUseCase.requestFirmBanking(command);
    }
}
