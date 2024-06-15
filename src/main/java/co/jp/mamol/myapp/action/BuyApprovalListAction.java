package co.jp.mamol.myapp.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.BuyApprovalListForm;
import co.jp.mamol.myapp.service.BuyApprovalService;

/*
*
* M0004購入承認一覧画面
*/
@Results({
		@Result(name = "approvalList", location = "/WEB-INF/jsp/approvalList.jsp"),
		@Result(name = "init", location = "/approvalList/init",type="redirect")
})
public class BuyApprovalListAction extends BaseAction {
	private BuyApprovalListForm form = new BuyApprovalListForm();

	@Autowired
	BuyApprovalService service;

	//初期表示
	@Action("/approvalList/init")
	public String init() {

		//現在日付取得
		LocalDate  nowDate = LocalDate.now();

		//現在日付String変換
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String nowDateStr = nowDate.format(formatter);

		//先月日付取得
		LocalDate  preMonthDate = nowDate.minusMonths(1);

		//先月日付String変換
		String preMonthStr = preMonthDate.format(formatter);

		form.setDateFrom(preMonthStr);
		form.setDateTo(nowDateStr);

		String deptid = getLoginUser().getDepid();

		//部門別購入依頼一覧取得
		List<SizaiDto> sizaiList = service.getDeptRequsetList(preMonthStr, nowDateStr, deptid);

		if(sizaiList==null || sizaiList.size() == 0) {
			setMessage("指定期間の購入依頼が登録されていません。", false);
		}else {
			form.setSizaiList(sizaiList);
		}
		return "approvalList";
	}

	//購入依頼検索
	@Action("/approvalList/search")
	public String search() {
		String deptid = getLoginUser().getDepid();

		//購入依頼一覧取得
		List<SizaiDto> sizaiList = service.getDeptRequsetList(form.getDateFrom(), form.getDateTo(),deptid);

		if(sizaiList==null || sizaiList.size() == 0) {
			setMessage("指定期間の購入依頼が登録されていません。", false);
		}else {
			form.setSizaiList(sizaiList);
		}

		return "approvalList";
	}
	//承認
	@Action("/approvalList/approval")
	public String approval() {

       service.approval(form.getTarget_id());

		return "init";
	}
	//却下
	@Action("/approvalList/regect")
	public String regect() {
	       service.regect(form.getTarget_id());

		return "init";

	}


	public BuyApprovalListForm getForm() {
		return form;
	}

	public void setForm(BuyApprovalListForm form) {
		this.form = form;
	}

}
