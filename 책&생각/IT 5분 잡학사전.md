# IT 5 분 잡학사전



## 기초 편

---

#### 개발자 기본 양식

- 좋은 개발자는 암기력이 아닌, 개발 과정을 이해하는 사람이다.
- 다른 언어를 빠르게 배우는 방법
  1. 공식 문서 살펴보기 : 철학부터 사용해서 누가 이 언어를 사용해야 하는지, 올바른 사용법 등을 알 수 있다.
  2. 문법 확인하기
  3. 다른 언어와 공통점과 차이점 비교하기
  4. 새 언어로 코딩 시작하기
  5. 튜토리얼 시작하기 : 공식 문서에 있는 튜토리얼 시작하기
  6. 나만의 프로젝트 만들기

#### C언어, C++, C# 차이점

- C언어 : 한정된 자원을 효율적으로 쓰면서도 최대 성능을 내는 프로그램을 만들 때 주로 사용.
- C++: C언어를 확장한 슈퍼셋(Super set)이라고 하며 C언어를 포함한다. 또한 C언어는 절차 지향을 지원하고 C++은 절차, 객체 지향을 모두 지원한다. 속도 차이는 거의 없으며 철학과 용도가 다르다.
- C# : 마이크로소프트에서 만든 언어로, 다양한 분야에서 사용할 수 있다. 실행 속도는 C언어 가운데 가장 느리다.

#### 파이썬 관련

- 장점 
  - 영어와 매우 비슷하기 때문에 친숙하다.
  - 활용 범위가 매우 넓다.
  - 커뮤니티가 광범위하다.
  - 업무 자동화(Scripting)에 최적화되어 있다.
- 파이썬은 인터프리터 언어이며, C언어는 컴파일러 언어이다.
- 인터프리터는 한 줄 씩 기계어로 번역 후 실행하며, 컴파일은 통번역 후 실행하는 형식이다.
- 인터프리터는 컴파일보다 속도가 느리다.

#### 자바스크립트

- 하이브리드 앱, 크로스 플랫폼 앱을 만들 수 있다. : 아이오닉, 리액트 네이티브 모두 자바스크립트가 쓰여진다.
- 자바스크립트와 일렉트론으로 슬랙, 스카이프, 깃허브 같은 데스크톱 소프트웨어를 만들 수 있다.
- 게임, 3D, 가상현실, 머신러닝을 수행할 수 있다.

#### 코틀린

- 코틀린은 자바와 100% 호환되며, 자바를 코틀린으로 변경할 시 코드를 바꾸지 않아도 된다.
- 자바는 컴필레이션과 인터프리테이션을 동시에 활용한다.
- 자바 -> 컴파일 -> 자바 바이트 코드 -> JVM -> OS 기계어
- 코틀린을 자바 바이트 코드로 컴파일만 하면 된다. 
- 장점
  - 널에서 안전한(Null safety) 언어이다. 널이란 값이 전혀 없으며,  코틀린은 코드 실행하기 전에 널이 있을 것 같은 경우 미리 개발자에게 알려 준다. 결국 널을 허용하긴 하나 널 발생의 가능성을 미리 검사한다.
  - 한번에 많은 일을 할 수 있게 해주는 코루틴(coroutine) 문법을 지원한다. 



## 웹 기술 편

---

### 라이브러리 & 프레임워크

- 공통점 : 누군가 미리 작성해 놓은 코드이고, 우리의 개발 속도를 더 빠르게 만들어 주는 도구.
- 차이점 : 제어의 역전(Inversion Of Control) 
  -  라이브러리는 사용자가 라이브러리를 제어하며, 프레임워크는 프레임워크가 사용자를 제어한다.
  - 제이쿼리, 부트스트랩은 대표적인 라이브러리이며, 사용자가 직접 불러와 입맛에 맞게 사용한다.
  - 장고, 스프링은 대표적인 프레임워크이며, 프레임워크가 우리를 제어한다는 것은 사용자는 프레임워크의 규칙을 따라야 한다는 것이다. 예를 들어 장고를 개발할 때, 무조건 이름이 admin.py인 파일에 코드를 작성해야 하며 URL을 바꾸고 싶을 때 url.py인 파일에 코드를 작성해야 하는 식이다. 중요한 것은 이 규칙을 바꿀 수 없다는 것이다.  
  - 때문에 프레임워크를 교체하는 것이 라이브러리를 교체하는 것보다 더 느리고 난이도가 높다.

### 제이쿼리

