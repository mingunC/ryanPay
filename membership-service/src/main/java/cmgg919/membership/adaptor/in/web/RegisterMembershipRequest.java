package cmgg919.membership.adaptor.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMembershipRequest {

    private String name;

    private String address;

    private String email;

    private boolean isCorp;
}
