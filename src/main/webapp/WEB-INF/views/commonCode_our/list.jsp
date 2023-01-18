<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />

<div class="container">
<div class="form-group form-row justify-content-between">
	<div class="col">
		<div class="btn-group">
			<!-- <button class="btn btn-primary viewPopup" type="button" -->
			<button class="btn btn-primary"
				 name="PARENT_COMMONCODE_ID" >
				
			</button>
			<button class="btn btn-danger"
				 id='btn_delete' disabled>
				
			</button>
			<button class="btn btn-primary viewPopup" type="button"  id='btn_modify'
				 name='' value='' disabled>
				
			</button>
			<c:if test="${not empty paramMap.PARENT_COMMONCODE_ID}">
				<button class="btn btn-outline-info"
					 name="PARENT_COMMONCODE_ID" >
					
				</button>
			</c:if>
		</div>
	</div>
	<div class="col text-right">
		<div class="input-group">
			<div class="input-group-prepend">
				<select class="custom-select" name="kindOf">
					<option  ${paramMap.kindOf == 'NAME' ? 'seletced' : ''}>코드명</option>
					<option 
						${paramMap.kindOf == 'COMMONCODE_ID' ? 'selected' : ''}>코드
						ID</option>
				</select>
			</div>
			<input type="text" class="form-control" placeholder="..."
				name="searchText" >
			<div class="input-group-append">
				<button class="btn btn-outline-info" id="eventEnterKey"
					>
					
				</button>
			</div>
		</div>
	</div>
</div>

<table class="table table-striped table-hover table-bordered">
	<thead>
		<tr class="text-center">
			<th><input type="checkbox" id="selectall" /></th>
			<th>코드 ID</th>
			<th>코드명</th>
					</tr>
	</thead>
	<tbody>
		<c:set var="resultList" ></c:set>
		<c:forEach items="${resultList}" var="resultData" varStatus="loop">
			<tr>
				<td class="text-center"><input type="checkbox" class="checkbox"
					name="COMMONCODE_ID"  /></td>
				<td><button class="btn btn-link viewPopup" type="button"
						>${resultData.COMMONCODE_ID}</button>
				</td>
				<td>${resultData.NAME}</td>
				<td class="text-center">
					<div class="btn-group">
						<button class="btn btn-outline-info"
							 name="PARENT_COMMONCODE_ID" >
							
						</button>
					</div>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
<!-- /.table-responsive -->