- 장점 : 브라우저의 호환성을 챙기면서도 코드도 깔끔하고 아름답게 만들어 준다.
- 자바스크립트가 발전해가며 호환성도 좋아졌기 때문에, 제이쿼리는 정말로 필요할 때에만 배우는 것이 좋다.

### API

- Application Programming Interface의 약자이다.
- 프로그램들끼리 소통할 때 쓰는 일종의 규칙을 코드화 한 것.
- 예를 들어 기상청에서 제공하는 날씨 API를 이용하면 서울의 현재 날씨를 알 수 있듯이, 날씨 가져오기 기능으로 날씨 데이터베이스에서 정보를 얻는 형식이다.
- 웹 API의 마이크 접근 권한 기능을 사용하면 크롬 브라우저와 마이크를 연결하는 코드를 개발자가 직접 만들지 않고 사용할 수 있다.

### 도메인

- 도메인을 만드는 건 레지스트리(.com, .co.kr 등)이다.
- 레지스트리는 IP 주소와 도메인을 적은 전화번호부이다.
- 도메인을 웹 상에 요청 했을 때, 메인 전화번호부에서 어느 레지스트리에 있는지 찾고, 레지스트리에서 도메인을 찾는다.
- 레지스트리 운영사가 되려면 엄청난 돈과 인프라가 필요하다.
- 도메인을 구매하면 레지스트리 운영사가 아니라 리셀러에게 돈을 지불하는 것이다.
- 리셀러는 계약 관리, 결제 처리, 도메인 비용 지급 등의 일을 한다.

### 어도비 플래시

- 플래시는 게임, 영상을 제공하는 웹 사이트에서 사용하는 프로그램이다.
- 플래시는 웹을 위해 만들어 진 것이 아니며 본디 애니메이션을 그리는 제품이다.
- 어도비 플래시는 애니메이션을 브라우저에 띄울 수 있게 해주는 프로그램이다.
- 당시엔 웹 사이트를 꾸미는 것과 게임, 영상에 있어 획기적인 제품이었다.
- 단점 : 플래시는 오픈소스가 아니다. 또한 마우스가 필요하기 때문에 휴대폰 앱에 적합하지 않으며, 보안 이슈가 있다.
- HTML5와 CSS3로 대체되며 2020년 이후로 종료되었다.

### IE(Internet Explorer)

- 처음에 인터넷 익스플로러는 css 및 ajax 등 당시 새로운 기술을 가장 먼저 도입했기 때문에 인기가 높았다.
- 하지만 압도적인 독점으로 인해 게을러져서 렌더링 엔진 업데이트를 게을리 했기 때문에 사장되었다.
- 엔진의 성능이 웹 브라우저의 성능을 좌우하기 때문이다. 참고로 엣지의 엔진은 크롬의 엔진인 블링크를 사용한다.
- 렌더링 엔진이 최신이어야 최신 JS 문법도 받아들일 수 있다.

### 쿠키(Cookie)

- 정의 : 어떤 웹 사이트에 방문했을 때 브라우저를 통해 사용자의 컴퓨터에 보관하는 기록물.
- HTTP(HyperText Transfer Protocol) : 인터넷에서 정보를 주고 받기 위한 일종의 규칙(프로토콜).
- HTTP는 기본적으로 비연결성(stateless), 및 비지향성의 특징을 가지고 있다. 때문에 서버가 기억하기 위해 쿠키를 이용한다.
- 규칙 
  - 쿠키는 도메인 1 개에만 한정한다.
  - 쿠키는 자동으로 보낸다.
  - 쿠키는 컴퓨터에 자동으로 저장된다.

#### 프런트엔드 & 백엔드

- 프런트엔드, 백엔드는 웹 개발에 한정된 단어가 아니다.
- 프런트엔드 : 기술의 변화 속도가 엄청 빠르기 때문에 숙달해도 시간이 지나면 더 공부해야 하지만 그만큼 관련 기술이 활발히 논의 된다. 또한 자신이 입력한 내용을 바로 볼 수 있기 때문에 피드백이 빠르다.
- 백엔드 : 개발 환경이 안정적이며, 기술 선택지가 다양하지만 사용자와 거리가 멀어서 흥미가 떨어질 수 있다.

### 서버

-  모니터가 없거나 한 개만 있으며, 항상 인터넷에 연결되어 있다.
- 저장소와 메모리 크기는 매우 크다.
- 서버는 24시간 내내 열려 있으며, 접속 요청에 응답한다.
- 주소가 입력되면 그 주소에 해당하는 데이터를 꺼내서 보여준다. 

