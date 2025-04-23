package cmgg919.banking.adaptor.in.web;

import cmgg919.banking.application.port.in.FirmBankingRequestCommand;
import cmgg919.banking.application.port.in.RegisterBankAccountUseCase;
import cmgg919.banking.application.port.in.RequestFirmBankingCommand;
import cmgg919.banking.application.port.in.RequestFirmBankingUseCase;
import cmgg919.banking.domain.RegisteredBankAccount;
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
    RegisteredBankAccount registerMembership(@RequestBody RegisterBankAccountRequest request) {
        RequestFirmBankingCommand command = RequestFirmBankingCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .isValid(request.isValid())
                .build();
        return requestFirmBankingUseCase.requestFirmBanking(command);
    }
}
