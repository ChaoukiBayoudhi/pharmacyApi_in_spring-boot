package tn.esb.bi1.pharmacyApi.Domains;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
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
    private String name;
    private double price;
    @EqualsAndHashCode.Include
    private LocalDate fabricationDate;
    @EqualsAndHashCode.Include
    private LocalDate expirationDate;
    private String description;
    private int stock;
    @Lob
    private byte[] image;

}
