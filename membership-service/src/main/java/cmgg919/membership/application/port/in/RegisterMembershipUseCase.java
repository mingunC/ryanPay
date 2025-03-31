package cmgg919.membership.application.port.in;

import cmgg919.membership.domain.Membership;



public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);
}