### 풀스택

- 데브옵스(Devops) : 소프트웨어의 개발과 운영의 합성어. 소프트웨어 개발자와 정보 기술 전문가 사이에 소통, 협업, 통합을 강조하는 개발 환경이나 문화를 말한다.
- 풀스택은 프론트앤드, 백엔드, 데브옵스를 합친 것이다.

### 서버리스(Serverless)

- 정의 : 서버 없음이 아닌 우리가 직접 관리하지 않는 서버를 의미한다.(우리 곁에 없는 서버)
- 예전에는 서버를 전부 수동으로 관리했으나, 아마존의 EC2(Amazon Elastic Compute Cloud) 서비스가 선보인 이후, 서버를 탄력적(elastic)으로 운영 할 수 있게 되었다. 즉, 최신 서버를 각종 사고 없이 안전하게 제공 및 관리해 주는 서비스이다. 서버의 메모리 또한 원하는 만큼 신청해서 사용할 수도 있다.
- 하지만 EC2는 하드웨어를 제공 및 관리해 주기만 하고 소프트웨어는 여전히 개발자가 관리해야 한다. 여기서 서버리스가 등장한다.
- 동작 방식 
  - 서버를 위한 소프트웨어(백엔드 코드)를 작은 함수 단위로 쪼개고 그 함수를 EC2(서버)에 올린다.
  - 해당 함수들은 항상 깨어있지 않고, 필요할 때마다(요청) 깨워서 요청한 작업을 수행한다. 응답한 뒤 해당 함수는 다시 잠을 잔다.
  -  이 같은 방식은 효율성이 압도적으로 높으며 사용자는 함수가 실행된 만큼만 돈을 내면 된다.
- 단점
  - 서버리스의 함수는 잠에서 깰 때 시간이 필요하다.(콜드 스타트) 
  - 서버 제공자에게 지나치게 의존한다. 때문에 단순히 함수를 빼서 다른 서비스로 옮기기 쉽지 않다.
- 이러한 장단점으로 인해 사이드 프로젝트 및 프로토타입을 빠르게 출시하고 싶은 기업이 많이 쓴다.



## 컴퓨터 공학 1

---

### 자료구조 & 알고리즘

목적 : 코드를 효율적으로 만들기 위해 & 데이터를 효율적으로 보관하고 찾기 위해

알고리즘 : 컴퓨터에게 내리는 지시 사항을 나열한 것.

자료구조도 목적에 따라 여러 가지 방식이 있다. 

- 데이터를 작은 것부터 큰 순서로 정리하는 자료구조(데이터 크기 기준)
- 이름표를 붙여서 정리하는 자료구조(검색을 위한 인덱스 기준)
- 데이터가 들어오는 순서로 정리하는 자료구조(생성 시간 기준)

### 배열(Array)

배열은 램에 줄줄이 이어진 형태로 공간을 차지하고 있다.

#### 메모리

컴퓨터의 기억 공간을 말하며, 메모리 종류는 휘발성 메모리, 비휘발성 메모리로 구분한다. 휘발성 메모리의 경우에 컴퓨터 전원을 껐을 때 저장한 값이 사라지는 메모리이며 램을 들 수 있다. 비휘발성 메모리의 경우 하드 드라이브가 대표적이다. 프로그램의 변수, 함수들이 램에 저장되며, 램이 있기 때문에 프로그램을 실행할 수 있다. 램은 데이터에 접근하는 속도가 매우 안정되고 빠르다.

램 속도가 빠른 이유 : 램은 주소지가 적힌 박스가 많이 있는 창고라고 생각할 수 있으며, 박스에는 데이터를 한 개씩 저장할 수 있다. 또한 박스마다 주소가 있기 때문에 박스에 보관된 데이터를 빠르게 찾을 수 있다. 주소가 없을 경우 데이터를 찾을 시, 앞쪽부터 데이터를 찾아야 하기 때문에 주소가 있을 경우 찾는데 시간이 빠르다.

#### 램의 관점에서 생각하는 배열

배열을 만들 때 배열의 길이를 먼저 컴퓨터에 전달해야 한다.(메모리 할당) 컴퓨터는 배열의 시작 주소와 길이를 알고 있기 때문에 읽는 속도가 아주 빠르다. 또한 배열은 맨 앞부터 채워져 있어야 하기 때문에 삽입과 삭제가 느리다.

#### 알고리즘 속도(시간 복잡도)

