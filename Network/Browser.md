# 브라우저(Browser)

## 정의 

- 웹 서버에서 이동하며 쌍방향으로 통신하고 HTML문서나 파일을 출력하는 그래픽 사용자 인터페이스 기반의 응용 소프트웨어.
- IE, Chrome, Opera, Firefox 등

## 주요 기능

- 사용자가 선택한 자원을 서버에 요청하고 브라우저에 표시하는 것.
- 자원은 보통 HTML문서지만 PDF, IMAGE 등 다른 형태일 수 있다.
- 자원의 주소는 URL(Uniform Resource Identifier)에 의해 정해진다.
- 브라우저는 HTML과 CSS 명세에 따라 HTML 파일을 해석해서 표시하는데, 이 명세는 웹 표준화 기구인 W3C(World Wide Web Consortium)에서 정한다.
- 브라우저의 사용자 인터페이스 구성 요소는 다음과 같다.
  - URI를 입력할 수 있는 주소 표시 줄
  - 이전 버튼과 다음 버튼
  - 북마크
  - 새로 고침 버튼과 현재 문서의 로드를 중단할 수 있는 정지 버튼
  - 홈 버튼

## 구성 요소

- 사용자 인터페이스 : 주소표시줄, 이전/다음 버튼, 북마크 메뉴 등
- 브라우저 엔진 : 사용자 인터페이스와 렌더링 엔진 사이의 동작 제어
- 렌더링 엔진 : 요청한 컨텐츠를 표시. 예를 들어 HTML을 요청하면 HTML과 CSS를 파싱하여 화면에 표시한다.
- 통신 : HTTP 요청과 같은 네트워크 호출에 사용된다.
- UI 백엔드 : 플랫폼에서 명시하지 않은 일반적인 인터페이스로서, OS 사용자 인터페이스 체계를 사용
- 자바스크립트 해석기 : JS 코드 해석 후 실행
- 자료 저장소 : 자료 저장 계층(cookie 등)

![brouser1](https://d2.naver.com/content/images/2015/06/helloworld-59361-1.png)

## 렌더링 엔진

- 요청 받은 내용을 브라우저 화면에 표시하는 엔진
- 다양한 종류의 파일을 렌더링 할 수 있다.

### 동작 과정

![brouser2](https://d2.naver.com/content/images/2015/06/helloworld-59361-2.png)

1. 통신으로부터 요청한 문서의 내용 얻기(8KB 단위로 전송)
2. DOM 트리 구축 위한 HTML 파싱 후 태그를 DOM 노드로 변환
3. CSS 파일과 함께 포함된 스타일 요소도 파싱
4. 스타일 정보와 생성된 DOM 노드대로 렌더 트리 구축
5. 렌더 트리 배치(각 노드가 화면의 정확한 위치에 표시)
6. UI 백엔드에서 렌더 트리의 각 노드를 가로지르며 형상 만들기(렌더 트리 그리기)

### 예시

- 웹킷 엔진(사파리, 크롬)

![brouser3](https://d2.naver.com/content/images/2015/06/helloworld-59361-3.png)

- 게코 엔진(모질라)

![brouser4](https://d2.naver.com/content/images/2015/06/helloworld-59361-4.png)

## 참고 페이지

[네이버 D2](https://d2.naver.com/helloworld/59361)

