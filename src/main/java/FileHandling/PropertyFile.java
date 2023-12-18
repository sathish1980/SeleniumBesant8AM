package FileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

	String filepath = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumBesant8AM\\Input\\TestData.properties";

	public void GetProperty() throws IOException
	{
		File f = new File(filepath);
		FileInputStream Fs = new FileInputStream(f);
		Properties p = new Properties();
		p.load(Fs);
		System.out.println(p.getProperty("username"));
		System.out.println(p.getProperty("password"));

		System.out.println(p.getProperty("dob"));

		System.out.println(p.getProperty("address"));

		p.setProperty("address","Chennai");

		System.out.println(p.getProperty("address"));


	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PropertyFile P = new PropertyFile();
		P.GetProperty();
	}

}
