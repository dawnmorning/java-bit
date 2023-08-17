package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			File file = new File("phone.txt");

			if (!file.exists()) {
				System.out.println("File Not Found");
				return;
			}
			System.out.println("========파일정보==========");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "byte");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));

			System.out.println("===== 전화번호 =====");
			// 1. 기반 스트림(FileInputStream), 받고
			FileInputStream fis = new FileInputStream("phone.txt");
			System.out.println("fis : " + fis);
			// 2. 보조 스트림, 읽어라
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			System.out.println("isr : " + isr);
			// 3. 보조스트림2, String으로
			br = new BufferedReader(isr);

			// 4. 처리
			String line = null;
			while ((line = br.readLine()) != null) {
//				System.out.println(line);
				StringTokenizer st = new StringTokenizer(line, "\t ");
				int idx = 0;
				while (st.hasMoreElements()) {
					String token = st.nextToken();
					if (idx == 0) {
						System.out.print(token + ":");
					} else if (idx == 1) {
						System.out.print(token + "-");
					} else if (idx == 2) {
						System.out.print(token + "-");
					} else {
						System.out.print(token);
					}
					idx++;
				}
				System.out.println("");
			}

		} catch (

		UnsupportedEncodingException e) {
			System.out.println("Error : " + e);
		} catch (IOException e) {
			System.out.println("Error : " + e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
