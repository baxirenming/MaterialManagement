package co.jp.mamol.myapp.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.InStoreForm;
import co.jp.mamol.myapp.service.StoreService;

/*
*
* M0008入庫画面
*/
@Results({
		@Result(name = "inStore", location = "/WEB-INF/jsp/inStore.jsp")
})
public class InStoreAction extends BaseAction {
	InStoreForm form = new InStoreForm();

	@Autowired
	StoreService service ;

	//初期表示
	@Action("/inStore/init")
	public String init() {

		return "inStore";
	}

	//資材検索
	@Action("/inStore/search")
	public String search() {

		SizaiDto sizaiDto = service.getSizaiById(form.getId());

		if(sizaiDto == null) {
			setMessage("資材情報を取得できませんでした。", false);
		}else {
			if(!sizaiDto.getStatus().equals("5")) {
				setMessage("資材の状態は「納品済」ではないため、入庫できません。", false);
			}
			form.setSizaiDto(sizaiDto);
			form.setSokoList(service.getAllSouko());
		}

		return "inStore";
	}

	//入庫
	@Action("/inStore/act")
	public String inStoreAct() {

		if(service.InStore(form.getSizaiDto())) {
			setMessage("入庫完了しました。", true);
		}else {
			setMessage("入庫できませんでした。", false);
		}

		form.setSizaiDto(service.getSizaiById(form.getSizaiDto().getId()));

		return "inStore";
	}

	public InStoreForm getForm() {
		return form;
	}

	public void setForm(InStoreForm form) {
		this.form = form;
	}

}
