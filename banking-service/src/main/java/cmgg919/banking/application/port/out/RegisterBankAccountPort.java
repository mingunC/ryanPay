package cmgg919.banking.application.port.out;

import cmgg919.banking.adaptor.out.persistence.RegisteredBankAccountJpaEntity;
import cmgg919.banking.domain.RegisteredBankAccount;


public interface RegisterBankAccountPort {

    RegisteredBankAccountJpaEntity createRegisteredBankAccount(
            RegisteredBankAccount.MembershipId membershipId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
    );
}
