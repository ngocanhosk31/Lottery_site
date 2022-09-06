package entity;

import java.util.regex.Pattern;

public class Validate {
	public static void main(String[] args){
		System.out.print(validatePass("2898756456")); 
	}
//	public static boolean validateTime(String s) {
//		Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)?[0-9]{2}$");
//		if(p.matcher(s).find()) {
//			return true;
//		}
//		return false;
//	}
	public static boolean validateNumber(String s) {
		Pattern p = Pattern.compile("^\\d+(?:,[ ]?\\d+)*$");
		if(p.matcher(s).find()) {
			return true;
		}
		return false;
	}
	public static boolean validateLotteryNum(String s) {
		Pattern p = Pattern.compile("^[0-9]+$");
		if(p.matcher(s).find()) {
			return true;
		}
		return false;
	}
	public static boolean validatePass(String s) {
		Pattern p = Pattern.compile("^[a-zA-Z0-9]{6,}$");
		if(p.matcher(s).find()) {
			return true;
		}
		return false;
	}
}
