package lovestory.domain.member;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lovestory.domain.BaseTimeEntity;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @JsonIgnore
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
