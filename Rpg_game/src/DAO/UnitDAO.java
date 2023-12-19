package DAO;

import java.util.ArrayList;
import java.util.Random;

import Model.Unit;

public class UnitDAO {
	private ArrayList<Unit> list;
	private Random rd = new Random();
	private String name = "abcdefghijk";
	private int count = 0;
	public UnitDAO() {
		list = new ArrayList<Unit>();
	}

	public void PrintParty(String user) {
		
		System.out.println("============= [파티원] =================");
		for (int i = 0; i < list.size(); i++) {
			System.out.print("[" + (i + 1) + "]");
			System.out.println(list.get(i).toString(user));
			System.out.println();
		}

	}

	private int RandomInt(int min, int max) {
		return rd.nextInt(max - min) + min;
	}

	public void NewPartyMember(String user) {
		String unitname = "";
		for (int i = 0; i < 3; i++) {
			unitname += name.charAt(rd.nextInt(name.length()));
		}

		list.add(new Unit(unitname, RandomInt(50, 100), RandomInt(50, 100), RandomInt(2, 10), RandomInt(1, 5)));
		count++;
		if(count <= 4)
			list.get(list.size()-1).setParty(user);
		
		System.out.println("파티원 추가 완료");
		System.out.println("===================================");
	}

	public void DeleteParyMember(int idx) {
		if(CheckIdx(idx)) {
			System.out.println("없는 번호입니다.");
			return;
		}
		if (list.size() == 1) {
			list.clear();
			return;
		}
		list.remove(idx);

	}

	private boolean CheckIdx(int idx) {
		if (idx < 0 || idx >= list.size())
			return true;
		return false;
	}
	public boolean CheckParty(int idx) {
		if(list.get(idx).getParty().isBlank()) {
			return true;
		}
		return false;
	}
	
	public void ChangePartyMember(String user,int idx1, int idx2) {
		if(CheckIdx(idx1)||CheckIdx(idx2)) {
			return;
		}
		if(CheckParty(idx1)) {
			System.out.println("파티에 속하지 않은 상태입니다.");
			return;
		}else if(CheckParty(idx2) == false) {
			System.out.println("이미 파티에 속해있는 상태입니다.");
			return;
		}
		list.get(idx1).setParty("");
		list.get(idx2).setParty(user);
	}
	public void PartySort() {
		for(int i = 0 ; i < list.size();i++) {
			if(CheckParty(i)) {
				ChanegeParty(i);
			}
		}
	}
	private void ChanegeParty(int idx) {
		for(int i = list.size() - 1 ; i >idx ; i--) {
			if(CheckParty(i) == false) {
				Unit t = list.get(idx);
				list.set(idx, list.get(i));
				list.set(i, t);
			}
		}
	}
	
}
