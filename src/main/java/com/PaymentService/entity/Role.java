package com.PaymentService.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "role")
public class Role extends BaseEntity{
    private String name;
    private Long userId;


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Privilege> privilegeList;
}
