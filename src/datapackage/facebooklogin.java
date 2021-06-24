package datapackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.lib.util.Xls_Reader;

public class facebooklogin {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\workspace\\patil\\driver\\chromedriver.exe");
WebDriver driver= new ChromeDriver();
	driver.get("https://www.facebook.com/");
	WebElement user = driver.findElement(By.id("email"));
	WebElement pwd = driver.findElement(By.id("pass"));
	Xls_Reader reader= new Xls_Reader("C:\\Users\\user\\Desktop\\workspace\\exelproject\\newdataexel\\dataschool.xlsx");
	String Sheetname = "details";
	int rows = reader.getRowCount("details");
	for(int i=2;i<=rows;i++) {
		String login = reader.getCellData(Sheetname, "username", i);
		String  password= reader.getCellData(Sheetname, "password", i);
		
		user.clear();
		user.sendKeys( login);
		Thread.sleep(2000);
		pwd.clear();
		
		pwd.sendKeys(password);
		Thread.sleep(2000);
	}
	
	driver.close();
	
}
}