프로그램의 작업 속도가 얼마나 빠른지 측정하는 방법. 작업이 얼마나 많은 단계를 거치는지 측정한다. 시간 복잡도를 표기하는 방법을 Big-O 표기법이라고 한다. 이 표기법은 설명을 간단하게 만들어 줄 뿐 아니라 알고리즘 분석을 빠르게 할 수 있게 해준다. Big-O는 실행 단계에 영향을 주는 요소만 보기 때문에 O(2) 또한 O(1)로 표현된다. 배열의 경우에 길이와 상관 없이 늘 실행 횟수가 같으니까 같다는 의미로 1을 사용한다.

#### 선형 검색 & 이진 검색

선형 검색의 경우 맨 처음 배열부터 검색을 시작하며, 최악의 시나리오는 맨 마지막 데이터를 찾는 것이다.

이진 검색의 경우, 데이터의 정렬이 끝난 배열에서만 사용할 수 있다. 정렬 후 배열의 중앙에서 검색을 시작해 해당 숫자를 비교하여 큰지 작은지 확인한 후 맞는 숫자를 찾을 때까지 중앙값을 기준으로 이동한다. 이진 검색은 단계마다 배열의 절반을 제외할 수 있기 때문에 빠르다. 때문에 이진 검색은 거대한 배열을 다룰 때 효과적이며, 시간 복잡도는 O(logN)이다.

### 정렬 알고리즘

버블 정렬은 좋은 알고리즘이라고 할 수 없으며 많이 사용하지도 않으나, 이해하기는 쉽다. 시간 복잡도는 O(N^2)이다.

선택 정렬은 가장 작은 데이터 또는 가장 큰 데이터의 위치를 따로 기억해서 바꾸는 방식으로 정렬을 수행한다. 때문에 시간 복잡도는 역시 O(N^2)이다. 하지만 자리를 바꾸는 연산은 사이클 당 하나씩 이기 때문에  버블 정렬보다 훨씬 효율적이다.

삽입 정렬은 앞쪽의 데이터와 비교하여 앞의 숫자가 작을 경우 큰 숫자를 앞에 밀어 넣는다. 이 밀어 넣는 방식을 반복해서 정렬하기 때문에 시간 복잡도는 O(N^2)이지만 선택 정렬, 버블 정렬보다 빠르다.

시간 복잡도가 같다고 한 것은 시간 복잡도를 단순히 측정 했을 때 같을 뿐이지, 실제로는 속도 면에서 차이가 난다.

### Stack & Queue 

스택과 큐는 문법 없이 데이터 저장 시 규칙만 부여하기만 하면 되는 추상 자료구조이다.

#### Stack

- 스택의 규칙은 위에서 데이터를 쌓아야 하며, 위에서부터 데이터를 뺀다.(Last In First Out, LIFO) 
- 웹 브라우저의 뒤로 가기 및 되돌리기 단축키의 경우 스택을 활용한다.

#### Queue

- 큐의 규칙은 위로 데이터를 쌓아야 하며, 아래에서부터 데이터를 뺀다.(First In First Out, FIFO)
- 쇼핑몰 주문 처리 시스템의 경우 주문이 들어온 순서대로 데이터를 쌓고 가장 먼저 온 주문부터 처리해야 하므로 큐를 사용한다. 

### Hash Table

Hash Table은 key, value로 짝지어 모은 것인데(Map), 이를 통해 사용자가 데이터를 더 쉽게 정리할 수 있게 해준다. Hash Table의 시간 복잡도는 무려 O(1)이다. Hash Table은 key값만 찾으면 되기 때문에 데이터를 추가, 삭제할 때도 O(1)이기 때문에 검색 외 다른 작업에서도 효율이 좋다. 배열 대신 Hash Table을 이용해서 검색을 진행하면 더 빠르게 찾을 수 있다.

Hash Table은 기존의 인덱스로 구성된 배열에 Hash 함수가 추가된 케이스이다. Hash 함수는 key 값을 알고리즘을 통해 특정 인덱스로 변환하는 함수이다. 만약 Hash 함수를 통해 같은 인덱스가 나오는 것을 해시 충돌(Hash collison)이라고 하며, 대처 방법은 대표적으로 같은 인덱스 안에 또 다른 배열을 넣는 경우이다. 이런 경우는 시간 복잡도가 O(1)이 아닐 수 있다. 



## 컴퓨터 공학 2

