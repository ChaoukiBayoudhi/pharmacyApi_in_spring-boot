package tn.esb.bi1.pharmacyApi.Domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
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
}
