package cmgg919.membership.adaptor.out.persistence;

import cmgg919.membership.application.port.out.FindMembershipPort;
import cmgg919.membership.application.port.out.RegisterMembershipPort;
import cmgg919.membership.domain.Membership;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import static java.lang.Long.parseLong;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;
    private final MembershipMapper membershipMapper;

    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        return membershipRepository.save(
                new MembershipJpaEntity(
                membershipName.getNameValue(),
                membershipEmail.getEmailValue(),
                membershipAddress.getAddressValue(),
                membershipIsValid.isValidValue(),
                membershipIsCorp.isCorpValue()
                )
        );

    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));

    }
}
