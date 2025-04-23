package cmgg919.banking.adaptor.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBankAccountRequest {

    private String membershipId;

    private String bankName;

    private String bankAccountNumber;

    private boolean isValid;
}
