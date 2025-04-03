package cmgg919.membership.adaptor.in.web;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyMembershipRequest {

    private String membershipId;

    private String name;

    private String address;

    private String email;

    private boolean isValid;

    private boolean isCorp;
}
