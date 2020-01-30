package excel_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Excel_Read_basics {
	public void readExcel() throws IOException {
		 File FilePath =    new File("C:/Users/ap82/Desktop/Sample_basicExcel.xlsx");
		 FileInputStream inputStream = new FileInputStream(FilePath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Credentials");
        XSSFRow row = sheet.getRow(2);
         
        //get row and its last cell number
        int row_number=row.getRowNum();
        System.out.print("row_number:"+row_number+ "\n");
        int Lastcell_number=row.getLastCellNum();
        System.out.print("Lastcell_number:"+Lastcell_number+"\n");
        
        //Reading all rows
        for(int i=0; i < row.getLastCellNum(); i++)
        {
            
        	System.out.print(row.getCell(i).getStringCellValue()+"\t");
                
        }
         
        String column_value = sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.print("\n"+"column_value:    "+column_value+"\n");
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        System.out.print("rowCount:"+rowCount+"\n");
        
        //reading all values from excel 
     /*   for(int i=0; i < rowCount+1; i++)
        {
            for(int j=0;j<Lastcell_number;j++) {
            	System.out.print("\n");	
        	System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"\t");
            }  
        }*/
        
        
        //reading one column
        for(int i=0; i < rowCount+1; i++)
        {
            for(int j=0;j<Lastcell_number;j++) {
            	System.out.print("\t");	
            	if(sheet.getRow(i).getCell(j).getStringCellValue().trim().equals("username")){
            		int columnnumber = j;
            	System.out.print(columnnumber+"\n");
        	System.out.print(sheet.getRow(i).getCell(columnnumber).getStringCellValue()+"\n");
            
            	for (int k=0;k<rowCount+1;k++) {
            	  int columnnumber1=j;
					System.out.print(sheet.getRow(k).getCell(columnnumber1).getStringCellValue()+"\t");	
            	}
            } 
        }}
        
        	/*if(sheet.getRow(0).getCell(0).getStringCellValue().trim().equals("username")) {
        		System.out.print("\n");
        		for (int i=0;i<rowCount+1;i++) {
        		System.out.print(sheet.getRow(i).getCell(0).getStringCellValue()+"\t");	
        	}
        	
        }*/
        
        
        
 
	}

	public static void main(String args[]) throws IOException  {
		Excel_Read_basics DT = new Excel_Read_basics();
		DT.readExcel();
	}
}
