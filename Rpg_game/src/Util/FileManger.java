package Util;

public class FileManger {
	private FileManger() {
		
	}
	private static FileManger instance;
	
	public static FileManger GetInstance() {
		if(instance == null) instance = new FileManger();
		return instance;
	}
	
	public void SaveData() {
		
	}
	
	public String LoadData() {
		return "";
	}
}
