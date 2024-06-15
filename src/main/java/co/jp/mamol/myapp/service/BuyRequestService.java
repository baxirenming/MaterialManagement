package co.jp.mamol.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.mamol.myapp.dao.BuyRequestDao;
import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

@Service
public class BuyRequestService {

	@Autowired
	BuyRequestDao buyRequestDao;

	//購入依頼登録
	public void requestRegist(SizaiDto sizaiDto) {

		buyRequestDao.requestRegist(sizaiDto);

	}

	//カテゴリ取得
	public List<CategoryDto> getCategory() {

		return buyRequestDao.getCategory();
	}

	//ユーザ別購入依頼一覧取得
	public List<SizaiDto> getUserRequsetList(String startDate,String endDate,String userId){

		startDate = startDate +" "+ "00:00:00";
		endDate = endDate +" "+"23:59:59";

		List<SizaiDto> sizaiList = buyRequestDao.getUserRequsetList(startDate, endDate,userId);

		return sizaiList;
	}

	//購入依頼一件取得
	public SizaiDto getRequest(int id) {
		SizaiDto s = buyRequestDao.getRequestById(id);
		return s;
	}
	//購入依頼変更
	public boolean modifyRequest(SizaiDto s) {
		boolean b = buyRequestDao.modifyRequest(s);
		return b;
	}

	//購入依頼撤回
	public boolean deleteRequest(int id) {
		boolean b = buyRequestDao.deleteById(id);
		return b;
	}
}
