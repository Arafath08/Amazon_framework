package excel_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.lib.util.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement userName = driver.findElement(By.name("username"));
		WebElement pwd = driver.findElement(By.name("password"));

		
		Xls_Reader reader = new Xls_Reader("./Excel_utils/com/excel/lib/util/SampleExcel.xlsx");
		String sheetName = "login";
		
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("Row count " + rowCount);

		for(int rowNum=2; rowNum<=rowCount; rowNum++){
			String condition=reader.getCellData(sheetName, "Condition", rowNum);
			if (condition.equalsIgnoreCase("Yes")) {
				String loginId = reader.getCellData(sheetName, "username", rowNum);
				String passsword = reader.getCellData(sheetName, "password", rowNum);

				System.out.println(loginId + " " + passsword);
				
				userName.clear();
				userName.sendKeys(loginId);
				
				pwd.clear();
				pwd.sendKeys(passsword);	
				reader.setCellData(sheetName, "status", rowNum, "Pass");
			}
			else 
			{
				System.out.println(" condition doesnt exist");
				reader.setCellData(sheetName,"status", rowNum, "Not Executed");
			}
		
			
			
		}
		
		
		
	}

}