package cmgg919.banking.application.port.in;


import cmgg919.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {

    RegisteredBankAccount registerBankAccount(FirmBankingRequestCommand command);
}
