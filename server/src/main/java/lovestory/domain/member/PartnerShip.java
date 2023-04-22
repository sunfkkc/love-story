package lovestory.domain.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PartnerShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;


}