### SQL

 SQL은 structured query language의 줄임말이다. 풀이하자면 SQL은 데이터베이스에 어떤 질문을 하기 위해 어떤 구조를 가진 언어라는 것을 알 수 있다. 한 마디로 말해 SQL은 데이터베이스를 다루는 언어이다.

하지만 데이터베이스는 그저 데이터를 보관하는 창고 역할만 할 뿐, 데이터를 정리하거나 조작하는 능력은 없다. 그런 일들은 RDBMS가 수행한다.

DBMS(Database Management System)이란 말 그대로 데이터베이스 관리 시스템이다. 즉, SQL로 데이터베이스와 상호작용을 하려면 DBMS를 거쳐야 한다는 뜻이며 SQL은 결국 DBMS과 대화하기 위한 언어이다.

MySQL이나 PostgreSQL 같은 제품은 데이터베이스가 아니라 DBMS이다. 편의 상 데이터베이스라고 말하는 것이다.

ORM은 Object Relational Mapping의 약자로, 사용자에게 익숙한 프로그래밍 언어로 SQL을 사용할 수 있게 해준다. 편리하기 때문에 개발자는 SQL 공부를 미루는 경향이 있으며, ORM을 지나치게 의존할 경우, ORM만으로 해결하지 못하는 문제가 생겼을 때 어려움을 겪을 수 있다.

파이썬은 장고 ORM, 라라벨은 엘러퀀트 ORM, Node.js는 시퀄라이즈 ORM 또는 타입 ORM이라는 도구가 있다.

### NoSQL

NoSQL은 기본적인 SQL과는 달리, 언어의 특징만 있는 것이 아니라 데이터베이스 성질 또한 다르다. 종류는 Document DB, Key-Value DB, Graph DB가 존재한다.

Document DB는 MongoDB가 대표적이며, 테이블 형식으로 관리하는 정적 형식이 아닌 JSON 형식으로 데이터베이스를 관리한다. 때문에 JSON의 장점인 사용자가 형식이나 타입을 마음대로 저장 및 관리할 수 있다.

Key-Value DB는 CassandraDB, DynamoDB가 대표적이며, CassandraDB의 특징은 열이 넓다는(column wide) 것이다. 말 그대로 한 행의 열이 매우 넓다는 것이며 장점은 수만 개의 데이터를 1초 만에 순식간에 쓸 수 있을 정도로 읽고 쓰는 속도가 빠르다는 것이다. DynamoDB 또한 1초에 24,000개나 읽을 수 있을 정도로 빠르다.

Graph DB의 경우 페이스북이 만든 데이터베이스로, 노드를 기준으로 관계망으로 연결해서 데이터를 관리한다.

이렇게 많은 데이터베이스 중에 무엇이 더 좋다고는 할 수 없으며, DB별 장점에 따라 선택하면 된다.

### Git & Github

Git은 파일 이력을 관리하는 프로그램이며, Github는 파일과 깃으로 관리한 이력을 관리하는 공간이다.

### 비밀번호 저장 방식

비밀번호 시스템을 구축한 사람도 비밀번호를 그대로 볼 수 있어서는 안되기 때문에, 데이터베이스에 비밀번호 그대로 넣는 것은 매우 좋지 않는 방법이다.

때문에 어떤 회사는 데이터베이스 자체를 암호화해서 아무도 볼 수 없게 만든 다음 비밀번호를 저장한다. 사용자는 키를 가지고 비밀번호 저장 장소를 복호화하여 비밀번호를 비교하기도 하는데, 이 경우 키를 잃어버리거나 털리면 답이 없어지기 때문에 이 또한 좋은 방법이 아니다. 

해시 함수를 사용할 경우, 적당히 비밀번호를 암호화하여 저장할 수 있다. 해시 함수는 동일한 입력 값에 동일한 출력 값(일대일)을 가지며, 입력 값이 살짝만 바뀌어도 출력 값은 드라마틱하게 바뀌고, 반대로 암호화된 비밀번호를 다시 해시 함수에 넣을 경우 이전 값으로 되돌아가지 않기 때문에 좋다.

하지만 해시 함수의 경우 레인보우 테이블이라는 원래의 값과 변경된 값을 연결하는 표가 존재하기 때문에, 레인보우 테이블이 털리면 위험해진다. 

그에 대한 방안으로 해시 함수에 넣기 전에 무작위 텍스트인 솔트를 추가한 뒤 해시 함수에 넣으면 비밀번호 암호화가 훨씬 안전해진다.

### 함수형 프로그래밍

