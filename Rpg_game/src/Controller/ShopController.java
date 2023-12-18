package Controller;

import DAO.ShopDAO;
import Model.Item;

public class ShopController {
	ShopDAO dao = new ShopDAO();
	
	public void PrintItem() {
		dao.PrintShopItem();
	}
	public void PrintItem(String type) {
		dao.PrintShopItem(type);
	}
	public Item UserBuyItem(String type,int idx) {
		return dao.UserBuyItem(type, idx);
	}
}
