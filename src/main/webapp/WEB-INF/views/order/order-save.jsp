<%--
  Created by IntelliJ IDEA.
  User: 김경희
  Date: 2022-07-03
  Time: 오후 7:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>
<h1>주문 등록</h1>

<div class="col-md-12">
    <div class="col-md-4">
        <form>
            <div class="form-group">
                <label for="category">카테고리</label>
                <select id="category">
                    <option value="category1">카테고리1</option>
                    <option value="category2">카테고리2</option>
                    <option value="category3">카테고리3</option>
                </select>
            </div>
            <div class="form-group">
                <fieldset>
                    <legend>상품 목록</legend>
                    <input type="checkbox" name="itemList" id="item1">
                    <label for="item1">상품1</label>
                    <input type="checkbox" name="itemList" id="item2">
                    <label for="item1">상품2</label>
                </fieldset>
            </div>
            <div class="form-group">
                <div class="form-group">
                    <label for="count">갯수</label>
                    <input type="number" class="form-control" id="count">
                </div>
            </div>
            <div id="form-group">
                <label for="orderList">현재 주문 목록</label>
                <textarea class="form-control" id="orderList"></textarea>
            </div>
        </form>
        <br>
        <a href="/" role="button" class="btn btn-secondary">취소</a>
        <button type="button" class="btn btn-primary" id="btn-order-save">등록</button>
    </div>
</div>
<%@ include file="../layout/footer.jsp" %>
