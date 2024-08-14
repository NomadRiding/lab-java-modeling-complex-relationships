package com.ironhack.modeling.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Conferences extends Event{
    @ManyToMany(mappedBy = "conferences")
    private Set<Speaker> speakerList = new HashSet<>();

}