package frameworklibraries.utilities;

import java.util.Random;

public class General {	

	public static String makeUnique(String value)
	{
		Random randomNumber = new Random();
		int num = randomNumber.nextInt(10000);		
		return value + Integer.toString(num);
				
	}
}
