<%--
  Created by IntelliJ IDEA.
  User: 김경희
  Date: 2022-07-01
  Time: 오후 4:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp"%>
<h1>상품 리스트</h1>

<table class="table table-horizontal table-bordered">
    <thead class="thead-strong">
    <tr>
        <th>상품 번호</th>
        <th>상품 이름</th>
        <th>상품 가격</th>
        <th>상품 수</th>
        <th>담당자</th>
        <th>카테고리</th>
    </tr>
    </thead>
    <tbody id="tbody">
    <c:forEach var="item" items="${item}">
        <tr>
            <!--List에서 뽑아낸 객체의 필드 사용-->
            <td>${item.id}</td>
            <td><a href="/item/update/${item.id}">${item.name}</a></td>
            <td>${item.price}</td>
            <td>${item.quantity}</td>
            <td>${item.provider}</td>
            <td>${item.categoryName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@ include file="../layout/footer.jsp"%>
