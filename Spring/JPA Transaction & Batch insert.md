# JPA Transaction, Batch Insert

## 개요

- 사용자, 부서 테이블 동기화 기능 구현 중 발생했던 이슈 해결 과정을 담은 문서.
- json 파일 업로드 -> 테이블 초기화 -> 데이터 Batch Insert 의 과정을 구현 및 Transaction 처리.
- Transaction 테스트 중, rollback이 안되는 경우 발생.
- Batch Insert 구현 중 Multi Row Insert가 안되는 경우 발생.(성능 이슈)



## 해결 과정

### Transaction 설정 관련

- @Transactional 설정 후 테스트 시 rollback이 안되는 이슈 발견.
  - 이슈 원인 부분을 찾음 : auto_increment 초기화 코드를 시행하면 이전 쿼리는 rollback이 안됨
  - 이유는 불명확하여 jpa 기본 원리부터 알아가며 이유를 찾음
  - ![img](https://velog.velcdn.com/post-images%2Fconatuseus%2Feb6c9c30-d09c-11e9-b0db-1597a34a142f%2Fimage.png)
  - 찾은 이슈 코드 중 @Modifying은 내부에 jdbc의 executeupdate() 함수를 실행하기 때문에, 영속성 컨텍스트를 거치지 않고 바로 db에 쿼리를 시행함. 때문에 db 및 동기화 문제가 발생.(해당 문제는 @Modifying 조건을 수정하면 됨)
  - 해당 문제는 hibernate의 flushmodetype dafault 설정 때문에 나온 문제로 확인.
    - auto : flush가 쿼리 실행 시 발생 (default)
    - commit : flush가 transaction이 commit되는 시점에 발생
  - 즉, 실제 쿼리가 발생할 때마다 영속성 컨텍스트에 flush을 실행하도록 설정되어 있었기 때문에 auto_increment 초기화 쿼리가 실행되면 이전 쿼리는 rollback이 안되고 실행(flush) 된 것.
- 결국, 해당 이슈 및 ID 채번 시 identity 할 경우 하단의 batch insert 이슈 때문에 ID를 직접 할당하는 것으로 변경 후 해결 완료.



### BATCH INSERT 성능 최적화 관련

- jpa의 bulk insert의 경우, ID 채번을 identity 형식으로 할 경우, JPA 영속성 컨텍스트 컨셉 상 Batch insert 지원이 불가.
  - identity 방법은 영속성 컨텍스트에서 ID를 채번하는 것이 아닌 DB에서 직접 채번하기 때문.
- 때문에 성능 이슈 발생. => mybatis 사용 또는 jdbctemplate 사용
  - jdbctemplate을 적용해봤으나 multi row insert가 안되는 것을 확인.
- mysql url을 따로 설정해서 해당 이슈 해결.
  - ` rewriteBatchedStatements=true` : multi row insert 가능하도록 설정.
  - `profileSQL=true` : Driver 에서 전송하는 쿼리를 출력.
  - `logger=Slf4JLogger` : Driver에서 쿼리 출력 시 사용할 logger 설정.
  - `maxQuerySizeToLog=999999` : 출력할 쿼리 길이.



## 출처

- [우아한형제들 기술블로그](https://techblog.woowahan.com/2695/)
- [주지민 블로그](https://joojimin.tistory.com/71)
- [Blausee 블로그](https://wwlee94.github.io/category/blog/spring-transactional-precautions/)