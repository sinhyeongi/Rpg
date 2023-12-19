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
	private File Unit = new File("src/" + Path + "/Unit.txt");
	private FileManger() {
		TextFile();
	}

	private static FileManger instance;

	private void TextFile() {
		try {
			if (player.exists() == false) {
				player.createNewFile();
			}
			if (Unit.exists() == false) {
				Unit.createNewFile();
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

	public void SaveData(String user,String unit) {
		try(FileWriter fw = new FileWriter(player);
				FileWriter fw2 = new FileWriter(Unit)){
			fw.write(user);
			fw2.write(unit);
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
	public String UnitLoad() {
		String data = "";
		try(BufferedReader bf = new BufferedReader(new FileReader(Unit))){
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
}
