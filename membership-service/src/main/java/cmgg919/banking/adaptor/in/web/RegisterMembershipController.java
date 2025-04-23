package cmgg919.banking.adaptor.in.web;

import com.cmgg919.common.WebAdapter;
import cmgg919.banking.application.port.in.RegisterMembershipCommand;
import cmgg919.banking.application.port.in.RegisterMembershipUseCase;
import cmgg919.banking.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping(path="/membership/register")
    public Membership registerMembership(@RequestBody RegisterMembershipRequest request) {

        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();


        return registerMembershipUseCase.registerMembership(command);

    }
}
