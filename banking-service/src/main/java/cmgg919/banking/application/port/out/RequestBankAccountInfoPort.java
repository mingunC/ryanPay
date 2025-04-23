package cmgg919.banking.application.port.out;

import cmgg919.banking.adaptor.out.external.bank.BankAccount;
import cmgg919.banking.adaptor.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {

    BankAccount getBankAccountInfo(GetBankAccountRequest request);
}
