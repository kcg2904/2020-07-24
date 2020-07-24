package utll;

import java.util.regex.Pattern;

public class MyUtil {
	public static String makePhoneNumber(String phoneNoStr) {
		 
	      String regEx = "(\\d{3})(\\d{3,4})(\\d{4})";
	      if(!Pattern.matches(regEx, phoneNoStr)) return null;
	      return phoneNoStr.replaceAll(regEx, "$1-$2-$3");
	   }
}
