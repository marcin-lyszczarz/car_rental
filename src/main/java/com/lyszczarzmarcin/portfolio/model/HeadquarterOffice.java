package com.lyszczarzmarcin.portfolio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class HeadquarterOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameRental;
    private String urlRental;
    private String contactAdressRental;
    private String ownerRental;

    @Lob
    @Column(name="BOOK_IMAGE", nullable=false, columnDefinition="mediumblob")
    private byte[] logotypeRental;

    @OneToMany
    private List<BranchOffice> branchOfficeList;


    public HeadquarterOffice(String nameRental, String urlRental, String contactAdressRental, String ownerRental, byte[] logotypeRental) {
        this.nameRental = nameRental;
        this.urlRental = urlRental;
        this.contactAdressRental = contactAdressRental;
        this.ownerRental = ownerRental;
        this.logotypeRental = logotypeRental;
    }

}
