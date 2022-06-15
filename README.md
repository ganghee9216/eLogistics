# eLogistics
- JSP / MVC 패턴을 이용한 3PL 물류시스템 프로젝트 입니다.
- 소매업체, 공급업체, 물류업체가 같이 사용할 수 있는 어플리케이션입니다.
- 각 업체별로 다른 role을 부여하고 스프링 시큐리티를 적용하여 접근할 수 있는 기능을 설정합니다.
- 소매업체는 주문 관련 기능, 공급업체는 납품 및 상품등록 관련 기능을 이용할 수 있습니다.

## 요구사항
**소매업체**
번호 | 기능 | 기능 내용
---|---|---|
1 | 주문 | 공급업체가 등록한 카테고리 중 선택하여 주문 생성
2 | 주문내역 확인 | 아이템별로 주문 확인
3 | 주문내역 확인 | 전체 주문내역 리스트로 확인
4 | 주문 변경 | 주문 아이템, 갯수 수정 가능
5 | 주문 상태 확인 | 배송 전 주문 내역 확인
6 | 주문 상태 확인 | 배송 중 주문 내역 확인
7 | 주문 상태 확인 | 배송 완료된 주문 내역 확인
8 | 주문 취소 | 배송 시작 전인 주문 선택 취소

**공급업체**
번호 | 기능 | 기능 내용
---|---|---|
1| 납품 | 주문에 맡게 납품
2| 납품내역 확인 | 배송 진행 중인 납품내역 확인
3| 납품내역 확인 | 배송 완료된 납품내역 확인
4| 추가 납품 | 물품 추가 납품
5| 물품 등록 | 카테고리를 설정해서 물품 등록
6| 카테고리 내역 | 등록된 카테고리와 속한 물품 확인

**물류업체**
번호 | 기능 | 기능 내용
---|---|---|
1 | 출고내역 확인 | 공급업체로부터 받은 출고내역 확인 후 배송 전으로 상태 변경
2 | 배송 진행 | 배송 중으로 상태 변경

## 테이블 설계

#### 공급업체
![image](https://user-images.githubusercontent.com/105147525/173352720-24f7d63e-c2c9-4755-9267-f7bcde4471a4.png)

#### 소매업체

![image](https://user-images.githubusercontent.com/105147525/173355768-90906779-1c1d-4e07-8f9f-f1c16e4e45e4.png)

#### 물류업체

![image](https://user-images.githubusercontent.com/105147525/173823503-e2c39b0e-e198-47f8-baf6-16a6f5b1ca9d.png)

