package Model;

public class Item {
	private String type;
	private String name;
	private int damage;
	private int price;
	public Item() {
		
	}
	public Item(String type ,String name, int damage, int price) {
		this.type = type;
		this.name = name;
		this.damage = damage;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "[아이템 타입 : " + type + "] [이름 : " + name + "] [공격력 : " + damage + "] [가격 : " + price + "]";
	}
	public String SaveData() {
		return  type +"/" + name + "/" + damage + "/" + price;
	}
	
}
