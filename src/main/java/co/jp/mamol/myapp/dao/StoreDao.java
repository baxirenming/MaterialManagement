package co.jp.mamol.myapp.dao;

import java.util.List;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.SoukoDto;

public interface StoreDao {
	//資材情報一件取得
	public SizaiDto getSizaiById(int id);

	//倉庫情報取得
	public List<SoukoDto> getSoukoList();

	//入庫実行
	public boolean InStoreAct(SizaiDto s);

	//出庫実行
	public boolean OutStoreAct(SizaiDto s);
}
