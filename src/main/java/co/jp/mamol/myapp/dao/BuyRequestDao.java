package co.jp.mamol.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public interface BuyRequestDao {
	//購入依頼登録
     public void requestRegist(SizaiDto sizaiDto) ;
    //カテゴリ取得
     public List<CategoryDto> getCategory();
     //ユーザ別購入依頼一覧リスト取得
     public List<SizaiDto> getUserRequsetList(@Param("startDate")  String startDate,@Param("endDate")  String endDate,@Param("userId")  String userId);
     //購入依頼一件取得
     public SizaiDto getRequestById(@Param("id") int id);
     //購入依頼変更
     public boolean modifyRequest(SizaiDto sizaiDto);
     //購入依頼削除
     public boolean deleteById(@Param("id")  int id) ;

}
