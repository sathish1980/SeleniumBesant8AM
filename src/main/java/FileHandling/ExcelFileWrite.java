package FileHandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileWrite {

	String filepath= "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumBesant8AM\\Input\\output.xlsx";

	String[] Courses = {"Python","Java","C#","Selenium"};

	public void WriteData() throws IOException
	{
		File F = new File(filepath);
		FileOutputStream Fs = new FileOutputStream(F);
		XSSFWorkbook wbk = new XSSFWorkbook();
		Sheet sheet = wbk.createSheet("Outputdata");
		for (int i=0;i<Courses.length;i++)
		{
			Row eachRow = sheet.createRow(i);

			Cell eachCell =eachRow.createCell(i);
			eachCell.setCellValue(Courses[i]);
		}
		wbk.write(Fs);
		Fs.close();
		System.out.println("Done");
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelFileWrite E = new ExcelFileWrite();
		E.WriteData();
	}

}
