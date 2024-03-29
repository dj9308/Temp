# DB 용어 정리

## 카탈로그(Catalog)

---

### 정의

- 시스템 카탈로그는 시스템 그 자체에 관련이 있는 다양한 객체에 관한 정보를 포함하는 시스템 데이터베이스이다.
- 시스템 카탈로그 내의 각 테이블은 사용자를 포함하여 DBMS에서 지원하는 모든 데이터 객체에 대한 정의나 명세에 관한 정보를 유지 관리하는 시스템 테이블이다.
- DDL(데이터 정의서)의 결과로 구성되는 기본 테이블, 뷰, 인덱스, 패키지, 접근 권한 등의 데이터베이스 구조 및 통계 정보를 저장한다.
- 카탈로그들이 생성되면 자료 사전(Data dictionary)에 저장되기 때문에 카탈로그를 자료 사전이라고 한다.
- 카탈로그에 저장된 정보를 메타 데이터라고 한다.

### 특징

- 카탈로그 자체도 시스템 테이블로 구성되어 있어 일반 이용자도 SQL을 이용하여 내용을 검색해 볼 수 있다.
- INSERT, DELETE, UPDATE문으로 카탈로그를 갱신하는 것은 허용되지 않는다.
- 데이터베이스 시스템에 따라 상이한 구조를 갖는다.
- 카탈로그는 DBMS가 스스로 생성하고 유지한다.
- 카탈로그 갱신 : 사용자가 SQL문을 실행시켜 기본 테이블, 뷰, 인덱스 등에 변화를 주면 시스템이 자동으로 갱신한다.
- 분산 시스템의 카탈로그 : 보통의 릴레이션, 인덱스, 사용자 등에 포함할 뿐 아니라 위치 투명성 및 중복 투명성을 제공하기 위해 필요한 모든 제어 정보를 가져야 한다.



## 스키마(Schema)

---

### 정의

- 스키마는 데이터베이스의 구조와 제약 조건에 관한 전반적인 명세를 기술한 메타 데이터의 집합이다.
- 스키마는 데이터베이스를 구성하는 데이터 개체(Entity), 속성(Attribute), 관계(Relationship) 및 데이터 조작 시 데이터 값들이 갖는 제약 조건 등에 관해 전반적으로 정의한다.
- 스키마는 사용자의 관점에 따라 외부 스키마, 개념 스키마, 내부 스키마로 나눠진다.

![스키마](https://t1.daumcdn.net/cfile/tistory/9936823A5B698C4023)

### 특징

- 스키마는 데이터 사전(Data dictionary)에 저장되며, 다름 이름으로 메타 데이터라고 한다.
- 스키마는 현실 세계의 특정한 한 부분의 표현으로서 특정 데이터 모델을 이용해서 만들어진다.
- 스키마는 시간에 따라 불변인 특성을 갖는다.
- 스키마는 데이터의 구조적 특성을 의미하며, 인스턴스에 의해 규정된다.