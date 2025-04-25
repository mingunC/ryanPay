package cmgg919.banking.adaptor.out.external.bank;

import lombok.Data;

@Data
public class FirmBankingResult {

    private int resultCode;  // 0: 성공, 1: 실패

    public FirmBankingResult(int resultCode) {
        this.resultCode = resultCode;
    }


}
