package FileHandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class TextFileWrite {

	String filepath = System.getProperty("user.dir")+"\\Input\\outputdata.txt";

	String Writefilepath = System.getProperty("user.dir")+"\\Input\\outputdata.txt";
	String name = "Besant technology";
	int number =104;

	String Readfilepath = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumBesant8AM\\Input\\inputdata.txt";


	public void CopyPasteData() throws IOException
	{
		File SourceFile = new File(Readfilepath);
		File DestinationFile = new File(Writefilepath);
		FileUtils.copyFile(SourceFile, DestinationFile);
		System.out.println("Done");
	}

	public void Writefile() throws IOException
	{
		File f = new File(filepath);
		FileOutputStream Fs = new FileOutputStream(f);
		Fs.write(name.getBytes());
		System.out.println("Done");
	}

	public void WritefilewithFileWrite() throws IOException
	{
		File f = new File(filepath);
		FileWriter Fs = new FileWriter(f);
		Fs.write(name);
		Fs.close();
		System.out.println("Done");
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		TextFileWrite T = new TextFileWrite();
		T.CopyPasteData();
	}

}
