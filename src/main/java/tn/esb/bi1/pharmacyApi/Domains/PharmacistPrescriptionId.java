package tn.esb.bi1.pharmacyApi.Domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable //l'existence de cette classe depend de la classe "PharmacistPrescription"
//Pour definr la clé primaire composite
//Une classe embaddable doit necessairement implementer l'interface Serializable, doit aussi redefinir Equals and HashCode, doit avoir un constructeur non parametré et parametré et genere getters and setters
public class PharmacistPrescriptionId implements Serializable {
    @Column(name="pharmacist_cin")
    private String idPharmacist;
    @Column(name = "prescription_id")
    private Long idPrescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacistPrescriptionId that = (PharmacistPrescriptionId) o;
        return idPharmacist.equals(that.idPharmacist) && idPrescription.equals(that.idPrescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPharmacist, idPrescription);
    }
}
