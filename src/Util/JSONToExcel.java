package Util;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONToExcel {
	public String makeExcelData(String FilePath, boolean autoFileOpen) {
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			// 파일 경로
			String readFilePath = FilePath;
			String writeFilePath = readFilePath.replace(".txt", "_excel.txt");

			br = new BufferedReader(new FileReader(readFilePath));
			bw = new BufferedWriter(new FileWriter(writeFilePath));

			// 파일 읽기
			String line;
			JSONArray dataList = new JSONArray();
			while ((line = br.readLine()) != null) {
				dataList.put(line);
			}

			// KeyList 만들기
			ArrayList<String> keyList = new ArrayList<>();
			for (Object data : dataList) {
				JSONObject json = new JSONObject(data.toString());
				for (String key : json.keySet()) {
					if (!keyList.contains(key))
						keyList.add(key);
				}
			}

			// Key 출력
			for (int i = 0; i < keyList.size(); i++) {
				String key = keyList.get(i);
				System.out.print(key);
				bw.write(key);

				if (i != keyList.size() - 1) {
					System.out.print("\t");
					bw.write("\t");
				}
			}
			System.out.println();
			bw.write("\n");

			// 데이터 출력
			for (Object data : dataList) {
				JSONObject json = new JSONObject(data.toString());
				for (int i = 0; i < keyList.size(); i++) {
					String key = keyList.get(i);
					if (json.isNull(key)) {
						System.out.print("");
						bw.write("");
					} else {
						System.out.print(json.get(key));
						bw.write(json.getString(key));
					}
					if (i != keyList.size() - 1) {
						System.out.print("\t");
						bw.write("\t");
					}
				}
				System.out.println();
				bw.write("\n");
			}

			bw.close();

			if (autoFileOpen) Desktop.getDesktop().edit(new File(writeFilePath));
			return writeFilePath;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
			if (bw != null)
				try {
					bw.close();
				} catch (IOException e) {
				}
		}
		return null;
	}

}
