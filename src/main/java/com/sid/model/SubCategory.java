package com.sid.model;


import com.fasterxml.jackson.annotation.*;
import com.sid.security.Auditable;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Table(name = "sub_category")
@Data
@JsonIgnoreProperties()
public class SubCategory extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "categoryid", insertable = false, updatable = false)
    private Category category;
    private Long categoryid;

}
