package lovestory.domain.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lovestory.domain.ErrorResponse;
import lovestory.domain.member.DuplicatedMemberException;
import lovestory.domain.member.Member;
import lovestory.domain.member.dto.RegisterMemberDto;
import lovestory.domain.member.service.RegisterMemberService;

@RequiredArgsConstructor
@RestController
public class RegisterMemberController {
    private final RegisterMemberService registerMemberService;
    @PostMapping("/api/v1/auth/register")
    public ResponseEntity<Member> register(@RequestBody RegisterMemberDto registerMemberDto){
        Member member= registerMemberService.save(registerMemberDto);
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    @ExceptionHandler(DuplicatedMemberException.class)
    public ResponseEntity<ErrorResponse> handleDuplicated(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("이름 중복"));
    }
}
