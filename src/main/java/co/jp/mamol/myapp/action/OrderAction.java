package co.jp.mamol.myapp.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.OrderForm;
import co.jp.mamol.myapp.service.OrderDeleverService;
/*
*
* M0006発注画面
*/
@Results({
	@Result(name = "order", location = "/WEB-INF/jsp/order.jsp")
})
public class OrderAction  extends BaseAction{

	OrderForm form = new OrderForm();

	@Autowired
	OrderDeleverService service;


	//初期表示
	@Action("/order/init")
	public String init() {

		//部署リスト取得
		List<DepartmentDto> deptList = service.deptList();
		form.setDeptList(deptList);


		//検索用部署ID設定
		form.setDeptid(deptList.get(0).getId());


		//資材リスト取得
		List<SizaiDto> sizaiList = service.approvaledList(form.getDeptid());
		form.setSizaiList(sizaiList);

		getSession().put("deptId", form.getDeptid());

		return "order";
	}

	//検索実行
	@Action("/order/search")
	public String search() {
		//部署リスト取得
		List<DepartmentDto> deptList = service.deptList();
		form.setDeptList(deptList);

		//資材リスト取得
		List<SizaiDto> sizaiList = service.approvaledList(form.getDeptid());
		form.setSizaiList(sizaiList);

		getSession().put("deptId", form.getDeptid());

		return "order";
	}

	//発注実行
	@Action("/order/act")
	public String orderAct() {

		String  deptId = (String)getSession().get("deptId");
		form.setDeptid(deptId);

		//発注実行
		if(service.orderAct(form.getSizaiId())) {
			setMessage("発注しました。", true);
		}else {
			setMessage("発注失敗しました。", false);
		}

		//部署リスト取得
		List<DepartmentDto> deptList = service.deptList();
		form.setDeptList(deptList);

		//資材リスト取得
		List<SizaiDto> sizaiList = service.approvaledList(form.getDeptid());
		form.setSizaiList(sizaiList);

		return "order";
	}

	public OrderForm getForm() {
		return form;
	}

	public void setForm(OrderForm form) {
		this.form = form;
	}




}
