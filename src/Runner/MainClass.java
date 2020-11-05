package Runner;

import Common.MsgCode;
import Util.CheckData;
import Util.ExcelToInsertQuery;
import Util.JSONToExcel;
import Util.WebmethodToExcel;

public class MainClass {

	public static void main(String[] args) {
		WebmethodToExcel wte = new WebmethodToExcel();
		ExcelToInsertQuery etiq = new ExcelToInsertQuery();
		JSONToExcel jte = new JSONToExcel();
		CheckData cd = new CheckData();
		
		String filePath = "C:\\Users\\82736\\Desktop\\test.txt";
		String tableName = "";
		boolean autoFileOpen = false;

//		tableName = MsgCode.Product;
//		tableName = MsgCode.Price;
		tableName = MsgCode.Order_Response;
//		tableName = MsgCode.Stock; 

		//webmethod ¡æ Excel ¡æ Insert Query
		String result = wte.makeExcelData(filePath, autoFileOpen);	etiq.makeInsertQuery(result, tableName, autoFileOpen);
		
		//JSON ¡æ Excel Form
//		jte.makeExcelData(filePath, autoFileOpen);
		
		//webmethod ¡æ Excel Form
//		result = wte.makeExcelData(filePath, autoFileOpen);
		
		//Excel ¡æ Insert Query
//		etiq.makeInsertQuery(filePath, tableName, autoFileOpen);
		
//		cd.checking(filePath, autoFileOpen);
	}
}
