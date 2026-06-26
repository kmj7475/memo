package com.example.springedu;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringeduApplicationTests {


	@Autowired
	StringEncryptor jasypt;

	@Test
	void propertiesTest() {
		String plainText = ""; // 암호화할 실제 원본값
		String encryptedText = jasypt.encrypt(plainText);

		System.out.println("Encrypted Result: ");
		System.out.println(encryptedText);
	}

}
