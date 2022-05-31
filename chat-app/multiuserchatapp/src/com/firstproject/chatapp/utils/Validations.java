package com.firstproject.chatapp.utils;

public interface Validations {
	public static boolean isValidEmail(String email) {
		if(email!=null && email.length()>=0) {
			if(email.contains("@") && (email.endsWith(".com")|| email.endsWith(".org") || email.endsWith(".in"))) {
				return true;
			}
			else {
				return false;
			}
		}
		
		else {
			return false;
		}
		
	}
}
