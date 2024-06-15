package co.jp.mamol.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.mamol.myapp.dao.OrderDeliverDao;
import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;

@Service
public class OrderDeleverService {

	@Autowired
	OrderDeliverDao dao;

	//部署リスト取得
	public List<DepartmentDto> deptList() {
		return dao.deptList();
	}

	//部署別資材取得
	public List<SizaiDto> approvaledList(String deptid) {
		return dao.approvaledList(deptid);
	}

	//承認済資材取得(部署別)
	public List<SizaiDto> orderedList(String deptid) {
		return dao.orderedList(deptid);
	}

	//発注実行
	public boolean orderAct(int sizaiId) {
		return dao.orderAct(sizaiId);
	}

	//納品実行
	public boolean deleverAct(int sizaiId) {
		return dao.deleverAct(sizaiId);
	}

}
