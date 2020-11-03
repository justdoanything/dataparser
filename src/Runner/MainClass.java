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
		
		String filePath = "C:\\Users\\82736\\Desktop\\DG_STOCK.txt";
		String tableName = "";

//		tableName = MsgCode.Product;
//		tableName = MsgCode.Price;
//		tableName = MsgCode.Order_Response;
		tableName = MsgCode.Stock; 

		//webmethod ¡æ Excel ¡æ Insert Query
//		String result = wte.makeExcelData(filePath);	etiq.makeInsertQuery(result, tableName);
		
		//JSON ¡æ Excel Form
//		jte.makeExcelData(filePath);
		
		//webmethod ¡æ Excel Form
//		result = wte.makeExcelData(filePath);
		
		//Excel ¡æ Insert Query
		etiq.makeInsertQuery(filePath, tableName);
		
//		String path1 = "C:\\Users\\82736\\Desktop\\1webmethod-ecss-20201027.txt";
//		cd.checking(path1);
	}
}
