package Controller;

import DAO.UnitDAO;

class UnitController {
	UnitDAO dao = new UnitDAO();
	
	public void PrintParty(String user) {
		dao.PrintParty(user);
	}
	public void NewParyMember(String user) {
		dao.NewPartyMember(user);
	}
	public void DeletePartyMember(int idx) {
		dao.DeleteParyMember(idx-1);
	}
	public void ChangePartyMember(String user,int idx1, int idx2) {
		dao.ChangePartyMember(user,idx1-1,idx2-1);
	}
	public void PartySort() {
		dao.PartySort();
	}
	
	
}
