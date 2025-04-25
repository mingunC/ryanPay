package cmgg919.banking.application.port.out;

import cmgg919.banking.adaptor.out.external.bank.ExternalFirmBankingRequest;
import cmgg919.banking.adaptor.out.external.bank.FirmBankingResult;

public interface RequestExternalFirmBankingPort {

    FirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest request);
}
