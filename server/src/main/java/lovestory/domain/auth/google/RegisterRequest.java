package lovestory.domain.auth.google;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank
    private String token;


    public RegisterRequest(String token) {
        this.token = token;
    }
}
