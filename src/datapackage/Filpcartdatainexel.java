package datapackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.excel.lib.util.Xls_Reader;

public class Filpcartdatainexel {
	@Test
	public void  filpcart() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\workspace\\patil\\driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.flipkart.com/");
	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	
	//* search for a product
	   driver.findElement(By.name("q")).sendKeys("Mobiles");
			 
	driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	Thread.sleep(3000);	
	List<WebElement> allmobiles = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	 int rowscount=allmobiles.size()+1;
	 System.out.println(rowscount);
	List<WebElement> allprices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	 
	
	
	//get all product names and send it to excel
	
	 Xls_Reader reader=new Xls_Reader("C:\\Users\\user\\Desktop\\workspace\\exelproject\\New Microsoft Excel Worksheet.xlsx");
	if(!reader.isSheetExist("filpcarttestdata")) {
	 reader.addSheet("filpcarttestdata");
	 reader.addColumn("filpcarttestdata", "MobileName");
	 reader.addColumn("filpcarttestdata", "Price");
	 }
	for(int i=2;i<=rowscount;i++) {
		String mobiletext =allmobiles.get(i).getText();
		System.out.println(mobiletext);
			reader.setCellData("filpcarttestdata", "MobileName",i,mobiletext);
	
	
			String pricetext =allprices.get(i).getText();
		//	String pricetext1 = pricetext.replaceAll("?", "");
			System.out.println(pricetext);
				reader.setCellData("filpcarttestdata", "Price",i,pricetext);
			
}
	
}
}