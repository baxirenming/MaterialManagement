package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public class BuyRequestDetailForm {

	//対象資材ID
	private int id;

	//カテゴリリスト
    private List<CategoryDto> categoryList;

    //購入依頼情報
    private SizaiDto sizaiDto;

    //変更フラグ
    private boolean flag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CategoryDto> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<CategoryDto> categoryList) {
		this.categoryList = categoryList;
	}

	public SizaiDto getSizaiDto() {
		return sizaiDto;
	}

	public void setSizaiDto(SizaiDto sizaiDto) {
		this.sizaiDto = sizaiDto;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
