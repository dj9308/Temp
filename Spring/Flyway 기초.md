# Flyway

## 정의

- 데이터베이스 형상관리 툴
- 로컬에서 변경한 데이터베이스의 스키마나 데이터를 운영 데이터베이스에 반영하는 것을 누락하는 것을 막기 위해 사용.
- 개발 DB와 운영 DB의 스키마를 비교하거나, 운영 DB에 수작업을 가하는 노가다와 위험성을 줄이기 위해 사용한다.
- 생성한 형상을 새로운 DB에 적용하면 그게 마이그레이션이다.

## 동작방식

- Flyway가 연결된 데이터베이스에 자동으로 SCHEMA_VERSION이라는 메타데이터 테이블이 생성한다.
- Flyway는 사용자가 정의한 sql의 파일명을 자동으로 스캔하여, SCHEMA_VERSION에 버전 정보를 남기는 동시에, 데이터베이스에 변경내용을 적용.
- select * from flyway_schema_history; 를 입력하면 스키마 관련 테이블이 뜬다.

## 명령어 설명

- init : SCHEMA_VERSION을 baseline과 함께 생성한다. 테이블이 이미 생성되어 있으면 수행되지 않는다.
- migrate : 스키마 정보를 리얼 DB에 마이그레이션한다.
- clean : flyway로 생성한 스키마를 모두 삭제한다고 하지만, 해당 데이터 베이스의 모든 테이블을 삭제한다.
- info : DB에 적용된 스키마 정보와, 로컬에 pending 돼있는 변경정보를 보여준다.
- validate : DB와 로컬의 변경점을 비교하여 보여준다.
- repair : 마이크레이션 실패한 내역을 수정한다.(삭제, 교체)
- baseline : flyway로 형상 버전관리를 시작 할 baseline을 설정한다.

### gradle

```
dependencies {
	implementation 'org.flywaydb:flyway-core'
	}
```

### 오류 피드백

- 인코딩 문제 발생 가능 : eclipse 인코딩 utf8 설정하기
- flyway 홈페이지의 gradle 코드 삽입시 인식이 안됨 : https://start.spring.io/ 에서 dependency 생성 가능

