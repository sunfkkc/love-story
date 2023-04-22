package lovestory.domain.member.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lovestory.domain.member.DuplicatedMemberException;
import lovestory.domain.member.Member;
import lovestory.domain.member.MemberRepository;
import lovestory.domain.member.dto.RegisterMemberDto;

@Service
@RequiredArgsConstructor
public class RegisterMemberService {
    private final MemberRepository memberRepository;

    public Member save(RegisterMemberDto registerMemberDto){

        Optional<Member> member = memberRepository.findByName(registerMemberDto.getName());

        if(member.isPresent()){
            throw new DuplicatedMemberException();
        }

        return memberRepository.save(Member.builder().name(registerMemberDto.getName()).pwd(registerMemberDto.getPwd()).build());

    }
}
