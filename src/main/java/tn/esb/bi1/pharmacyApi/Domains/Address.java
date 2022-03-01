package tn.esb.bi1.pharmacyApi.Domains;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data //genère getters, setters, RequiredArgsConstructor, toString, equals et hashCode
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private int number;
    @NonNull
    private String street;
    @NonNull
    private String city;
    @NonNull
    private int postalCode;
    @OneToOne
    private Laboratory lab;
}
