package DAO;

import java.util.ArrayList;

import Model.Item;

public class ShopDAO {
	private ArrayList<Item> list;
//	[0]"무기",[1]"방어구",[2]"장신구"
	//String type ,String name, int damage, int price
	public ShopDAO() {
		list = new ArrayList<Item>();
		list.add(new Item("무기","검1",10,100));
		list.add(new Item("무기","검2",20,200));
		list.add(new Item("무기","검3",30,300));
		list.add(new Item("무기","검4",40,400));
		list.add(new Item("방어구","방패1",10,100));
		list.add(new Item("방어구","방패2",20,200));
		list.add(new Item("방어구","방패3",30,300));
		list.add(new Item("방어구","방패4",40,400));
		list.add(new Item("장신구","반지1",10,100));
		list.add(new Item("장신구","반지1",20,200));
		list.add(new Item("장신구","반지1",30,300));
		list.add(new Item("장신구","반지1",40,400));
	}
	public void PrintShopItem() {
		for(int i = 0 ; i < list.size();i++) {
			System.out.println(list.get(i).toString());
		}
	}
	public void PrintShopItem(String type) {
		for(int i = 0 ; i < list.size();i++) {
			if(list.get(i).getType().equals(type))
				System.out.println("["+(i+1)+"]"+list.get(i).toString());
		}
	}
	boolean CheckIdx(int idx) {
		if(idx < 0 || idx >= list.size())return true;
		return false;
	}
	public Item UserBuyItem(String type,int idx) {
		if(CheckIdx(idx))return null;
		if(!list.get(idx).getType().equals(type)) {
			System.out.println("잘못된 번호 입니다.");
			 return null;
		}
		return list.get(idx);
	}
}
