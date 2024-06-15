package co.jp.mamol.myapp.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.DeleverForm;
import co.jp.mamol.myapp.service.OrderDeleverService;

/*
*
* M0007納品画面
*/
@Results({
	@Result(name = "delever", location = "/WEB-INF/jsp/delever.jsp"),
	@Result(name = "qr", location = "/WEB-INF/jsp/qr.jsp")
})
public class DeleverAction extends BaseAction{

	DeleverForm form = new DeleverForm();

	@Autowired
	OrderDeleverService service;

	//初期表示
	@Action("/delever/init")
	public String init() {

		//部署リスト取得
		List<DepartmentDto> deptList = service.deptList();
		form.setDeptList(deptList);


		//検索用部署ID設定
		form.setDeptid(deptList.get(0).getId());


		//資材リスト取得
		List<SizaiDto> sizaiList = service.orderedList(form.getDeptid());
		form.setSizaiList(sizaiList);

		getSession().put("deptId", form.getDeptid());

		return "delever";
	}

	//検索実行
	@Action("/delever/search")
	public String search() {
		//部署リスト取得
		List<DepartmentDto> deptList = service.deptList();
		form.setDeptList(deptList);

		//資材リスト取得
		List<SizaiDto> sizaiList = service.orderedList(form.getDeptid());
		form.setSizaiList(sizaiList);

		getSession().put("deptId", form.getDeptid());

		return "delever";
	}

	//納品実行
	@Action("/delever/act")
	public String orderAct() {

		String  deptId = (String)getSession().get("deptId");
		form.setDeptid(deptId);

		//発注実行
		if(service.deleverAct(form.getSizaiId())) {
			setMessage("納品しました。", true);
		}else {
			setMessage("納品失敗しました。", false);
		}

		//部署リスト取得
		List<DepartmentDto> deptList = service.deptList();
		form.setDeptList(deptList);

		//資材リスト取得
		List<SizaiDto> sizaiList = service.orderedList(form.getDeptid());
		form.setSizaiList(sizaiList);

		return "delever";
	}

	//QRコード発行
	@Action("/delever/qr")
	public String qrCode() {

		return "qr";
	}


	public DeleverForm getForm() {
		return form;
	}

	public void setForm(DeleverForm form) {
		this.form = form;
	}


}
