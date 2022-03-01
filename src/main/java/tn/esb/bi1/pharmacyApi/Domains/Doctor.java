package tn.esb.bi1.pharmacyApi.Domains;

import lombok.*;
import tn.esb.bi1.pharmacyApi.Enumerations.DoctorSpeciality;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    @Column(unique = true, nullable = false)
    private String email;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)    //cette annotation informe l'ORM que le type de speciality est chaine ce caractères
    @Column(columnDefinition = "FamilyDoctor")
    private DoctorSpeciality speciality;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return firstName.equals(doctor.firstName) && lastName.equals(doctor.lastName) && email.equals(doctor.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }
}
