  package datapackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.lib.util.Xls_Reader;

public class adddatainexel {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\workspace\\patil\\driver\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[4]/td[2]
	String bforeXpath = "//*[@id='customers']/tbody/tr[ ";
 String aforeXpath = "]/td[1]";
 String aforeXpath1 = "]/td[2]";
 String aforeXpath2 = "]/td[3]";
List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
int rowcount = rows.size();
System.out.println("no of rows: "+rowcount);
Xls_Reader reader= new Xls_Reader("C:\\Users\\user\\Desktop\\workspace\\exelproject\\newdataexel\\dataschool.xlsx");
if(!reader.isSheetExist("webtabledata")){
reader.addSheet("webtabledata");
reader.addColumn("webtabledata","company" );
reader.addColumn("webtabledata","contact" );
reader.addColumn("webtabledata","country" );
}
for(int i=2;i<= rowcount;i++) {
	String actualxpath = bforeXpath+i+aforeXpath;
	String companydata = driver.findElement(By.xpath(actualxpath)).getText();
	System.out.println( companydata);
		reader.setCellData("webtabledata", "company",i,companydata )	;
	
	String actualxpath1 = bforeXpath+i+aforeXpath1;
	String contactdata = driver.findElement(By.xpath(actualxpath1)).getText();
	System.out.println( contactdata);
	reader.setCellData("webtabledata", "contact",i,contactdata )	;
	
	
	String actualxpath2 = bforeXpath+i+aforeXpath2;
	String countrydata = driver.findElement(By.xpath(actualxpath2)).getText();
	System.out.println( countrydata);
	reader.setCellData("webtabledata", "country",i,countrydata)	;
	
	
}

//*[@id="customers"]/tbody/tr[1]/th[2]
//*[@id="customers"]/tbody/tr[1]/th[1]
List<WebElement> coloums = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr[1]/th"));
int colcount = coloums.size();
System.out.println("no of coloum: "+colcount);
		
		
		
}
}
