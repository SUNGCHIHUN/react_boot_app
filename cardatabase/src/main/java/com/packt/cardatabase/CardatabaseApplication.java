package com.packt.cardatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	// Spring Boot Log
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
    private UserRepository urepository;

	// Spring Boot Start
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("React Boot App Started!!");
	}

	// Application이 완전히 시작되기 전 추가 코드 실행
	@Override
	public void run(String... args) throws Exception {

		// 소유자 객체를 추가하고 DB에 저장
		Owner owner1 = new Owner("John", "Johnson");		
		Owner owner2 = new Owner("Mary", "Johnson");
		ownerRepository.saveAll(Arrays.asList(owner1, owner2));

		// 자동차 객체를 추가하고 소유자 객체와 연결한 후 DB에 저장
		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1));
		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2));
		repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, owner2));
		
		// 모든 자동차를 조회 -> 로그 출력
		for (Car car : repository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}

		// 사용자1 이름: user, 암호: user
		urepository.save(new User("user", "$2a$04$2mCXATIBFBkHymd0sn0JB.ElEyk6LzC5/4/2KeAY8e8s00cB04WbO", "USER"));

		// 사용자2 이름: admin, 암호: admin
		urepository.save(new User("admin", "$2a$04$wVmciRBL98H/kss4O3Y4IOWu/Uf1sWYXpNjdApSd0MbNPLoTAXes6", "ADMIN"));


	}

}
