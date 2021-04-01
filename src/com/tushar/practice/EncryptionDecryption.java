package com.tushar.practice;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class EncryptionDecryption {

	public static void main(String[] args) {

		String password = "Thushar_Nikam";
		System.out.println("password before encryption : " + password);
		String encryptedPassword = encryptPassword(password);
		System.out.println("Encoded Password : " + encryptedPassword);
		System.out.println("Decrypted Password : " + decryptPassword(encryptedPassword));
	}

	private static String encryptPassword(String password) {
		Encoder encoder = Base64.getEncoder();
		String encodedPassword = encoder.encodeToString(password.getBytes());
		return encodedPassword;

	}

	private static String decryptPassword(String encryptedPassword) {
		Decoder decoder = Base64.getDecoder();
		String decryptedPassword = new String(decoder.decode(encryptedPassword));
		return decryptedPassword;
	}

}
