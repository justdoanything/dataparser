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
		
		String filePath = "D:\\01.OBS\\21.ÀÌ¿ë¿ì\\40.Interface\\30 Rollout\\21 GP2\\SA\\product.txt";
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
		etiq.makeInsertQuery(filePath, tableName, autoFileOpen);
		
//		cd.checking(filePath, autoFileOpen);
	}
}
