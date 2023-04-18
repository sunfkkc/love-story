package lovestory.domain.auth;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import lovestory.domain.auth.dto.SessionUser;
import lovestory.domain.member.Member;
import lovestory.domain.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class OAuthService {
    private final MemberRepository memberRepository;
    private final HttpSession httpSession;

    public Member saveOrUpdate(Member member){
        Member updatedMember = memberRepository.findByEmail(member.getEmail()).map(entity->entity.update(member.getName(),member.getPicture())).orElse(member);
        httpSession.setAttribute("user",new SessionUser(updatedMember));
        return memberRepository.save(updatedMember);
    }

}
