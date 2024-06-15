package co.jp.mamol.myapp.form;

import co.jp.mamol.myapp.dto.SizaiDto;

public class BuyApprovalDetailForm {

	//対象資材ID
	private int id;

    //購入依頼情報
    private SizaiDto sizaiDto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SizaiDto getSizaiDto() {
		return sizaiDto;
	}

	public void setSizaiDto(SizaiDto sizaiDto) {
		this.sizaiDto = sizaiDto;
	}


}
