package datapackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.lib.util.Xls_Reader;

public class exlewebtable {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\workspace\\patil\\driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.w3schools.com/html/html_tables.asp");
	////*[@id="customers"]/tbody/tr[2]/td[1]
	//*[@id="customers"]/tbody/tr[3]/td[1]
	//*[@id="customers"]/tbody/tr[7]/td[1]
	List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
	 int rowcount = rows.size();
	 System.out.println(rowcount);
	 Xls_Reader reader=new Xls_Reader("C:\\Users\\user\\Desktop\\workspace\\exelproject\\New Microsoft Excel Worksheet (4).xlsx");
	if(!reader.isSheetExist("webtabledata")) {
	 reader.addSheet("webtabledata");
	 reader.addColumn("webtabledata", "companyname");
	 reader.addColumn("webtabledata", "contact");
	 }
String beforexpath = "//*[@id='customers']/tbody/tr[";
String afterxpath = "]/td[1]";
for(int i=2;i<=rowcount;i++){
	 String actualxpath = beforexpath+i+afterxpath;
	String companydata = driver.findElement(By.xpath(actualxpath)).getText();
	System.out.println(companydata);
	reader.setCellData("webtabledata", "companyname", i,companydata );
	
	//System.out.println("******************");
	//*[@id="customers"]/tbody/tr[2]/td[2]
	//*[@id="customers"]/tbody/tr[5]/td[2]
	String afterxpath1 = "]/td[2]";
	 String actualxpath1 = beforexpath+i+afterxpath1;
		String contactdata = driver.findElement(By.xpath(actualxpath1)).getText();
		System.out.println(contactdata);
		reader.setCellData("webtabledata", "contact", i, contactdata);
	}

}
}