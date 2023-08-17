package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PhoneList02 {

	public static void main(String[] args) throws FileNotFoundException {
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
		Scanner sc =  new Scanner(file);
		while(sc.hasNextLine()) {
			String name = sc.next();
			String num1 = sc.next();
			String num2 = sc.next();
			String num3 = sc.next();
			System.out.println(name + ": " + num1 + "-" + num2 + "-" + num3);
		}
		sc.close();
	}

}
