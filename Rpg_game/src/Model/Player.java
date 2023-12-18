package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Player extends Unit{
	private ArrayList<Item> Inv;
	private int money;
	Item[] Wearing = new Item[3];
//	[0]"무기",[1]"방어구",[2]"장신구"
	
	public Player(String name, int hp, int mp, int damage,int defense) {
		super(name, hp, mp, damage,defense);
		for(int i = 0 ; i < Wearing.length; i++)
			Wearing[i] = new Item();
		Inv = new ArrayList<Item>();
		money = 10000;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	//아이템 추가
	public void SetItem(Item i) {
		if(money < i.getPrice()) {
			System.out.println("가지고 있는 돈 이 부족합니다!");
			return;
		}
		Inv.add(i);
		money -= i.getPrice();
		System.out.println("인벤토리 추가 완료");
	}
	public String InvenData() {
		String data ="";
		for(int i = 0 ; i < Inv.size(); i++) {
			data += Inv.get(i).SaveData()+"\n";
		}
		if(data.length() != 0)
			data = data.substring(0,data.length() -1);
		return data;
	}
	//인벤토리 아이템 한개 삭제
	private void DeleteItem(String name) {
		for(int i = 0 ; i < Inv.size(); i++) {
			if(Inv.get(i).getName().equals(name)) {
				if(Inv.size() == 1) {
					Inv.clear();
					break;
				}
				Inv.remove(i);
				break;
			}
		}
	}
	//아이템 착용
	public void PlayerWearing(Item i) {
		int idx = -1;
		switch(i.getType()) {
		
		case "무기":
			idx = 0;
			break;
		case "방어구":
			idx = 1;
			break;
		case "장신구":
			idx = 2;
			break;
		}
		Wearing[idx] = i;
		DeleteItem(Wearing[idx].getName());
		System.out.println(Wearing[idx].getName()+"아이템 착용 완료");
	}
	public int GetInvSize() {
		return Inv.size();
	}
	public void PrintInven() {
		if(Inv.size() == 0) {
			System.out.println("인벤토리가 비어 있습니다.");
			return;
		}
		for(int i = 0 ; i < Inv.size(); i++) {
			System.out.print("["+(i+1)+"]");
			System.out.println(Inv.get(i).toString()); 
			System.out.println();
		}
	}
	public void DeleteOneItem(int idx) {
		if(idx < 0 || idx >= Inv.size()) {
			System.out.println("잘못된 번호 입니다.");
			return;
		}
		money += Inv.get(idx).getPrice() / 2;
		if(Inv.size() == 1) {
			Inv.clear();
			return;
		}
		Inv.remove(idx);
		
	}
	public void setInv(Item i) {
		Inv.add(i);
	}
	public void PrintMoney() {
		System.out.println("잔 액 : "+money);
	}
	public void SetUserItem(int idx) {
		if(idx < 0 || idx >= Inv.size()) {
			System.out.println("잘못된 번호 입니다.");
			return;
		}
		PlayerWearing(Inv.get(idx));
	}
	public String toString(String user) {
//		Item[] Wearing = new Item[3];
//		[0]"무기",[1]"방어구",[2]"장신구"
		String data ="\n========착용 아이템=======\n";
		for(int i = 0 ; i < Wearing.length; i++) {
			data += Wearing[i].toString()+"\n";
		}
		return "[name : " + getName() + "] [hp : " + getHp() + "] [mp : " + getMp() + "] [공격력 : " + getDamage() + "] [방어력 : " + getDefense()
				+ "] [level=" + getLevel() + "]"+data;
	}
	
}