함수형 프로그래밍은 객체 지향 프로그래밍처럼 프로그래밍 패러다임 중 하나이다. 함수형 프로그래밍은 버그가 발생하기 어려운 구조이기 때문에 개발자에게 매우 유용하다.

함수형 프로그래밍은 선언형 프로그래밍이 라고도 하며, 객체 지향 프로그래밍은 명령형 프로그래밍이 라고도 한다. 선언형 프로그래밍은 원하는 결과 값을 선언한다는 것이며, 명령형 프로그래밍은 원하는 결과 값에 어떻게 도달하는지 선언한다. 선언형 프로그래밍의 대표적인 케이스가 CSS이다. 

JS 또한 replaceAll() 등 선언형 프로그래밍이 존재하지만 명령형 프로그래밍으로 작성되어 있다. 그래서 모든 선언형 프로그래밍은 명령형 프로그래밍 위에 쓴다고도 할 수 있다.

명령형 프로그래밍은 할 일을 세세하게 지시할 수 있지만, 버그가 나기 쉬우며 다른 개발자가 보기 어려운데 비해 선언형 프로그래밍은 결과 중심으로 작성하기 때문에 버그가 현저히 적으며, 다른 개발자가 보기 쉽다.

함수형 프로그래밍의 특징은 아래 코드처럼 파라미터를 함수 형식으로 보내는 방식으로 코드를 적는다.

``` javascript
function checkForOdd(item){
    return item % 2 === 0;
}

function removeOdd(items){
    return items.filter(checkForOdd);
}
```



## 최신 기술

---

### 1. 인공지능 & 머신러닝 & 딥러닝

#### 인공지능 종류

- 인공지능은 좁은 인공지능, 일반 인공지능 두 가지로 나뉠 수 있다.
  - 좁은 인공지능은 특정 분야만 탁월한 인공지능이며, 실제 현실에서 머신러닝으로 만드는 인공지능이다. 
  - 일반 인공지능은 사람처럼 대화, 게임, 판단 등 전반적으로 사람보다 월등히 뛰어난 기계를 말한다.

#### 머신러닝 정의 및 학습 방법

- 머신러닝, 딥러닝은 인공지능을 학습시키는 방식을 말한다.
- 머신러닝을 가르치는 방법은 지도 학습, 비지도 학습 두 가지로 나뉠 수 있다.
  - 지도 학습은 특정하려는 물체의 특징인 라벨(Label)을 토대로 개발자가 특정하려는 물질이라고 알려주면서 기계를 학습 시키고,  기계는 학습을 토대로 확률을 계산해서 특정 물질이 아닌지 알려주는 학습 방식을 말한다.
  - 비지도 학습은 라벨을 거론 없이, 수 만개의 데이터를 기계에 학습시키는 방식을 말한다.

### 딥러닝 정의

- 딥러닝은 머신러닝의 한 종류로써, 생물의 신경망에서 영갑을 받아 여러 층으로 깊이(deep) 학습하는 머신러닝이다.



## 2. REST API

#### 정의

- REST API는 API의 한 종류로써, Representational State Transfer의 줄임말이다.
- REST 방식으로 설계한 API라고 말하기도 한다.

#### 사용 이유

- API 설계 시, /seemovie 또는 /getmovie 형식으로 하는 경우가 있는데, 이런 설계는 피해야 한다. 
- see, get 의미상 동사를 사용할 경우 혼동될 수 있기 때문에 API 설계시 동사를 사용하면 안된다.
- 이 경우, HTTP Method를 사용하면 된다.

#### HTTP Method

- HTTP Method란 웹 기술을 뜻하는데, 쉽게 말해 같은 URL로 백엔드에서 다른 처리를 할 수 있도록 일종의 갈림길을 만드는 기능이다. 

- HTTP Method를 이용하면 동사를 사용하지 않을 수 있으며, 이는 URL이 단순해지고 기능 확장하기도 용이하다. URL 하나에 CRUD를 전부 수행하게 만들 수 있다.

- 특정 값을 조회하려면 쿼리 파라미터를 사용하면 된다.

- Method의 종류는 다음과 같다.

  - GET : 조회
  - POST : 생성
  - PUT : 전체 수정 (Table 기준 row 전체)
  - PATCH : 부분 수정 (Table 기준 row의 column 하나만)
  - DELETE : 삭제

  

## Docker

#### 정의 및 특징

