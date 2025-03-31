package cmgg919.membership;

import cmgg919.membership.adaptor.in.web.RegisterMembershipRequest;
import cmgg919.membership.domain.Membership;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class RegisterMembershipControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;


    @Test
    public void testRegisterMembership() throws  Exception {
        // Given
        RegisterMembershipRequest request = new RegisterMembershipRequest("name","email","address",false);

        // 응답에서 예상되는 객체
        Membership expect = Membership.generateMember(
                new Membership.MembershipId("1"),
                new Membership.MembershipName("name"),
                new Membership.MembershipEmail("address"),
                new Membership.MembershipAddress("email"),
                new Membership.MembershipIsValid(true),
                new Membership.MembershipIsCorp(false)
        );

// When & Then
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/membership/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(request))
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(expect), true));
    }
}