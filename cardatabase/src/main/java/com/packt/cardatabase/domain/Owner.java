package com.packt.cardatabase.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ownerId;
    private String firstName, lastName;

    // cascade : 삭제 or 수정 시 연속 효과 지정
    // ALL: 연관된 데이터 모두 삭제 or 수정
    // mappedBy: 기본키 지정
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Car> car; // owner는 여러 대의 자동차를 가진다.

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="cars",
        joinColumns = { @JoinColumn(name="ownerId") },
        inverseJoinColumns = { @JoinColumn(name="`id`") })
    private Set<Car> cars = new HashSet<Car>(); // M:N에서는 List 대신 Set 추천
    

    public Owner(){};

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
}
