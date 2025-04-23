package cmgg919.banking.adaptor.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "registered_bank_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredBankAccountJpaEntity {

    @Id
    @GeneratedValue
    private Long registeredBankAccountId;

    private String membershipId;
    private String bankName;
    private String bankAccountNumber;
    private boolean linkedStatusIsValid;
    private int moneyAmount;
    private int firmBankingStatus;

    public RegisteredBankAccountJpaEntity(Long registeredBankAccountId, String membershipId, String bankName, String bankAccountNumber, boolean linkedStatusIsValid, int moneyAmount, int firmBankingStatus) {
        this.registeredBankAccountId = registeredBankAccountId;
        this.membershipId = membershipId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;
        this.moneyAmount = moneyAmount;
        this.firmBankingStatus = firmBankingStatus;
    }

    @Override
    public String toString() {
        return "RegisteredBankAccountJpaEntity{" +
                "membershipId='" + membershipId + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", linkedStatusIsValid=" + linkedStatusIsValid +
                ", moneyAmount=" + moneyAmount +
                ", firmBankingStatus=" + firmBankingStatus +
                '}';
    }
}
