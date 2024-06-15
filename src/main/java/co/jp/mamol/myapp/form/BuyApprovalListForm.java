package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.SizaiDto;

public class BuyApprovalListForm {
    //開始日付
	private String dateFrom;

	//終了日付
	private String dateTo;

	//資材リスト
	private List<SizaiDto> sizaiList;

	//対象資材ID
	private int target_id;



	public int getTarget_id() {
		return target_id;
	}

	public void setTarget_id(int target_id) {
		this.target_id = target_id;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public List<SizaiDto> getSizaiList() {
		return sizaiList;
	}

	public void setSizaiList(List<SizaiDto> sizaiList) {
		this.sizaiList = sizaiList;
	}


}