- 개발 환경 준비는 경우에 따라 시간이 오래 걸릴 수 있으며, 개발 환경과 배포 환경이 다를 수도 있기 때문에 낭패를 볼 수 있다.(ex: 개발 환경은 윈도우, 배포 환경은 리눅스 일 경우.)
- 도커는 개발 환경이 맞지 않은 상황 또는 개발 환경이 변경되었을 때 유연하게 대처할 수 있게 한다.
- 사용 방법은 먼저 서버 위에 도커 설치 후, 개발 환경 목록을 도커 파일로 만든다. 도커 파일 완성 후 서버에 전달하면 도커는 자동으로 그 파일을 확인하여 필요한 것을 내려 받아 설치한다. 만약 도커가 없을 경우, 개발 환경은 모두 수동으로 설치해야 한다.
- 도커는 원하는 개발 환경을 도커 파일에 저장하여 준비해 준다.
- 도커가 마련한 개발 환경은 컨테이너 형태로 존재하므로, 개발에 필요한 도구를 따로 모아 준비할 수도 있고, 쉽게 복제도 가능하다.

#### 컨테이너

- 도커가 준비한 프로그래밍 언어가 동작하는 환경을 컨테이너라고 한다. 개발자의 컴퓨터에서 여러 프로그램을 개발하고 있다면 개발 환경도 여러 종류가 필요할 것이다. 도커는 그것들을 컨테이너로 나눠서 관리할 수 있다. 개발 환경 준비를 더욱 편리하게 만들어 주는 것이다.
- 이처럼 도커 컨테이너는 서로 분리되어 있고 독립적이라서 컴퓨터 하나에 수많은 컨테이너가 있을 수 있다. 컨테이너를 미리 분리해서 관리하면 개발 환경이 갑작스럽게 변해도 쉽게 대처할 수 있다. 특정 애플리케이션의 사용량이 증가하면 해당 컨테이너의 개수를 늘리기만 하면 되는 것이다. 반대도 가능하다.ㄴ
- 만약 도커와 컨테이너가 없다면 사용량이 늘 때마다 서버를 구매해야 하고, 개발 환경을 설치하고 이런 반복 잡업을 엄청 많이 해야 한다. 도커를 사용하면 추가 개발 환경은 컨테이너를 복제하면 바로 준비할 수 있다.



### 모바일 애플리케이션

- 모바일 애플리케이션이라 하면, ios 앱, 안드로이드 앱을 뜻하며, IOS 및 안드로이드는 운영체제이다.
- 모바일 애플리케이션을 만드는 방식은 크게 하이브리드, 크로스플랫폼, 네이티브 3가지로 나뉠 수 있다.

#### 하이브리드 앱

- 하이브리드 앱은 웹사이트를 보여주는 웹 뷰이며, 웹 뷰는 주소 창(네비게이션)이 없는 브라우저라고 보면 된다. 이렇게 웹 뷰로 만든 앱을 웹 앱이라고도 한다.
- HTML, CSS, JS 로 만든 웹을 IOS, 안드로이드에도 쓸 수 있도록 하이브리드로 만들어 플레이 스토어 같은 판매하는 곳으로 보내면 사용자는 이것을 내려 받아서 쓰면 되는 형식이다.
- 장점 : HTML, CSS, JS만 쓰면 되기 때문에 네이티브 앱 개발 지식이 필요 없다.
- 단점 : UI를 직접 한 땀 한 땀 짜야 하며, 스마트폰의 고급 하드웨어 기능을 활용하기 어렵다. 기본 카메라 기능, 위치 확인, 네트워크 정보를 얻는 정도만 가능하다.

#### 크로스플랫폼 엡

- 특정한 언어로 코딩하면, 후에 IOS, 안드로이드에서 이해할 수 있는 코드로 변환해서 만든다. 이는 어던 언어로 코드를 작성하면 그 코드가 나중에 네이티브 코드로 변환된다는 뜻이다.
- 리액트 네이티브는 리액트에서 이해할 수 있는 코드로 만들고 JS 코드로 변경된다. 이는 IOS, 안드로이드가 JS 엔진으로 실행한다. 
- 플러터(Flutter)는 dart라는 언어로 개발한 뒤 C 또는 C++로 변환되어 실행한다.
- 장점 : 개발자가 익숙한 코드로 한 번만 작성하면 IOS, 안드로이드 양쪽에서 실행 가능하기 때문에 중복 개발할 필요가 없다. 또한 개발자 커뮤니티가 활발하다.
- 단점 : 운영체제가 이해할 수 있는 코드로 변환하는 과정이 있기 때문에 네이티브 앱에 비해 성능이 느리다.

