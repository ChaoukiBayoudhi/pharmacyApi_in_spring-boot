package tn.esb.bi1.pharmacyApi.Domains;


import javax.persistence.Lob;
import java.time.LocalDate;

public class Drug {
    private Long code;
    private String name;
    private double price;
    private LocalDate fabricationDate;
    private LocalDate expirationDate;
    @Lob
    private byte[] image;
}
