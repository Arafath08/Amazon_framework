package excel_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Write_basics {
	
	    public XSSFRow row = null;
	    public XSSFCell cell = null;
	    
	public boolean Write_cell_data(int colNumber, int rowNum, String value) {
	
	
	XSSFWorkbook workbook;
	try {
		File FilePath =    new File("C:/Users/ap82/Desktop/Sample_basicExcel.xlsx");
		 FileInputStream inputStream = new FileInputStream(FilePath);
		workbook = new XSSFWorkbook(inputStream);
		 XSSFSheet sheet = workbook.getSheet("Credentials");
		   
		  
		   row = sheet.getRow(rowNum);
		   if(row==null)
		       row = sheet.createRow(rowNum);

		   cell = row.getCell(colNumber);
		   if(cell == null)
		       cell = row.createCell(colNumber);
		  //If it is a string, we need to set the cell type as string 
           //if it is numeric, we need to set the cell type as number
		   //cell.setCellType(cellType);	
		   cell.setCellValue(value);
		   System.out.print(value);
		   
		   FileOutputStream fos = new FileOutputStream(FilePath);
		   workbook.write(fos);
		   fos.flush();
		   fos.close();
	} catch (IOException e) {
		return false;
		
	}
	return true;
  
   
}
	public static void main(String args[]) throws IOException  {
		Excel_Write_basics DT = new Excel_Write_basics();
		DT.Write_cell_data(3, 1, "PASSED");
	}
	
}
