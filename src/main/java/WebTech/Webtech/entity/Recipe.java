package WebTech.Webtech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String name;
 @Column(columnDefinition = "TEXT")
 private String description;
 private String image;
 private String category;
 @Column(columnDefinition = "TEXT")
 private String ingredients;
 @Column(columnDefinition = "TEXT")
 private String instructions;
 private String author;

}
