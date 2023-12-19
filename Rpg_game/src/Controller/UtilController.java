package Controller;
import Util.*;

public class UtilController {
	FileManger fm = FileManger.GetInstance();
	InputManger im = InputManger.GetInstance();
	
	public String GetString(String s) {
		return im.GetString(s);
	}
	public int GetInt(String s) {
		return im.Getint(s);
	}
	public void Save(String data,String data2) {
		fm.SaveData(data,data2);
	}
	public String userLoad() {
		return fm.userLoad();
	}
	public String UnitLoad() {
		return fm.UnitLoad();
	}
}
