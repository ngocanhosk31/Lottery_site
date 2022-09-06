package entity;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Library {

	public static String md5(String str){
		String result = "";
		MessageDigest digest = null;
		
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			digest.update(str.getBytes());
			BigInteger bigInteger = new BigInteger(1,digest.digest());
			result = bigInteger.toString(16);
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(MD5Library.md5("1234567"));;
	}
}
