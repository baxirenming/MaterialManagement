<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>

<html>
<head>
<title>購入依頼詳細</title>
<script type="text/javascript">
$(function() {
 if('<s:property value="form.flag" />' == 'false'){
	$(".seigyo").prop('disabled',true);
 }
});
</script>
</head>
<body>
	<h2>購入依頼詳細</h2>
	<font color="blue">購入理由、補足事項を備考欄に記載してください。</font>
	<form name="modifyform" action="/sizaikanri/requestDetail/modify" method="post">
		<table class="inputtable">
			<tr>
				<td>資材ID</td>
				<td>
					<s:property value="form.sizaiDto.id"/>
					<input type="hidden" name="form.sizaiDto.id" value="<s:property value="form.sizaiDto.id" />"/>
				</td>
			</tr>
			<tr>
				<td>資材名</td>
				<td><input type="text" name="form.sizaiDto.name" class="seigyo"  size="60"
					value="<s:property value="form.sizaiDto.name"/>" /></td>
			</tr>
			<tr>
				<td>数量</td>
				<td><input type="number" name="form.sizaiDto.num" class="seigyo"
					value="<s:property value="form.sizaiDto.num"/>" /></td>
			</tr>
			<tr><s:select name="form.sizaiDto.category_id" label="カテゴリ" class="seigyo"
						list="form.categoryList" listKey="id" listValue="name" />

			</tr>
			<tr>
                <td>購入依頼者</td>
				<td><s:property value="form.sizaiDto.request_user_name"/></td>
			</tr>
			<tr>
                <td>購入依頼部門</td>
				<td><s:property value="form.sizaiDto.request_dept_name"/></td>
			</tr>
			<tr>
                <td>状態</td>
				<td><s:property value="form.sizaiDto.status_name"/></td>
			</tr>
			<tr>
                <td>依頼日</td>
				<td><s:property value="form.sizaiDto.request_date"/></td>
			</tr>
			<tr>
				<td>備考</td>
				<td><textarea name="form.sizaiDto.note" class="seigyo" cols="60" rows="5"><s:property value="form.sizaiDto.note"/></textarea></td>
			</tr>

		</table>
		<input type="submit" class="seigyo" value="更新"/><br/>
		<a href="/sizaikanri/requestList/init">一覧へ戻る</a>
	</form>
</body>
</html>