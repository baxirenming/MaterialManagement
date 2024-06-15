<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>入庫画面</title>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/webrtc-adapter/3.3.3/adapter.min.js"></script>
    <script type="text/javascript" src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>
    <script type="text/javascript">
function scan(){
	  document.getElementById("disdiv").style.display="block";
      let scanner = new this.Instascan.Scanner({ video: document.getElementById('preview') });
      scanner.addListener('scan', function (content) {
    	  console.log(content);
    	  document.getElementById('target').value = content;
    	  document.getElementById("disdiv").style.display="none";
    	  document.searchform.submit();
    	  scanner.stop();
      });
      Instascan.Camera.getCameras().then(function (cameras) {
        if (cameras.length > 0) {
          scanner.start(cameras[0]);
        } else {
          console.error('No cameras found.');
        }
      });
};
    </script>
</head>
<body>
	<h2>入庫</h2>
	<hr />
	<div id="disdiv" style="display:none">
    <video id="preview" width="300" height="300"></video>
    </div>
    <button id="scanbutton" onclick="scan()">QRコード読取</button>
	<form name="searchform" action="/sizaikanri/inStore/search"
		method="post">
		<input id="target" type="number" name="form.id" value="<s:property value="form.id"/>"/>
		<input type="submit" value="検索" />
	</form>
	<br />
	<hr />
	<s:if test="form.sizaiDto !=null">
		<form name="instoreform" action="/sizaikanri/inStore/act"
			method="post">
			<table class="inputtable">
				<tr>
					<td>資材ID</td>
					<td><s:property value="form.sizaiDto.id" /> <input
						type="hidden" name="form.sizaiDto.id"
						value="<s:property value="form.sizaiDto.id" />" /></td>
				</tr>
				<tr>
					<td>資材名</td>
					<td><s:property value="form.sizaiDto.name" /></td>
				</tr>
				<tr>
					<td>数量</td>
					<td><s:property value="form.sizaiDto.num" /></td>
				</tr>
				<tr>
					<td>カテゴリ</td>
					<td><s:property value="form.sizaiDto.category_name" /></td>
				</tr>
				<tr>
					<td>状態</td>
					<td><s:property value="form.sizaiDto.status_name" /></td>
				</tr>
				<s:if test="form.sizaiDto.status == 5">
				<tr>
				<s:select name="form.sizaiDto.souko_id" label="倉庫" class="seigyo"
					list="form.sokoList" listKey="id" listValue="name" />
				</tr>
				</s:if>
				<s:else>
				<tr>
					<td>倉庫</td>
					<td>
					<s:property value="form.sizaiDto.souko_name" />
					</td>
				</tr>
				</s:else>
				<tr>
					<td>購入依頼者</td>
					<td><s:property value="form.sizaiDto.request_user_name" /></td>
				</tr>
				<tr>
					<td>購入依頼部門</td>
					<td><s:property value="form.sizaiDto.request_dept_name" /></td>
				</tr>
				<tr>
					<td>購入依頼部門</td>
					<td><s:property value="form.sizaiDto.request_dept_name" /></td>
				</tr>
				<tr>
					<td>依頼日</td>
					<td><s:property value="form.sizaiDto.request_date" /></td>
				</tr>
				<tr>
					<td>発注日</td>
					<td><s:property value="form.sizaiDto.order_date" /></td>
				</tr>
				<tr>
					<td>納品日</td>
					<td><s:property value="form.sizaiDto.delivery_date" /></td>
				</tr>
				<tr>
					<td>入庫日</td>
					<td><s:property value="form.sizaiDto.instore_date" /></td>
				</tr>
				<tr>
					<td>出庫日</td>
					<td><s:property value="form.sizaiDto.outstore_date" /></td>
				</tr>
				<tr>
					<td>備考</td>
					<td><s:property value="form.sizaiDto.note" /></td>
				</tr>
			</table>
			<s:if test="form.sizaiDto.status == 5">
			<input type="submit" value="入庫" />
			</s:if>
		</form>
	</s:if>
</body>
</html>