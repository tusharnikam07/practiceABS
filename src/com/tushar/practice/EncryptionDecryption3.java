package com.tushar.practice;

import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncryptionDecryption3 {
	static Cipher cipher;
	static Scanner scanner;
	static SecretKey secretKey;

	static {
		try {
			scanner = new Scanner(System.in);
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
			cipher = Cipher.getInstance("AES");
			secretKey = keyGenerator.generateKey();
		} catch (Exception e) {
		}
	}

	public static void main(String[] args){
		String password = "Thushar-Nikam";
		System.out.println("Password Before Encryption: " + password);
		String encryptedPassword = encrypt(password, secretKey);
		System.out.println("Password After Encryption: " + encryptedPassword);
		System.out.println("Password After Decryption: " + decrypt(encryptedPassword, secretKey));
	}

	public static String encrypt(String password, SecretKey secretKey) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] encryptedByte = cipher.doFinal(password.getBytes());
			return new String(encryptedByte);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String encryptedPassword, SecretKey secretKey) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] decryptedByte = cipher.doFinal(encryptedPassword.getBytes());
			String decryptedPassword = new String(decryptedByte);
			return decryptedPassword;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
