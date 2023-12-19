package Controller;

import DAO.PlayerDAO;
import Model.Item;
import Model.Player;

public class PlayerController {
	private PlayerDAO dao = new PlayerDAO();
	
	public String GetPlayer() {
		return dao.GetPlayer();
	}
	public void PrintInven(String user) {
		dao.PrintInventory(user);
	}
	public void BuyItem(Item i,String user) {
		dao.addInven(i, user);
	}
	public int GetInvSize(String user) {
		return dao.GetInvSize(user);
	}
	public void DeleteOneItem(String user,int idx) {
		dao.DeleteOneItem(user, idx);
	}
	public void PrintMoney(String user) {
		dao.PrintMoney(user);
	}
	public void UserInvenItem(String user, int idx) {
		dao.UserInvenItem(user, idx);
	}
	public void GetState(String user) {
		dao.PrintState(user);
	}
	public String GetSaveData() {
		return dao.GetUserSaveData();
	}
	public void LoadUser(String data) {
		dao.LoadData(data);
	}
}
