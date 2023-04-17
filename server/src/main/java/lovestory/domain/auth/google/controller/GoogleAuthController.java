package lovestory.domain.auth.google.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lovestory.domain.auth.google.RegisterRequest;
@RestController
public class GoogleAuthController {
    @PostMapping("/api/v1/auth/google")
    public String member(@RequestBody RegisterRequest request){
        return request.getToken();
    }
}
