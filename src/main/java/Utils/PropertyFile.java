package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

	static String filepath = System.getProperty("user.dir")+"\\Environment\\env.properties";

	public static Properties GetProperty() throws IOException
	{
		File f = new File(filepath);
		FileInputStream Fs = new FileInputStream(f);
		Properties p = new Properties();
		p.load(Fs);
		return p;
		/*System.out.println(p.getProperty("username"));
		System.out.println(p.getProperty("password"));

		System.out.println(p.getProperty("dob"));

		System.out.println(p.getProperty("address"));

		p.setProperty("address","Chennai");

		System.out.println(p.getProperty("address"));

		 */
	}

}