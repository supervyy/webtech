package WebTech.Webtech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Recipe {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String name;
 @Column(length = 1000)
 private String description;
 private String image;
 private String category;
 private String ingredients;
 @Column(length = 1000)
 private String instructions;
 private String author;
 private boolean favorite;
}
