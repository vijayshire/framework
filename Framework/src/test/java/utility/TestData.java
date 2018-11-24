/*

Framework: Data Driven Framework
Author: Dr.Vijay Subhash Hire
Company: Wipro

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
package utility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {

	public static XSSFWorkbook ExcelBook;
	public static XSSFSheet ExcelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static int i,j;
	public static int totalNumbersOfRows=0;
	public static int testColumns=0;
	public static int startRowNum=0;
	public static int endRowNum=0;
	public static int rowCounter=0;
	public static int testRows=0;

	//Method to get Data from Excel and return the object array to Test Case
	/*--------------------------------------------START OF getTestData Function--------------------------------------------------------------------------------*/	
	public static Object [][] getTestData(String FilePath, String SheetName, String sTestCaseName) {

		String[][] tabArray = null; //Declaring String 2D array to store data from excel


		try {

			FileInputStream FileInput = new FileInputStream(FilePath);
			ExcelBook = new XSSFWorkbook(FileInput);
			ExcelSheet = ExcelBook.getSheet(SheetName);
			totalNumbersOfRows = TestData.getTotalRows(ExcelSheet); //getting total rows used in excel
			testRows=TestData.getTestRows(sTestCaseName); //getting only required number of rows to test current Test Case
			tabArray = new String[testRows][testColumns-1]; //Dynamic initialisation of array

			for(i=startRowNum;i<=endRowNum;i++) {


				for( j=0;j<testColumns-1;j++) {


					if(ExcelSheet.getRow(i).getCell(j+1).getCellTypeEnum()==CellType.STRING) 
					{
						tabArray[rowCounter][j]= ExcelSheet.getRow(i).getCell(j+1).getStringCellValue();

					}
					else {

						tabArray[rowCounter][j]= String.valueOf(ExcelSheet.getRow(i).getCell(j+1).getNumericCellValue());


					}


				}

				rowCounter++;
			}

		}

		catch(Exception e) {

			System.out.println(e);
		}

		return tabArray;
	}

	/*---------------------------------------------END OF getTestData FUNCTION---------------------------------------------------------------------------------------*/


	/*-------------------------------------------- START OF getTestRows FUNCTION------------------------------------------------------------------------------------------------------------------*/	

	public static int getTestRows(String sTestCaseName) {

		int rows=0;

		for(int n=1;n<=totalNumbersOfRows;n++) {


			if(ExcelSheet.getRow(n).getCell(0).getStringCellValue().equals(sTestCaseName)) {


				TestData.getColumnsCount(ExcelSheet.getRow(n));
				if (startRowNum == 0)
				{

					startRowNum = ExcelSheet.getRow(n).getCell(0).getRowIndex();
					rows++;
					endRowNum =  ExcelSheet.getRow(n).getCell(0).getRowIndex();
				}

				else {

					rows++;
					endRowNum =  ExcelSheet.getRow(n).getCell(0).getRowIndex();

				}

			}

		}

		return rows;

	}

	/*------------------------------------END OF getTestRows FUNCTION-------------------------------------------------------------------------------------------------------------------*/	




	/*-------------------------------------START OF getColumnsCount FUNCTION----------------------------------------------------------------------------------------------------------------------------------------------*/	
	public static void getColumnsCount(XSSFRow xssfRow) {

		List<Cell> cells = new ArrayList<>();
		Iterator<Cell> cellIterator = xssfRow.cellIterator();
		while (cellIterator.hasNext()) {
			cells.add(cellIterator.next());

		}
		for (int i = cells.size(); i >= 0; i--) {
			System.out.println("Cells Size Before"+cells.size());
			Cell cell = cells.get(i-1);
			if (cell.toString().trim().isEmpty()) {
				cells.remove(i-1);
				System.out.println("Cell Reomved");
			} else {
				testColumns = cells.size() > testColumns ? cells.size() : testColumns;
				break;
			}
		}


	}
	/*-------------------------------------END OF getColumnsCount FUNCTION----------------------------------------------------------------------------------------------------------------------------------------------*/	




	/*-------------------------------------START OF getTotalRows FUNCTION----------------------------------------------------------------------------------------------------------------------------------------------*/	


	public static int getTotalRows(XSSFSheet xssfSheet) {

		Iterator<Row> rowIterator = xssfSheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if(row.getCell(0).getStringCellValue().isEmpty()) {

				xssfSheet.removeRow(row);


			}

		}
		return xssfSheet.getLastRowNum() ;


	}

	/*-------------------------------------END OF getTotalRows FUNCTION----------------------------------------------------------------------------------------------------------------------------------------------*/	

}

/*-------------------------------------END OF TestData CLASS----------------------------------------------------------------------------------------------------------------------------------------------*/	

