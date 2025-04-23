package cmgg919.banking.adaptor.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMembershipRepository extends JpaRepository<MembershipJpaEntity, Long> {
    // 기본 CRUD 메서드는 JpaRepository에서 자동으로 제공됩니다

    // 필요한 경우 커스텀 쿼리 메서드를 여기에 추가할 수 있습니다
    // 예: 이메일로 회원 조회
    // MembershipJpaEntity findByEmail(String email);
}
