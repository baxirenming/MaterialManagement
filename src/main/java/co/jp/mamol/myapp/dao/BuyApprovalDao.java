package co.jp.mamol.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.mamol.myapp.dto.SizaiDto;

public interface BuyApprovalDao {

	//部門別購入依頼一覧
	 public List<SizaiDto> getDeptRequsetList(@Param("startDate")  String startDate,@Param("endDate")  String endDate,@Param("deptId")  String deptId);

     //購入依頼一件取得
     public SizaiDto getRequestById(@Param("id") int id);

     //承認実行
     public boolean approval(@Param("id") int id);

     //却下実行
     public boolean regect(@Param("id") int id);
}
