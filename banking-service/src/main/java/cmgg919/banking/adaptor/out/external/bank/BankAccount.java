package cmgg919.banking.adaptor.out.external.bank;

import lombok.Data;
import lombok.Getter;

@Data
public class BankAccount {
    private String bankName;
    private String bankAccountNumber;


    private boolean isValid;


    public BankAccount(String bankName, String bankAccountNumber, boolean isValid) {
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.isValid = isValid;
    }
}
