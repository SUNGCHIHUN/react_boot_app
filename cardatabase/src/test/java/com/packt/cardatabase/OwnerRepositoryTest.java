package com.packt.cardatabase;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;

@DataJpaTest
public class OwnerRepositoryTest {
    @Autowired
    private OwnerRepository repository;

    @Test
    @DisplayName("New Owner Save Test")
    void saveOwner() { // 데이터베이스에 신규 유저 추가 테스트
        repository.save(new Owner("Lucy", "Smith"));
        assertThat(repository.findByFirstName("Lucy").isPresent()).isTrue();
    }

    @Test
    @DisplayName("Delete Owners Test")
    void deleteOwners() { // 데이터베이스의 모든 소유자 삭제 테스트
        repository.save(new Owner("Lisa", "Morrision"));
        repository.deleteAll();
        assertThat(repository.count()).isEqualTo(0);
    }
    
}
