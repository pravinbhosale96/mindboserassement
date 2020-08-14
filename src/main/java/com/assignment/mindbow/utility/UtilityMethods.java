package com.assignment.mindbow.utility;

public class UtilityMethods {
	
	public static boolean isNullOrEmpty(String string) {
		
		if(string!=null)
		{
			if(string.isEmpty())
			{
				return true;
			}
			return false;
		}
		else
		{
			return true;
		}
		
	}

}
