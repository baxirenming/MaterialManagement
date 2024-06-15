package co.jp.mamol.myapp.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.BuyApprovalDetailForm;
import co.jp.mamol.myapp.service.BuyApprovalService;

/*
*
* M0005購入承認詳細
*/
@Results({
		@Result(name = "approvalDetail", location = "/WEB-INF/jsp/approvalDetail.jsp")
})
public class BuyApprovalDetailAction extends BaseAction {

	BuyApprovalDetailForm form = new BuyApprovalDetailForm();

	@Autowired
	BuyApprovalService service;

	//初期表示
	@Action("/approvalDetail/init")
	public String init() {
		SizaiDto s =  service.getRequest(form.getId());

		form.setSizaiDto(s);

		return "approvalDetail";
	}

	public BuyApprovalDetailForm getForm() {
		return form;
	}

	public void setForm(BuyApprovalDetailForm form) {
		this.form = form;
	}




}
