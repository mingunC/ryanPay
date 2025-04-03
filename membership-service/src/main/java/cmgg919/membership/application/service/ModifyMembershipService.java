package cmgg919.membership.application.service;

import cmgg919.common.UseCase;
import cmgg919.membership.adaptor.out.persistence.MembershipJpaEntity;
import cmgg919.membership.adaptor.out.persistence.MembershipMapper;
import cmgg919.membership.application.port.in.ModifyMembershipCommand;
import cmgg919.membership.application.port.in.ModifyMembershipUseCase;
import cmgg919.membership.application.port.out.ModifyMembershipPort;
import cmgg919.membership.domain.Membership;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@RequiredArgsConstructor
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;

    private final MembershipMapper membershipMapper;

    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {
        MembershipJpaEntity jpaEntity = modifyMembershipPort.modifyMembership(
                new Membership.MembershipId(command.getMembershipId()),
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );
        //entity --> Membership
        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}
