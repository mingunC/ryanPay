package cmgg919.banking.adaptor.in.web;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestFirmBankingRequest {

    // a -> b 실물 계좌로 요청을 하기 위한 request
    private String fromBankName;

    private String fromBankAccountNumber;

    private String toBankName;

    private String toBankAccountNumber;

    private int moneyAmount;
}
