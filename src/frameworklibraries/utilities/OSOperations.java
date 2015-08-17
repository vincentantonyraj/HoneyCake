package frameworklibraries.utilities;

import java.io.IOException;

public class OSOperations {

	public static void InvokeApplication(String exeName) throws IOException
	{
		Runtime.getRuntime().exec(exeName);
	}
}
