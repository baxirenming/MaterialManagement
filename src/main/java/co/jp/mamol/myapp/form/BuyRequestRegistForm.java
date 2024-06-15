package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public class BuyRequestRegistForm {

	//カテゴリリスト
    List<CategoryDto> categoryList;

    //購入依頼情報
    SizaiDto sizaiDto;

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


}
