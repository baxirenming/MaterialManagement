package co.jp.mamol.myapp.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.OutStoreForm;
import co.jp.mamol.myapp.service.StoreService;

/*
*
* M0009出庫画面
*/
@Results({
	@Result(name = "outStore", location = "/WEB-INF/jsp/outStore.jsp")
})
public class OutStoreAction extends BaseAction{
	OutStoreForm form = new OutStoreForm();

	@Autowired
	StoreService service ;


	//初期表示
	@Action("/outStore/init")
	public String init() {

		return "outStore";
	}

	//資材検索
	@Action("/outStore/search")
	public String search() {

		SizaiDto sizaiDto = service.getSizaiById(form.getId());

		if(sizaiDto == null) {
			setMessage("資材情報を取得できませんでした。", false);
		}else {
			if(!sizaiDto.getStatus().equals("6")) {
				setMessage("資材の状態は「入庫済」ではないため、出庫できません。", false);
			}
			form.setSizaiDto(sizaiDto);
		}

		return "outStore";
	}

	//出庫
	@Action("/outStore/act")
	public String inStoreAct() {

		if(service.OutStore(form.getSizaiDto())) {
			setMessage("出庫完了しました。", true);
		}else {
			setMessage("出庫できませんでした。", false);
		}

		form.setSizaiDto(service.getSizaiById(form.getSizaiDto().getId()));

		return "outStore";
	}

	public OutStoreForm getForm() {
		return form;
	}

	public void setForm(OutStoreForm form) {
		this.form = form;
	}


}
