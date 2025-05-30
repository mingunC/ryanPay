package cmgg919.banking.application.port.out;

import cmgg919.banking.adaptor.out.persistence.MembershipJpaEntity;
import cmgg919.banking.domain.Membership;


public interface RegisterMembershipPort {

    MembershipJpaEntity createMembership(
            Membership.MembershipName membershipName
            ,Membership.MembershipEmail membershipEmail
            ,Membership.MembershipAddress membershipAddress
            ,Membership.MembershipIsValid membershipIsValid
            ,Membership.MembershipIsCorp membershipIsCorp
    );
}
