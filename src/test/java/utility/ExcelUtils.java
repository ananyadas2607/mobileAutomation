package utility;


import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet  ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

	//This method is to set the File path and to open the Excel file

	public static void setExcelFile() throws Exception {

		try {

			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir")+"\\res\\Data.xls");

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet("Sheet1");

		} catch (Exception e){

			throw (e);

		}

	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	public static String getCellData(int Row, int Col) throws Exception{

		try{

			Cell = ExcelWSheet.getRow(Row).getCell(Col);
			String CellData = Cell.getStringCellValue();
			return CellData;

		}catch (Exception e){
			e.getMessage();
			return"";

		}

	}
}
