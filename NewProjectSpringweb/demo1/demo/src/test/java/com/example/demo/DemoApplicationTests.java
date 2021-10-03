package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test_checkHighwayLegalSpeed_positive(){
		Utils utilsTest = new Utils();

		assertEquals(true, utilsTest.checkHighwayLegalSpeed(TestDataUtils.highwayLegalSpeed));

	}

	@Test
	public void test_checkHighwayLegalSpeed_negative(){

		Utils utilsTest = new Utils();

		assertEquals(false, utilsTest.checkHighwayLegalSpeed(TestDataUtils.highwayIllegalSpeed));

	}

	@Test
	public void test_checkUrbanLegalSpeed_positive(){

		Utils utilsTest = new Utils();
		assertEquals(true, utilsTest.checkUrbanLegalSpeed(TestDataUtils.urbanLegalSpeed));
	}

	@Test
	public void test_checkUrbanLegalSpeed_negative(){

		Utils utilsTest = new Utils();
		assertEquals(false, utilsTest.checkUrbanLegalSpeed(TestDataUtils.urbanIllegalSpeed));
	}

}
