package com.accesadades.botiga.Model;

import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long category_id;
    @Column
    private String name;
    @Column(name = "creation_at")
    private LocalDateTime creationDate;
    @Column(name = "updated_at")
    private LocalDateTime updateDate;
}
