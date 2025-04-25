package cmgg919.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FirmBankingRequest {

    @Getter private final String firmBankingRequestId;

    @Getter private final String fromBankName;

    @Getter private final String fromBankAccountNumber;

    @Getter private final String toBankName;

    @Getter private final String toBankAccountNumber;

    @Getter private final int moneyAmount;

    @Getter private final int firmBankingStatus; // 0: requested 1: completed 2: failed

    @Getter private final UUID uuid;

    public static FirmBankingRequest generateFirmBankingRequest(
        FirmBankingRequestId firmBankingRequestId,
        FromBankName fromBankName,
        FromBankAccountNumber fromBankAccountNumber,
        ToBankName toBankName,
        ToBankAccountNumber toBankAccountNumber,
        MoneyAmount moneyAmount,
        FirmBankingStatus firmBankingStatus,
        UUID uuid
    ) {
        return new FirmBankingRequest(
                firmBankingRequestId.getFirmBankingRequestId(),
                fromBankName.getFromBankName(),
                fromBankAccountNumber.getFromBankAccountNumber(),
                toBankName.toBankName,
                toBankAccountNumber.getToBankAccountNumber(),
                moneyAmount.getMoneyAmount(),
                firmBankingStatus.firmBankingStatus,
                uuid
        );
    }

    @Value
    public static class FirmBankingRequestId{

        public FirmBankingRequestId(String value) {
            this.FirmBankingRequestId = value;
        }
        String FirmBankingRequestId;
    }

    @Value
    public static class FromBankName{

        public FromBankName(String value) {
            this.fromBankName = value;
        }
        String fromBankName;
    }

    @Value
    public static class FromBankAccountNumber{

        public FromBankAccountNumber(String value) {
            this.fromBankAccountNumber = value;
        }
        String fromBankAccountNumber;
    }

    @Value
    public static class ToBankName{

        public ToBankName(String value) {
            this.toBankName = value;
        }
        String toBankName;
    }

    @Value
    public static class ToBankAccountNumber{

        public ToBankAccountNumber(String value) {
            this.toBankAccountNumber = value;
        }
        String toBankAccountNumber;
    }

    @Value
    public static class MoneyAmount{

        public MoneyAmount(int value) {
            this.moneyAmount = value;
        }
        int moneyAmount;
    }

    @Value
    public static class FirmBankingStatus{

        public FirmBankingStatus(int value) {
            this.firmBankingStatus = value;
        }
        int firmBankingStatus;
    }
}
