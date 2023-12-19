package Model;

import java.util.ArrayList;

public class Unit {
	private String name;
	private int hp;
	private int mp;
	private int damage;
	private int defense;
	private int level;
	private String party;
	
	
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public Unit(String name, int hp, int mp, int damage,int defense) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.damage = damage;
		this.level = 1;
		this.party = "";
		this.defense = defense;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String SaveData() {
		return name+"/"+hp+"/"+mp+"/"+damage+"/"+defense+"/"+level+"/"+(party .equals("")? "null" : party );
	}
	public String toString(String user) {
		return "[name : " + name + "] [hp : " + hp + "] [mp : " + mp + "] [공격력 : " + damage + "] [방어력 : " + defense
				+ "] [level=" + level + "] [파티중 :" + party.equals(user) + "]";
	}
	
}
