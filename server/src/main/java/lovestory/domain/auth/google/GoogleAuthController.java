package lovestory.domain.auth.google;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import lovestory.config.ErrorResponse;
import lovestory.domain.auth.google.GoogleAuthService;
import lovestory.domain.auth.google.VerifyTokenException;
import lovestory.domain.auth.google.RegisterRequest;
import lovestory.domain.member.Member;

@RestController
@RequiredArgsConstructor
public class GoogleAuthController {
    private final GoogleAuthService googleAuthService;


    @PostMapping("/api/v1/auth/google")
    public ResponseEntity<Object> member(@RequestBody @Valid RegisterRequest request, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("invalid token"));
        }
        Member member = googleAuthService.verifyToken(request.getToken());
        return ResponseEntity.status(HttpStatus.OK).body(member);

    }

    @ExceptionHandler(VerifyTokenException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("cannot verify token"));
    }
}
