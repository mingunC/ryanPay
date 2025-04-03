package cmgg919.membership.application.service;

import cmgg919.common.UseCase;
import cmgg919.membership.adaptor.out.persistence.MembershipJpaEntity;
import cmgg919.membership.adaptor.out.persistence.MembershipMapper;
import cmgg919.membership.application.port.in.RegisterMembershipCommand;
import cmgg919.membership.application.port.in.RegisterMembershipUseCase;
import cmgg919.membership.application.port.out.RegisterMembershipPort;
import cmgg919.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp()) // 수정: isValid -> isCorp
        );


        return membershipMapper.mapToDomainEntity(jpaEntity);

    }
}
