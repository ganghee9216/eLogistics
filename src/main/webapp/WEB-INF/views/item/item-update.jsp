<%--
  Created by IntelliJ IDEA.
  User: 김경희
  Date: 2022-06-29
  Time: 오후 7:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp"%>
<h1>상품 수정</h1>

<div class="col-md-12">
    <div class="col-md-4">
        <form>
            <div class="form-group">
                <label for="id">글 번호</label>
                <input type="text" class="form-control" id="id" value="${item.id}" readonly>
            </div>
            <div class="form-group">
                <label for="name">상품 이름</label>
                <input type="text" class="form-control" id="name" value="${item.name}">
            </div>
            <div class="form-group">
                <label for="price">상품 가격</label>
                <input type="text" class="form-control" id="price" value="${item.price}">
            </div>
            <div class="form-group">
                <label for="quantity">갯수</label>
                <input type="number" class="form-control" id="quantity" value="${item.quantity}">
            </div>
            <div class="form-group">
                <label for="category">카테고리</label>
                <input type="text" class="form-control" id="category" value="${item.categoryName}">
            </div>
        </form>
        <a href="/" role="button" class="btn btn-secondary">취소</a>
        <button type="button" class="btn btn-primary" id="btn-item-update">수정 완료</button>
        <button type="button" class="btn btn-danger" id="btn-item-delete">삭제</button>
    </div>
</div>

<%@ include file="../layout/footer.jsp"%>
