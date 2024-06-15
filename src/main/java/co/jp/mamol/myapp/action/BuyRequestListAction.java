package co.jp.mamol.myapp.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.BuyRequestListForm;
import co.jp.mamol.myapp.service.BuyRequestService;

/*
*
* M0002購入依頼一覧画面
*/
@Results({
	@Result(name = "requestList", location = "/WEB-INF/jsp/requestList.jsp"),
	@Result(name = "init", location = "/requestList/init",type="redirect")
})
public class BuyRequestListAction extends BaseAction {

	private BuyRequestListForm form = new BuyRequestListForm();

	@Autowired
	private BuyRequestService service;

	//初期表示
	@Action("/requestList/init")
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

		String userid = getLoginUser().getId();

		//ユーザ別購入依頼一覧取得
		List<SizaiDto> sizaiList = service.getUserRequsetList(preMonthStr, nowDateStr,userid);

		if(sizaiList==null || sizaiList.size() == 0) {
			setMessage("指定期間の購入依頼が登録されていません。", false);
		}else {
			form.setSizaiList(sizaiList);
		}

		return "requestList";
	}

	//購入依頼検索
	@Action("/requestList/search")
	public String search() {
		String userid = getLoginUser().getId();

		//購入依頼一覧取得
		List<SizaiDto> sizaiList = service.getUserRequsetList(form.getDateFrom(), form.getDateTo(),userid);

		if(sizaiList==null || sizaiList.size() == 0) {
			setMessage("指定期間の購入依頼が登録されていません。", false);
		}else {
			form.setSizaiList(sizaiList);
		}

		return "requestList";
	}

	//撤回
	@Action("/requestList/delete")
	public String delete() {

		//購入依頼削除
		service.deleteRequest(form.getTarget_id());

		return "init";
	}




	public BuyRequestListForm getForm() {
		return form;
	}

	public void setForm(BuyRequestListForm form) {
		this.form = form;
	}

}
