package lovestory.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 멤버_등록(){
        String name = "김기찬";
        String pwd = "1234";
        LocalDateTime now = LocalDateTime.now();

        memberRepository.save(Member.builder().name(name).pwd(pwd).build());

        List<Member> members = memberRepository.findAll();

        Member member = members.get(0);

        assertThat(member.getName()).isEqualTo(name);

        assertThat(member.getCreatedDate()).isAfter(now);
        assertThat(member.getModifiedDate()).isAfter(now);
    }
}
