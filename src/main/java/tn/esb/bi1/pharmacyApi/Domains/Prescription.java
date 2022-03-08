package tn.esb.bi1.pharmacyApi.Domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd")
    @NonNull
    private LocalDate visitDate;
    @NonNull
    private Integer treatmentDuration;
    private Double amount;

    @JsonFormat(pattern="yyyy-MM-dd")
    @NonNull
    private LocalDate purchaseDate;
   //redefine equals and hashCode

    //implementation de la relation n-n entre "Drug" et "Prescription"
    @ManyToMany
    private Set<Drug> drugs=new HashSet<>();

    //relation avec PharmacistPrescription
    @OneToMany(mappedBy = "prescription",cascade=CascadeType.ALL)
    private Set<PharmacistPrescription> pharmacistPrescriptionSet=new HashSet<>();

}
