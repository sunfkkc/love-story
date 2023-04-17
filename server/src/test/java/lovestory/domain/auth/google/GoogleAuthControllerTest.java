package lovestory.domain.auth.google;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lovestory.domain.auth.google.controller.GoogleAuthController;

public class GoogleAuthControllerTest {

    @Test
    public void 구글_로그인_토큰(){

        String token = "google_test_token";
        RegisterRequest request = new RegisterRequest(token);
        GoogleAuthController googleAuthController = new GoogleAuthController();

        String result = googleAuthController.member(request);

        assertThat(result).isEqualTo(token);
    }
}
