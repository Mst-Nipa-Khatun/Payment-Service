package com.PaymentService.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;  //common for all
    protected Integer status; //common for all

    protected Date createdAt;
    protected Date updatedAt;
    protected String createdBy;
    protected String updatedBy;

    @PrePersist       //For auto save
    public void preSave(){
        this.status = 1;
        this.createdAt = new Date();
    }
    @PreUpdate   //For auto update
    public void preUpdate(){
        this.updatedAt = new Date();
    }

}