#### 네이티브 앱

- 각각의 운영체제만을 위한 언어로 만든 앱이다. IOS는 스위프트(swift), 안드로이드는 자바나 코틀린으로 개발한다.
- 장점 : 스마트폰의 성능을 최대한 활용할 수 있다.
- 단점 : 다른 앱 개발에 비해 배우는 데 시간이 많이 소요된다. 또한 IOS 및 안드로이드 개발을 개별적으로 진행해야 한다.



### NFT

- NFT란 non fungible token의 줄임말로 대체 불가능한 토큰을 말한다. 화폐는 1달러 자체의 경우 다른 1달러로 대체 가능함에 비해 땅, 한정판 신발, 전세 계약 같은 경우는 대체 불가능하다고 말할 수 있다.
- 토큰이란 이더리움(Ethereum)과 같은 블록체인으로 발행한다. 토큰에는 `돈을 받는 기능` 과 `돈을 받고 토큰을 보내주는 기능` 이 반드시 있어야 한다. 그것을 합쳐서 스마트 계약 이라고 한다. 토큰을 잘 활용한 예가 코인이다.
- 코인은 여러개 있을 수 있기 때문에 화폐로 활용된다. 그러나 토큰을 딱 한 개만 발행할 수 있도록 스마트 계약을 만들고 그 안에 이미지나 영상 등 콘텐츠를 넣을 경우 NFT가 되는 것이다. 실제로 돈을 주고 산 것은 콘텐츠가 아니라 단 한 번만 발행된 토큰이라는 것이다.
- NFT가 비싼 경우는 유일한 원본, 진짜라는 사실이 가치를 크게 높여주기 때문이다. 그리고 가상 속에서 유일한 원본임을 증명하는 기술이 바로 NFT이다. NFT는 인터넷 세상에서 재산권을 증명하는 기술이 될 것이다.



### 멀웨어

- 멀웨어(malware)는 악성 소프트웨어라고도 하며, 컴퓨터를 감시하거나 파괴하는 프로그램이다. 이런 사이버 무기는 국가나 특정 기관에서 만들어 사용한다고 한다.
- 멀웨어 중에서도 바이러스(virus) 웜(warm)이 가장 많이 알려져 있다. 이 둘은 복제 방식부터 다르다. 바이러스와 웜은 복제되어 전파된다는 것이 공통점이다.
- 바이러스의 경우 숙주가 필요하며(감염된 파일을 통한 복제), 웜은 자기 자신을 복제하며 전파된다. 웜은 심지어 USB를 통해서 전파할 수 있다.
- 웜은 미사일(missile)과 페이로드(payload)가 필요하다. 웜은 미사일을 통해 컴퓨터 안에 침투하고, 그 순간 페이로드를 배포하는 방식으로 컴퓨터를 파괴시킨다. 웜은 암호화된 상태로 사용자의 컴퓨터에 도착해서 스스로 암호화를 해제하고 웜을 만들었던 본부에 연락한다.
- 웜이 더 위험한 이유는 웜이 컴퓨터의 루트에 설치된다는 사실 때문이다. 컴퓨터의 보안 구조는 애플리케이션 링 - 드라이버 보안 링 - 중앙 보안 링 세가지 링으로 나뉘어져 있다. 컴퓨터의 모든 자원을 관리하는 운영체제는 중앙 보안 링에 설치돼 있는데 웜도 중앙 보안 링에 설치된다. 이는 운영체제를 조작할 수 있고, 백신 프로그램보다 우위에 있다는 것을 의미한다.

#### 제로 데이(Zero day)

- 웜이 중앙 보안 링에 설치 될 수 있는 이유는 제로 데이를 가지고 있기 때문이다. 제로 데이란 아직 아무도 발견하지 못한 프로그램 취약점을 뜻한다. 이는 취약점을 인식하고 발견하기 전까진 웜이 활개친다는 뜻이다. 때문에 제로 데이는 희귀하고 비싸다.
- 스턱스넷이라는 웜은 제로 데이를 4개나 가지고 있으며, 특히 컴퓨터 드라이버 까지 설치가 가능했다. 이는 인터넷에 절대 연결하지 않는 에어갭 컴퓨터에도 자료를 훔쳐서 웜을 만들었다는 뜻이다. 스턱스넷은 컴퓨터를 10만대 이상 감염시켰으며, 산업 현장에 있는 기계(핵 원심 분리기 포함)들을 감시하는 프로그램만 조작하도록 설계 되었다.