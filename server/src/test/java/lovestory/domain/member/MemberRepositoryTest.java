package lovestory.domain.member;



import lovestory.domain.role.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 멤버_등록(){
        String name = "김기찬";
        String email = "rlcks77@nate.com";
        Role role = Role.USER;
        LocalDateTime now = LocalDateTime.now();

        memberRepository.save(Member.builder().name(name).email(email).role(role).build());

        List<Member> members = memberRepository.findAll();

        Member member = members.get(0);

        assertThat(member.getName()).isEqualTo(name);
        assertThat(member.getEmail()).isEqualTo(email);
        assertThat(member.getRole()).isEqualTo(role);

        assertThat(member.getCreatedDate()).isAfter(now);
        assertThat(member.getModifiedDate()).isAfter(now);
    }
}
