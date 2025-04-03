package cmgg919.membership.application.port.in;

import cmgg919.common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

    @NotNull
    private final String name;

    @NotNull
    @NotBlank
    private final String email;

    @NotNull
    @NotBlank
    private final String address;


    @AssertTrue
    private final boolean isValid;


    private final boolean isCorp;

//    public RegisterMembershipCommand(String name) {
//
//        this.name = name;
//    }

    @Builder
    public RegisterMembershipCommand(String name, String email, String address, boolean isValid, boolean isCorp) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;

        this.validateSelf();
    }
}
