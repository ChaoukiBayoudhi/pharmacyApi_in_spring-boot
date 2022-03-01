package tn.esb.bi1.pharmacyApi.Domains;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data //genère getters, setters, RequiredArgsConstructor, toString, equals et hashCode
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "lab_table",
        uniqueConstraints = {@UniqueConstraint(name = "uniqueNameAndEmail",columnNames = {"name","email"})}
)//permet de personaliser les informations sur une table
public class Laboratory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(name="lab_name", length=50)//permet de personaliser les colonnes au moment de generation du code SQL par l'ORM
    //comme le nom de la colonne (par defaut c'est le nom de l'attribut),taille, nombre de chiffre après la virgule, unique,...
    private String name;
    @NonNull
    //@Column(unique=true)
    @EqualsAndHashCode.Include
    private String email;
    @NonNull
    private String phoneNumber;
    private String siteUrl;
    private String salesManagerName;
    @OneToOne(mappedBy="lab",cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id") //definit la clé etrangère "address_id"
    //referencedColumnName est optionel
    private Address laboratoryAddress;
    @OneToMany(mappedBy = "drugLaboratory",cascade=CascadeType.ALL)
    private Set<Drug> drugs=new HashSet<>();
}
