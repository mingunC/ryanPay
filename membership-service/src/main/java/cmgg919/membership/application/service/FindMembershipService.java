package cmgg919.membership.application.service;

import cmgg919.membership.adaptor.out.persistence.MembershipJpaEntity;
import cmgg919.membership.adaptor.out.persistence.MembershipMapper;
import cmgg919.membership.application.port.in.FindMembershipCommand;
import cmgg919.membership.application.port.in.FindMembershipUseCase;
import cmgg919.membership.application.port.out.FindMembershipPort;
import cmgg919.membership.domain.Membership;
import common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MembershipJpaEntity entity = findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
        return membershipMapper.mapToDomainEntity(entity);

    }
}
