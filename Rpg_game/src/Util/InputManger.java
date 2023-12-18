package Util;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.Scanner;

public class InputManger {
	private static Scanner scanner= new Scanner(System.in);
	
	private InputManger() {
	}
	private static InputManger instance;
	
	public static InputManger GetInstance() {
		if(instance == null) instance = new InputManger();
		
		return instance;
	}
	public String GetString(String s){
		System.out.println(s + "\n>>");
		String inp = scanner.next();
		scanner.nextLine();
		return inp;
	}
	public void Print(String s) {
		System.out.println(s);
	}
	public int Getint(String s) {
		int inp = -1;
		try {
		System.out.println(s + "\n>>");
		inp = scanner.nextInt();
		}catch(AnnotationTypeMismatchException e) {
			System.out.println("숫자를 입력해주세요");
			scanner.nextLine();
		}
		return inp;
	}
}
