package Controller;

public class MainController {
	private PlayerController pcon = new PlayerController();
	private UnitController unitcon = new UnitController();
	private UtilController ucon = new UtilController();
	private ShopController shopcon = new ShopController();
	private String User;

	private void init() {
		User = pcon.GetPlayer();
		
	}

	public void run() {
		init();
		FristMenu();
	}

	private void ParyManagerMenu() {
		while (true) {
			System.out.println("=============== [파티관리메뉴] ================");
			int sel = ucon.GetInt("[1.파티 목록] [2.파티원 추가] [3.파티원 삭제] [4.파티원 교체] [5.정렬] [0.종료]");
			if (sel == 0) {
				break;
			}
			if(sel == 1) {
				unitcon.PrintParty(User);
			}
			if(sel == 2) {
				unitcon.NewParyMember(User);
			}
			if(sel == 3) {
				unitcon.PrintParty(User);
				sel = ucon.GetInt("삭제하실 번호를 입력하세요");
				unitcon.DeletePartyMember(sel);
			}
			if(sel == 4) {
				unitcon.PrintParty(User);
				sel = ucon.GetInt("파티원 해제 시킬 번호를 입력 하세요");
				if(sel == -1) continue;
				unitcon.PrintParty(User);
				int sel2 = ucon.GetInt("파티에 참가 시킬 번호를 입력 하세요");
				if(sel2 == -1) continue;
				
				else if(sel == sel2) {
					System.out.println("같은 번호를 입력 하셨습니다.");
					continue;
				}
				unitcon.ChangePartyMember(User,sel,sel2);
			}
			if(sel == 5) {
				unitcon.PartySort();
			}
			
		}
	}
	private void InvenMenu() {
		while(true) {
			System.out.println("=============== [인벤토리] ================");
			pcon.PrintInven(User);
			if(pcon.GetInvSize(User) == 0) break;
			int sel = ucon.GetInt("[1.아이템 착용] [2.아이템 판매] [0.뒤로가기]");
			if(sel == 0) {
				break;
			}
			if(sel == 1) {
				pcon.PrintInven(User);
				if(pcon.GetInvSize(User) == 0) {
					continue;
				}
				sel = ucon.GetInt("착용 하실 아이템 번호를 입력하세요");
				pcon.UserInvenItem(User, sel);
			}else if(sel == 2) {
				pcon.PrintInven(User);
				if(pcon.GetInvSize(User) == 0) {
					continue;
				}
				sel = ucon.GetInt("판매하실 아이템 번호를 입력하세요( 판매 금액 : 가격의 50%)");
				pcon.DeleteOneItem(User,sel);
			}
		}
	}
	private void FristMenu() {
		while (true) {
			System.out.println("=============== [메인메뉴] ================");
			int sel = ucon.GetInt("[1.파티 관리] [2.상점] [3.인벤토리] [4.저장] [5.로드] [6.내 정보][0.종료]");
			if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			if (sel == 1) {
				ParyManagerMenu();
			}
			else if (sel == 2) {
				//[2.상점]
				ShopMenu();
			}
			else if (sel == 3) {
				InvenMenu();
			}
			else if (sel == 4) {
				ucon.Save(pcon.GetSaveData(),unitcon.UnitSave());
			}
			else if (sel == 5) {
				pcon.LoadUser(ucon.userLoad());
				unitcon.UnitLoad(ucon.UnitLoad());
			}else if(sel == 6) {
				pcon.GetState(User);
			}

		}
	}
	
	private void ShopMenu() {
		while(true) {
			System.out.println("=============== [상점메뉴] ================");
			pcon.PrintMoney(User);
			int sel = ucon.GetInt("[1.아이템 구매] [2.아이템 판매] [3.뒤로가기]");
			if(sel == 3) {
				break;
			}
			if(sel == 1) {
				SelectItem();
			}else if(sel == 2) {
				pcon.PrintInven(User);
				if(pcon.GetInvSize(User) == 0) {
					continue;
				}
				sel = ucon.GetInt("판매하실 아이템 번호를 입력하세요( 판매 금액 : 가격의 50%)");
				pcon.DeleteOneItem(User,sel);
			}
		}
	}
	private void SelectItem() {
		while(true) {
			String type = "";
			System.out.println("=============== [구입메뉴] ================");
			int sel = ucon.GetInt("[1.무기 구매] [2.방어구 구입] [3.장신구 구입] [4.뒤로가기]" );
			if(sel == 4) {
				break;
			}
			if(sel == 1) {
				type = "무기";
				shopcon.PrintItem(type);
				sel = ucon.GetInt("구매하실 번호를 입력하세요");
			}else if(sel == 2) {
				type = "방어구";
				shopcon.PrintItem(type);
				sel = ucon.GetInt("구매하실 번호를 입력하세요");
			}else if(sel == 3) {
				type = "장신구"; 
				shopcon.PrintItem(type);
				sel = ucon.GetInt("구매하실 번호를 입력하세요");
			}
			pcon.BuyItem(shopcon.UserBuyItem(type, sel), User);
		}
	}
}
