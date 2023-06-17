package com.packt.cardatabase;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.packt.cardatabase.web.CarController;

@SpringBootTest
class CardatabaseApplicationTests {
	@Autowired
	private CarController carController;

	@Test
	@DisplayName("First example test case")
	void contextLoads() {
		// CarController가 정상적으로 생성되고 주입되었는지 테스트
		assertThat(carController).isNotNull();
	}

}
