package FileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelFileRead {

	String filepath = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumBesant8AM\\Input\\Input.xlsx";
	// String filepath = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumBesant8AM\\Input\\Input.xls";


	public void ReadData()throws IOException
	{
		File F = new File(filepath);
		FileInputStream Fs = new FileInputStream(F);
		// XSSFWorkbook wbk = new XSSFWorkbook(Fs);
		HSSFWorkbook wbk = new HSSFWorkbook(Fs);
		Sheet excelSheet = wbk.getSheet("Search");
		int totalRows = excelSheet.getPhysicalNumberOfRows();
		for (int i=0;i<totalRows;i++)
		{
			Row eachRow = excelSheet.getRow(i);
			int eachColumn = eachRow.getLastCellNum();
			for(int j=0;j<eachColumn;j++)
			{
				Cell eachcell = eachRow.getCell(j);

				//String value =eachcell.getStringCellValue();
				System.out.println(ReaddataWithDataType(eachcell));
			}
		}
		Fs.close();
	}

	public Object ReaddataWithDataType(Cell cellvalue)
	{
		if(cellvalue.getCellType()==CellType.STRING)
		{
			return cellvalue.getStringCellValue();

		}
		else if(cellvalue.getCellType()==CellType.NUMERIC)
		{
			DataFormatter ds = new DataFormatter();
			return ds.formatCellValue(cellvalue);
			//return cellvalue.getNumericCellValue();
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelFileRead E = new ExcelFileRead();
		E.ReadData();
	}

}
