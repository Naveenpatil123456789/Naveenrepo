package datapackage;

import com.excel.lib.util.Xls_Reader;

public class datadriven {
public static void main(String[] args) {
	Xls_Reader reader= new Xls_Reader("C:\\Users\\user\\Desktop\\workspace\\exelproject\\newdataexel\\dataschool.xlsx");
	String Sheetname = "information";
	String edata = reader.getCellData(Sheetname, 0, 3);
	reader.addSheet("datacolletion");
//	reader.addColumn("datacolletion", "pass");
	reader.addColumn("information", "percentage");
	System.out.println(reader.getCellData("information","id", 2));
	reader.setCellData("information","id", 2, "200");
	reader.setCellData("datacolletion","pass", 2, "frist");
	int rows = reader.getRowCount("datacolletion");
	System.out.println("no of  rows are :"+rows);
	int coloum = reader.getColumnCount("datacolletion");
	System.out.println("no of  coloum are :"+coloum);
	reader.addSheet("details");
	System.out.println(edata);
}
}
