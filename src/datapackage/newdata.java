package datapackage;

import com.excel.lib.util.Xls_Reader;

public class newdata {
public static void main(String[] args) {
	Xls_Reader reader= new Xls_Reader("C:\\Users\\user\\Desktop\\workspace\\exelproject\\newdataexel\\New Microsoft Excel Worksheet (4).xlsx");
	String SheetName = "ipl team";
	System.out.println(reader.getCellData(SheetName,0, 1));
}
}
