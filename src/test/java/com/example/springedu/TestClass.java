package com.example.springedu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestClass {

	@Test
	@DisplayName("정상실행")
	public void test1() {
		assertEquals("a", "a");
	}

	@Test
	@DisplayName("실행실패  ")
	public void test2() {
		assertEquals("b", "b");
	}

}
