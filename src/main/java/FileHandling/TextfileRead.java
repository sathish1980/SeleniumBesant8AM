package FileHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class TextfileRead {

	String filepath = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumBesant8AM\\Input\\inputdata.txt";

	public void Readfile() throws IOException
	{
		File f = new File(filepath);
		FileInputStream Fs = new FileInputStream(f);
		int i;
		while((i = Fs.read())!=-1)
		{
			System.out.print((char)i);
		}

	}

	public void ReadfileusingFileReader() throws IOException, InterruptedException
	{
		File f = new File(filepath);
		FileReader Fs = new FileReader(f);
		int i;
		while((i = Fs.read())!=-1)
		{
			System.out.print((char)i);
			Thread.sleep(500);
		}

	}

	public void ReadfileusingBufferedReader(String expectedConditions) throws IOException, InterruptedException
	{
		File f = new File(filepath);
		FileReader Fs = new FileReader(f);
		// FileInputStream Fs = new FileInputStream(f);
		int count=0;
		BufferedReader BF = new BufferedReader(Fs);
		String i;
		while((i = BF.readLine())!=null)
		{
			//System.out.println(i);
			String[] afterSplit = i.split("\\s");
			for( String eachValue : afterSplit)
			{
				if(eachValue.equalsIgnoreCase(expectedConditions))
				{
					count = count+1;
				}
			}
			// Thread.sleep(2000);
		}
		System.out.println( "The given String : "+ expectedConditions +"is present "+count+" times in the file");

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		TextfileRead T = new TextfileRead();
		T.ReadfileusingBufferedReader("sathish");
	}

}
