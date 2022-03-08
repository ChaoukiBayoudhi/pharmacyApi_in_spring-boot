package tn.esb.bi1.pharmacyApi.Domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter //genère tous les getters pour tous les attributs , au moment du runtime
@Setter
@NoArgsConstructor //genère un constructeur non paramétré
//@AllArgsConstructor //génère un constructure avec tous les paramètres
//@ToString //redefinit la methode toString en retournant les valeurs de tous attributs
//@ToString(exclude={"stock","image"})//retourne les valeurs de tous les attributs sauf celles de stock et image.

@ToString(exclude = "image")//retourne tous sauf l'image
//@EqualsAndHashCode //permet de redefinir les deux méthodes "equals" et "hashCode" en se basant sur tous les attributs pour comparer
//@EqualsAndHashCode(exclude={"image","decription","code"})//compare par tous les attributs sauf "image" "description" et "code".
@EqualsAndHashCode(onlyExplicitlyIncluded = true)//utilise uniquement les attributs annotés avec @...Include dans la comparaison
@Entity //permet de mentionner à l'ORM : Object Relational Mapping que la classe Drug sera transformer en une table relationnelle
public class Drug {
    @Id //l'attribut "code" est la clé primaire de la table Drug
    @GeneratedValue (strategy = GenerationType.IDENTITY) //permet de generer automatiquemnt les valeurs de la clé primaire
    private Long code;
    @EqualsAndHashCode.Include
    @Column(unique=true)
    private String name;
    @Column(precision = 7, scale=2)//le prix est sur 7 chiffres y compris deux après la virgule
    private double price;
    @EqualsAndHashCode.Include
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fabricationDate;
    @EqualsAndHashCode.Include
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate expirationDate;
    private String description;
    @Column(columnDefinition = "integer default 0", nullable = false)
    private int stock;
    @Lob
    private byte[] image;
    @ManyToOne
    @JoinColumn(name="laboratory_id")
    private Laboratory drugLaboratory;

    //implementation de la relation n-n entre "Drug" et "Prescription"
    @ManyToMany
    //definition de la table association (PersectiptionDrugs)
    @JoinTable(name="prescription_drugs",
            //en SQL :
            //constraint fk1 foreign key drug_code references Drug(code)
            //dans ce cas l'attribut referencedColumnName est optionnel
            joinColumns = @JoinColumn(name="drug_code",referencedColumnName = "code"),
            inverseJoinColumns = @JoinColumn(name="prescription_id",referencedColumnName = "id")
    )
    private Set<Prescription> prescriptions=new HashSet<>();

}
