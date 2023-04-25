package lovestory.service;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;

import lovestory.exception.VerifyTokenException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;


import lombok.RequiredArgsConstructor;
import lovestory.domain.Member;
import lovestory.domain.Role;


@Service
@RequiredArgsConstructor
public class GoogleAuthService {
    @Value("${google-client-id}")
    private String CLIENT_ID;
    private final NetHttpTransport transport = new NetHttpTransport();
    private final JsonFactory jsonFactory = new GsonFactory();
    private final OAuthService oAuthService;

    public Member verifyToken(String token) {

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(CLIENT_ID))
                .build();
        try {
            GoogleIdToken idToken = verifier.verify(token);

                Payload payload = idToken.getPayload();

                // Print user identifier
                String userId = payload.getSubject();
                System.out.println("User ID: " + userId);

                // Get profile information from payload
                String email = payload.getEmail();
                boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
                String name = (String) payload.get("name");
                String pictureUrl = (String) payload.get("picture");
                String locale = (String) payload.get("locale");
                String familyName = (String) payload.get("family_name");
                String givenName = (String) payload.get("given_name");


                Member member = oAuthService.saveOrUpdate(Member.builder().name(name).email(email).picture(pictureUrl).role(Role.USER).build());
                return member;


        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            throw new VerifyTokenException();
        } catch (IOException e) {
            e.printStackTrace();
            throw new VerifyTokenException();
        }
    }



}
