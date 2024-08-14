package com.ironhack.modeling.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String district;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "president_id", referencedColumnName = "id")
    private Member president;
    @OneToMany(mappedBy = "chapter")
    private List<Member> memberList;

    public Chapter(Integer id, String chapter, String district) {
        this.id = id;
        this.name = chapter;
        this.district = district;
    }
}