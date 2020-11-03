package Util;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CheckData {

	public void checking(String filePath) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			String readFilePath = filePath;
			String writeFilePath = (readFilePath.contains(".txt")) ? readFilePath.replace(".txt", "_insert.txt") : filePath + "_insert.txt";

			br = new BufferedReader(new FileReader(readFilePath));
			bw = new BufferedWriter(new FileWriter(writeFilePath));

			String line;
			String[] arr = new String[5000];
			int index = 0;
			while ((line = br.readLine()) != null) {
				arr[index++] = line;
			}
			/*
			 * for(int i=0; i<index; i++) {
			 * if(arr[i].contains("\"LINE_STATUS_CODE\":\"CLOSED\"")) {
			 * if(arr[i+1].contains("Fail : There are failed data")) {
			 * System.out.println(arr[i]); bw.write(arr[i]); bw.write("\n"); } } }
			 */
			for (int i = 0; i < index; i++) {
				if (arr[i].contains("Fail : There are failed data")) {
//					System.out.println(arr[i-1]);
					bw.write(arr[i-1]); bw.write("\n");
				}
			}

			bw.close();
			Desktop.getDesktop().edit(new File(writeFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
