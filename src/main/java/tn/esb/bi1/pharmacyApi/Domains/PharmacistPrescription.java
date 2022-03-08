package tn.esb.bi1.pharmacyApi.Domains;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
}
