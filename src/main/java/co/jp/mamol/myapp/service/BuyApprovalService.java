package co.jp.mamol.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.mamol.myapp.dao.BuyApprovalDao;
import co.jp.mamol.myapp.dto.SizaiDto;

@Service
public class BuyApprovalService {
	@Autowired
	BuyApprovalDao buyApprovalDao;

	//部門別購入依頼一覧取得
    public List<SizaiDto>  getDeptRequsetList(String startDate,String endDate,String deptId){

		startDate = startDate +" "+ "00:00:00";
		endDate = endDate +" "+"23:59:59";

		List<SizaiDto> sizaiList = buyApprovalDao.getDeptRequsetList(startDate, endDate, deptId);

    	return sizaiList;

    }
	//購入依頼一件取得
	public SizaiDto getRequest(int id) {
		SizaiDto s = buyApprovalDao.getRequestById(id);
		return s;
	}
	//承認実行
	public boolean approval(int id) {
		boolean b = buyApprovalDao.approval(id);
		return b;
	}

	//却下実行
	public boolean regect(int id ) {
		boolean b = buyApprovalDao.regect(id);
		return b;
	}

}
