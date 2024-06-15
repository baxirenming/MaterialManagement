package co.jp.mamol.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.mamol.myapp.dao.StoreDao;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.SoukoDto;

@Service
public class StoreService {
	@Autowired
	StoreDao storeDao;

	//資材情報一件取得
	public SizaiDto getSizaiById(int id) {
		SizaiDto sizai =storeDao.getSizaiById(id);
		return sizai;
	}

	//倉庫情報取得
	public List<SoukoDto> getAllSouko(){
		List<SoukoDto> soukoList = storeDao.getSoukoList();

		return soukoList;
	}

	//入庫実行
	public boolean  InStore(SizaiDto s) {
		return storeDao.InStoreAct(s);
	}

	//出庫実行
	public boolean OutStore(SizaiDto s) {
		return storeDao.OutStoreAct(s);
	}
}
