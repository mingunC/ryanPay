package cmgg919.membership.application.port.out;

import cmgg919.membership.adaptor.out.persistence.MembershipJpaEntity;
import cmgg919.membership.application.port.in.FindMembershipUseCase;
import cmgg919.membership.domain.Membership;

public interface FindMembershipPort {

    MembershipJpaEntity findMembership(
            Membership.MembershipId membershipId
    );
}