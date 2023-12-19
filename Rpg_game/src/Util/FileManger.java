package Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManger {
	private String Path = this.getClass().getPackageName();
	private File player = new File("src/" + Path + "/player.txt");

	private FileManger() {
		TextFile();
	}

	private static FileManger instance;

	private void TextFile() {
		try {
			if (player.exists() == false) {
				player.createNewFile();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static FileManger GetInstance() {
		if (instance == null)
			instance = new FileManger();
		return instance;
	}

	public void SaveData(String user) {
		try(FileWriter fw = new FileWriter(player)){
			fw.write(user);
			System.out.println("파일저장 완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String userLoad() {
		String data = "";
		try(BufferedReader bf = new BufferedReader(new FileReader(player))){
			
			int i;
			while((i = bf.read()) != -1) {
				data += (char)i;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	public String LoadData() {
		return "";
	}
}
