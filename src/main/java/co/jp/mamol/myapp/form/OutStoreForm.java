package co.jp.mamol.myapp.form;

import co.jp.mamol.myapp.dto.SizaiDto;

public class OutStoreForm {
	//資材情報
	private SizaiDto sizaiDto;

	//検索用資材ID
	private int id;

	public SizaiDto getSizaiDto() {
		return sizaiDto;
	}

	public void setSizaiDto(SizaiDto sizaiDto) {
		this.sizaiDto = sizaiDto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
