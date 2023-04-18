package lovestory.domain.auth;

import java.io.Serializable;

import lombok.Getter;
import lovestory.domain.member.Member;

@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.picture = member.getPicture();
    }
}
