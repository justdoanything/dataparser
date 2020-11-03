package Util;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExcelToInsertQuery {

	public static void makeInsertQuery(String FilePath, String tableName) {
		BufferedReader br = null;
		BufferedWriter bw = null;
        try {      	
        	String readFilePath = FilePath;
        	String writeFilePath = readFilePath.replace(".txt", "_insert.txt");            
            
        	br = new BufferedReader(new FileReader(readFilePath));
            bw = new BufferedWriter(new FileWriter(writeFilePath));

            String line;
            String[] arr = new String[5000];
            int index = 0;
            while ((line = br.readLine()) != null) {
                arr[index++] = line;
            }
            
            // ���̺� ����
            String insertQuery = "";
            insertQuery += tableName;
            
            // �÷��� ����
            arr[0] = arr[0].replace("\t", ",");
            
            // �ʿ��� �ʵ� �߰�
            //arr[0] = arr[0] + ",INTERFACE_ID,JOB_TYPE_CODE";
            
            insertQuery += arr[0] + ") VALUES ('";
                        
            // INTERFACE_ID ���۰� ����
            // int INTERFACE_ID = 1;
            
            // INSERT - BODY �ۼ�
    		for(int i=1; i< arr.length; i++) {
    			if(arr[i] == null)
    				break;
				arr[i] = insertQuery + arr[i] + "'";
				arr[i] = arr[i].replace("\t", "','");
				arr[i] = arr[i].replace("''", "null");
				//arr[i] += "," + INTERFACE_ID++;		//	INTERFACE_ID
				//arr[i] += ",'I'";						//	JOB_TYPE_CODE
				arr[i] += ");";
    		}
    		
    		// ��� ���    		
    		for(int i = 1; i < arr.length; i++) {
    			if(arr[i] == null)
    				break;
    			System.out.println(arr[i]);
    			bw.write(arr[i]);
    			bw.write("\n");
    		}
    		bw.close();
    		Desktop.getDesktop().edit(new File(writeFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null) try {br.close(); } catch (IOException e) {}
            if(bw != null) try {bw.close(); } catch (IOException e) {}
        }
		
	}
}
