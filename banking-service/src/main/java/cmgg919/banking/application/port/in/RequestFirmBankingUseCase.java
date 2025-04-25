package cmgg919.banking.application.port.in;


import cmgg919.banking.domain.FirmBankingRequest;


public interface RequestFirmBankingUseCase {
    FirmBankingRequest requestFirmBanking(FirmBankingRequestCommand command);
}
