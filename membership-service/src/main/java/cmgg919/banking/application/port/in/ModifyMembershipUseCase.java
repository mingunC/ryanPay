package cmgg919.banking.application.port.in;

import cmgg919.banking.domain.Membership;




public interface ModifyMembershipUseCase {

   Membership modifyMembership(ModifyMembershipCommand command);
}
