package DAO;

import java.util.ArrayList;

import Model.Item;
import Model.Player;

public class PlayerDAO {
	private ArrayList<Player> player;

	public PlayerDAO() {
		player = new ArrayList<Player>();
		player.add(new Player("player1", 100, 100, 10, 5));
	}

	public String GetPlayer() {
		if (player.size() == 0)
			return "";
		return player.get(0).getName();
	}

	public String GetPlayer(int idx) {
		if (player.size() == 0)
			return "";
		try {
			return player.get(idx).getName();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("존재 하지 않는 플레이어 입니다.");
			return "";
		}
	}

	public void PrintInventory(String user) {
		for (int i = 0; i < player.size(); i++) {
			if (user.equals(player.get(i).getName())) {
				player.get(i).PrintInven();
				break;
			}
		}
	}

	public void addInven(Item i, String user) {
		if (i == null)
			return;
		for (int i2 = 0; i2 < player.size(); i2++)
			if (player.get(i2).getName().equals(user))
				player.get(i2).SetItem(i);
	}

	public void DeleteOneItem(String user, int idx) {
		for (int i2 = 0; i2 < player.size(); i2++)
			if (player.get(i2).getName().equals(user))
				player.get(i2).DeleteOneItem(idx - 1);

	}

	public int GetInvSize(String user) {
		for (int i2 = 0; i2 < player.size(); i2++)
			if (player.get(i2).getName().equals(user))
				return player.get(i2).GetInvSize();
		return -1;
	}

	public void PrintMoney(String user) {
		for (int i2 = 0; i2 < player.size(); i2++)
			if (player.get(i2).getName().equals(user))
				player.get(i2).PrintMoney();
	}

	public void UserInvenItem(String user, int idx) {
		for (int i2 = 0; i2 < player.size(); i2++)
			if (player.get(i2).getName().equals(user))
				player.get(i2).SetUserItem(idx - 1);
	}

	public void PrintState(String user) {
		for (int i2 = 0; i2 < player.size(); i2++)
			if (player.get(i2).getName().equals(user))
				System.out.println(player.get(i2).toString(user));
	}

	public String GetUserSaveData() {
		String data = "";
		for (int i = 0; i < player.size(); i++) {
			data += player.get(i).getName() + "/" + player.get(i).getHp() + "/" + player.get(i).getMp() + "/"
					+ player.get(i).getDamage() + "/" + player.get(i).getDefense() + "/" + player.get(i).getLevel()
					+ "/";
			data += player.get(i).getMoney() + "+";
			if(GetInvSaveData().length() != 0)
				data += GetInvSaveData();
			data += "\n";
		}
		if (data.length() != 0) {
			data = data.substring(0, data.length() - 1);
		}
		return data;
	}

	private String GetInvSaveData() {
		String data = "";
		for (int i = 0; i < player.size(); i++) {
			data += player.get(i).InvenData();
		}
		return data;
	}

	public void LoadData(String data) {
		if (data == null)
			return;
		if (player.size() != 0) {
			player.clear();
		}
		if (data.indexOf("$") != -1) {
			String data2[] = data.split("$");
			for (int i = 0; i < data2.length; i++) {
				if (data2[i].indexOf("+") != -1) {
					String t[] = data2[i].split("+");
					String p[] = t[0].split("/");
					player.add(new Player(p[0], Integer.parseInt(p[1]), Integer.parseInt(p[2]), Integer.parseInt(p[3]),
							Integer.parseInt(p[4])));
					player.get(i).setLevel(Integer.parseInt(p[5]));
					player.get(i).setMoney(Integer.parseInt(p[6]));
					player.get(i).LoadInvData(t[1]);
					continue;
				}
				String p[] = data2[i].split("/");
				player.add(new Player(p[0], Integer.parseInt(p[1]), Integer.parseInt(p[2]), Integer.parseInt(p[3]),
						Integer.parseInt(p[4])));
				player.get(i).setLevel(Integer.parseInt(p[5]));
				player.get(i).setMoney(Integer.parseInt(p[6]));
			}
			return;
		}
		
		if (data.indexOf("+") != -1) {
			System.out.println(data);
			System.out.println(data.indexOf("+"));
			String t[] = data.split("\\+");
			String p[] = t[0].split("/");
			player.add(new Player(p[0], Integer.parseInt(p[1]), Integer.parseInt(p[2]), Integer.parseInt(p[3]),
					Integer.parseInt(p[4])));
			player.get(0).setLevel(Integer.parseInt(p[5]));
			player.get(0).setMoney(Integer.parseInt(p[6]));
			player.get(0).LoadInvData(t[1]);
			return;
		}
		String p[] = data.split("/");
		player.add(new Player(p[0], Integer.parseInt(p[1]), Integer.parseInt(p[2]), Integer.parseInt(p[3]),
				Integer.parseInt(p[4])));
		player.get(0).setLevel(Integer.parseInt(p[5]));
		player.get(0).setMoney(Integer.parseInt(p[6]));
	}
}
