package cmgg919.membership.adaptor.in.web;

import cmgg919.common.WebAdapter;
import cmgg919.membership.application.port.in.RegisterMembershipCommand;
import cmgg919.membership.application.port.in.RegisterMembershipUseCase;
import cmgg919.membership.domain.Membership;
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
    Membership registerMembership(@RequestBody RegisterMembershipRequest request) {

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
