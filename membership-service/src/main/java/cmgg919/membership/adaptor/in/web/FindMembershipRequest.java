package cmgg919.membership.adaptor.in.web;

import cmgg919.membership.application.port.in.RegisterMembershipCommand;
import cmgg919.membership.domain.Membership;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindMembershipRequest {

    private String membershipId;
}
