package cmgg919.banking.application.service;

import com.cmgg919.common.UseCase;
import cmgg919.banking.adaptor.out.persistence.MembershipJpaEntity;
import cmgg919.banking.adaptor.out.persistence.MembershipMapper;
import cmgg919.banking.application.port.in.FindMembershipCommand;
import cmgg919.banking.application.port.in.FindMembershipUseCase;
import cmgg919.banking.application.port.out.FindMembershipPort;
import cmgg919.banking.domain.Membership;

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
