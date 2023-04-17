package lovestory.domain.auth.google.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import lovestory.config.ErrorResponse;
import lovestory.domain.auth.google.GoogleAuthService;
import lovestory.domain.auth.google.RegisterRequest;
import lovestory.domain.member.Member;

@RestController
@RequiredArgsConstructor
public class GoogleAuthController {
    private final GoogleAuthService googleAuthService;
    private final HttpSession httpSession;

    @PostMapping("/api/v1/auth/google")
    public ResponseEntity<Object> member(@RequestBody @Valid RegisterRequest request, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("invalid token"));
        }
        Member member = googleAuthService.verifyToken(request.getToken());
        return ResponseEntity.status(HttpStatus.OK).body(member);

    }
}
