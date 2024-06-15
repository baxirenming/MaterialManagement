package co.jp.mamol.myapp.dao;

import java.util.List;

import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public interface OrderDeliverDao {
	//部署リスト取得
	public List<DepartmentDto> deptList();

	//承認済資材取得(部署別)
	public List<SizaiDto> approvaledList(String deptid);

	//発注済資材取得(部署別)
	public List<SizaiDto> orderedList(String deptid);

	//発注実行
	public boolean orderAct(int sizaiId);

	//納品実行
	public boolean deleverAct(int sizaiId);
}
