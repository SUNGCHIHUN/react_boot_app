package com.packt.cardatabase.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand, model, color, registerNumber;
    @Column(name="`year`")
    private int year;
    private int price;

    // EAGER: 해당 소유자와 연관된 모든 자동차를 즉시 검색
    // LAZY: 해당 소유자와 연관된 모든 자동차를 지연 검색(필요할 때), 
    @ManyToOne(fetch=FetchType.LAZY) // 1:N, ~ToMany는 LAZY 생략 가능(Default)
    @JoinColumn(name="owner") // Join
    private Owner owner;

    @ManyToMany(mappedBy="cars") // M:N
    private Set<Owner> owners = new HashSet<Owner>();
    
    public Car() {}

    public Car(String brand, String model, String color, String registerNumber, int year, int price, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.year = year;
        this.price = price;
        this.owner = owner;
    }
}