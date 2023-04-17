package lovestory.domain.auth.google;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterRequest {
    private String token;


    public RegisterRequest(String token) {
        this.token = token;
    }
}
