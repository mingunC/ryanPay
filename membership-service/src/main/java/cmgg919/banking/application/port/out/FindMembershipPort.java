package cmgg919.banking.application.port.out;

import cmgg919.banking.adaptor.out.persistence.MembershipJpaEntity;
import cmgg919.banking.domain.Membership;

public interface FindMembershipPort {

    MembershipJpaEntity findMembership(
            Membership.MembershipId membershipId
    );
}