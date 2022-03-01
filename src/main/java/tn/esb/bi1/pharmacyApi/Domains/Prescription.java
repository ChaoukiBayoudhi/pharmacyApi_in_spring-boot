package tn.esb.bi1.pharmacyApi.Domains;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate visitDate;
    private Integer treatmentDuration;
    private Double price;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate purchaseDate;
}
