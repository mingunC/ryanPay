package cmgg919.membership.application.port.out;

import cmgg919.membership.adaptor.out.persistence.MembershipJpaEntity;
import cmgg919.membership.domain.Membership;


public interface RegisterMembershipPort {

    MembershipJpaEntity createMembership(
            Membership.MembershipName membershipName
            ,Membership.MembershipEmail membershipEmail
            ,Membership.MembershipAddress membershipAddress
            ,Membership.MembershipIsValid membershipIsValid
            ,Membership.MembershipIsCorp membershipIsCorp
    );
}
