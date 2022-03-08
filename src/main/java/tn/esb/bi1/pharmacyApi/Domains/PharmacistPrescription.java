package tn.esb.bi1.pharmacyApi.Domains;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

//Pour decrire la table association
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class PharmacistPrescription  {
    @EmbeddedId //pour dire que id est une clé primaire composite
    private  PharmacistPrescriptionId id;
    @Column(name="purchase_date")
    @NonNull
    private LocalDate date;
    @NonNull
    private BigDecimal amount;
    //definir la relation entre pharmacist et pharmacistPersecription
    @ManyToOne
    @MapsId("idPharmacist")//l'instance pharmacist est liée à une partie
    // de la clé primaire composite(idPharmacist)
    private Pharmacist pharmacist;

    //definir la relation entre prescription et pharmacistPrescription
    @ManyToOne
    @MapsId("idPrescription")
    private Prescription prescription;
}
