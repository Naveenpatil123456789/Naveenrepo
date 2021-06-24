package datapackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.lib.util.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	WebElement userid = driver.findElement(By.id("email"));
	WebElement pwdid = driver.findElement(By.id("pass"));
	Xls_Reader reader= new Xls_Reader("C:\\Users\\user\\Desktop\\workspace\\exelproject\\New Microsoft Excel Worksheet (4).xlsx");
	String sheetName = "testdata";
	int rowcount = reader.getRowCount(sheetName);
	for(int rowNum=2;rowNum<=rowcount;rowNum++) {
	String loginid = reader.getCellData(sheetName, "Username", rowNum);
	String password = reader.getCellData(sheetName, "pwd", rowNum);
	System.out.println(loginid+"  "+password);
	userid.clear();
	userid.sendKeys(loginid);
	Thread.sleep(3000);
	pwdid.clear();
	
	 pwdid.sendKeys(password);
	 Thread.sleep(3000); 
	
}
}
}