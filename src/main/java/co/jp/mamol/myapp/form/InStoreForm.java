package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.SoukoDto;

public class InStoreForm {

	//資材情報
	private SizaiDto sizaiDto;

	//倉庫リスト
	private List<SoukoDto> sokoList;

	//検索用資材ID
	private int id;

	public SizaiDto getSizaiDto() {
		return sizaiDto;
	}

	public void setSizaiDto(SizaiDto sizaiDto) {
		this.sizaiDto = sizaiDto;
	}

	public List<SoukoDto> getSokoList() {
		return sokoList;
	}

	public void setSokoList(List<SoukoDto> sokoList) {
		this.sokoList = sokoList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}





}
