
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<h1>e-Logistics</h1>
<div class="col-md-12">
    <div class="row">
        <div class="col-md-6">
            <c:choose>
                <c:when test="${empty member}">
                    <!--스프링 시큐리티에서 기본적으로 제공하는 로그인 URL-->
                    <a href="/oauth2/authorization/google" class="btn btn-success active" role="button">Google Login</a>
                </c:when>
                <c:otherwise>
                    Logged in as: <span id="user">${member.name}</span>
                    <a href="/logout" class="btn btn-info active" role="button">Logout</a>
                    <c:choose>
                        <c:when test="${member.role eq 'RETAIL'}">
                            <a href="/orders/save" role="button" class="btn btn-primary">주문하기</a>
                        </c:when>
                        <c:when test="${member.role eq 'PROVIDER'}">
                            <a href="/item/save" role="button" class="btn btn-primary">상품 등록</a>
                        </c:when>
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <br>
    <!-- 목록 출력 영역 -->
    <table class="table table-horizontal table-bordered">
        <thead class="thead-strong">
        <tr>
            <th>주문번호</th>
            <th>주문내역</th>
            <th>갯수</th>
            <th>총 가격</th>
            <th>담당자</th>
            <th>배송상태</th>
            <th>주문일</th>
        </tr>
        </thead>
        <tbody id="tbody">
        <!--delivery 리스트 순회-->
        <c:forEach var="delivery" items="${delivery}">
            <tr>
                <!--List에서 뽑아낸 객체의 필드 사용-->
                <td><a href="/orders/update/${delivery.id}">${delivery.id}</a></td>
                <td>${delivery.name}</td>
                <td>${delivery.count}</td>
                <td>${delivery.price}*${delivery.count}</td>
                <td>${member.id}</td>
                <td>${delivery.status}</td>
                <td>${delivery.createDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="layout/footer.jsp"%>
