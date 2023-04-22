package lovestory.domain.member;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lovestory.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String pwd;

    @OneToOne
    @JoinColumn
    private PartnerShip partnerShip;

    @Builder
    public Member(String name, String pwd, PartnerShip partnerShip) {
        this.name = name;
        this.pwd = pwd;
        this.partnerShip = partnerShip;
    }
}
