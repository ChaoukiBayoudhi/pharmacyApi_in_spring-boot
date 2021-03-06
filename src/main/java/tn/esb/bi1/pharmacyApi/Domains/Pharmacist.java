package tn.esb.bi1.pharmacyApi.Domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Pharmacist {
    @Id
    @Column(name="pharmacist_cin", length=8)
    private String cin;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    @JsonFormat(pattern="hh:mm")
    @NonNull
    private LocalTime startTime;

    //relation avec PharmacistPrescription
    @OneToMany(mappedBy = "pharmacist",cascade=CascadeType.ALL)
    private Set<PharmacistPrescription> pharmacistPrescriptionSet=new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pharmacist that = (Pharmacist) o;
        return cin.equals(that.cin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cin);
    }
}
