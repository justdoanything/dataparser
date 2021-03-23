package Runner;

import Common.MsgCode;
import Util.CheckData;
import Util.ExcelToInsertQuery;
import Util.ExcelToInsertQuery_bulk;
import Util.JSONToExcel;
import Util.WebmethodToExcel;

public class MainClass {

	public static void main(String[] args) {
		WebmethodToExcel wte = new WebmethodToExcel();
		ExcelToInsertQuery etiq = new ExcelToInsertQuery();
		JSONToExcel jte = new JSONToExcel();
		CheckData cd = new CheckData();
		ExcelToInsertQuery_bulk bulk = new ExcelToInsertQuery_bulk();
		
		String filePath = "C:\\Users\\82736\\Desktop\\11new 1.txt";
		String tableName = "";
		boolean autoFileOpen = false;

		tableName = MsgCode.sample;

		//webmethod ¡æ Excel ¡æ Insert Query
//		String result = wte.makeExcelData(filePath, autoFileOpen);	etiq.makeInsertQuery(result, tableName, autoFileOpen);
		
		//JSON ¡æ Excel Form
//		jte.makeExcelData(filePath, autoFileOpen);
		
		//webmethod ¡æ Excel Formvmfwpr
//		result = wte.makeExcelData(filePath, autoFileOpen);
		
		//Excel ¡æ Insert Query
//		etiq.makeInsertQuery(filePath, tableName, autoFileOpen);
		bulk.makeInsertQuery(filePath, tableName, autoFileOpen);
		
//		cd.checking(filePath, autoFileOpen);
	}
}
