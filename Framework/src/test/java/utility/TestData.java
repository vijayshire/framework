package utility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import testCases.NewTest;

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
	public static int totalNumbersOfRows;
	public static int totalNumbersOfColumns;
	public static Object [][] getExcelArray(String FilePath, String SheetName, String sTestCaseName) {
		
		String[][] tabArray = null;
		int startrow=0;
		int startcolumn=0;
		
		
		
		int testrow;
		
		try {
			
			FileInputStream FileInput = new FileInputStream(FilePath);
			ExcelBook = new XSSFWorkbook(FileInput);
			ExcelSheet = ExcelBook.getSheet(SheetName);
			
			totalNumbersOfRows = ExcelSheet.getLastRowNum();
			totalNumbersOfColumns = ExcelSheet.getRow(1).getLastCellNum();
			
			testrow=TestData.testRows(sTestCaseName);
			System.out.println("test row:"+testrow);
			tabArray = new String[testrow][2];
			
			for(i=0;i<totalNumbersOfRows;i++) {
				if(TestData.checkTestCase(i+1).equalsIgnoreCase(sTestCaseName))
				{
					//int a = TestData.testCol(i+1);
					totalNumbersOfColumns= TestData.getColumnsCount(ExcelSheet.getRow(i+1));
					System.out.println("TestName:"+ExcelSheet.getRow(i+1).getCell(0).getStringCellValue());					
					System.out.println("Column:"+totalNumbersOfColumns);
					
					
				 
				for( j=0;j<totalNumbersOfColumns-1;j++) {
					
					
					System.out.println("I am column"+(j+1));
					System.out.println("I am row"+(i+1));
					
					if(ExcelSheet.getRow(i+1).getCell(j+1).getCellTypeEnum()==CellType.STRING) 
					{
					tabArray[startrow][j]= ExcelSheet.getRow(i+1).getCell(j+1).getStringCellValue();
					
					}
					else {
						
					tabArray[startrow][j]= String.valueOf(ExcelSheet.getRow(i+1).getCell(j+1).getNumericCellValue());
					
					
					}
					System.out.println("My Data:"+tabArray[startrow][j]);	
					
					}
					
				startrow++;
			}
		}
			
			
		}
		
		catch(Exception e) {
			
			System.out.println(e);
		}
			
		return tabArray;
	}
		
	
	public static String checkTestCase (int rownum)
	
	{
		
		return ExcelSheet.getRow(rownum).getCell(0).getStringCellValue();
	}
	
	public static int testRows(String sTestCaseName) {
		
		int testrows=0;
		
		for(int n=1;n<=totalNumbersOfRows;n++) {
			
						
					if(ExcelSheet.getRow(n).getCell(0).getStringCellValue().equals(sTestCaseName)) {
						
					testrows++;
					System.out.println("Number of Column in row :"+n+"is = " +ExcelSheet.getRow(n).getLastCellNum());
				}
				
		}
			
		return testrows;
		
	}
	
	/*public static int testCol(int row1) {
		
		System.out.println("Row for Col:"+(row1));
		return ExcelSheet.getRow(row1).getPhysicalNumberOfCells();
	}*/
	
	private static int getColumnsCount(XSSFRow xssfRow) {
	    int result = 0;
	   // Iterator<Row> rowIterator = xssfSheet.iterator();
	   // while (rowIterator.hasNext()) {
	     //   Row row = rowIterator.next();
	    
	        List<Cell> cells = new ArrayList<>();
	        Iterator<Cell> cellIterator = xssfRow.cellIterator();
	        while (cellIterator.hasNext()) {
	            cells.add(cellIterator.next());
	            
	                   }
	        for (int i = cells.size(); i >= 0; i--) {
	        	
	        	System.out.println("Cells of Row: "+xssfRow.getRowNum()+"is = "+cells.size());
	            Cell cell = cells.get(i-1);
	            if (cell.toString().trim().isEmpty()) {
	                cells.remove(i-1);
	            } else {
	                result = cells.size() > result ? cells.size() : result;
	                break;
	            }
	        }
	   // }
	    return result;
	}
	
	
	}


