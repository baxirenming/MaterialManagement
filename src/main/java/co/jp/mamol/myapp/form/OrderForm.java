package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public class OrderForm {

	//部署リスト
	private List<DepartmentDto> deptList;

	//検索用部署ID
	private String deptid;

	//資材リスト
	private List<SizaiDto> sizaiList;

	//発注対象資材ID
	private int sizaiId;



	public int getSizaiId() {
		return sizaiId;
	}

	public void setSizaiId(int sizaiId) {
		this.sizaiId = sizaiId;
	}

	public List<DepartmentDto> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<DepartmentDto> deptList) {
		this.deptList = deptList;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public List<SizaiDto> getSizaiList() {
		return sizaiList;
	}

	public void setSizaiList(List<SizaiDto> sizaiList) {
		this.sizaiList = sizaiList;
	}


}
