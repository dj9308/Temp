# Procedure

## 장점

- 쿼리문이 보호가 된다 : DB툴을 사용한다면, 저장 프로시저 항목을 볼 수 있고 프로시저를 수정하기 전까지 프로시저 내부의 쿼리를 확인할 수 없다.
- SQL 인젝션 보호 : 악의적인 사용자가 임의의 SQL문을 주입하고 실행되게 하여 데이터베이스가 비정상적인 동작을 하도록 조작하는 행위를 방지.
- 세밀한 권한 제어가 가능하다.
- 네트워크 소요 시간 절감. : 보통 콘솔에서 여러 쿼리문을 실행하면 여러 요청과 응답을 받는 것과 달리, 프로시저는 한번의 요청만 있으면 되기 때문에 수행속도가 빠르다.
- 절차적인 기능 : IF ELSE WHILE 등의 기능을 구현할 수 있다.
- 매개변수에 따라 동적인 쿼리가능 : SQL문을 문자열로 저장할 시 에 동적인 쿼리 생성이 가능하다.

## 단점

- 디버깅이 어렵다. : 수정 후 처리결과를 확인하기 까다로워 디버깅이 어렵다.
- 유지보수가 어렵다. : 디버깅이 어려운 이유와 마찬가지.
- 짧은 쿼리에선 비효율 : 길고 복잡한 쿼리에 사용을 권장한다.

## 예제 (Mysql)

``` mysql
DROP PROCEDURE IF EXISTS check_insert; /* 기존에 프로시저가 존재하면 DROP */
CREATE PROCEDURE `check_insert`(IN in_pk_seq int(11) /* 받아야할 파라미터 */
        , IN in_detail_seq    int(11)
        , IN in_group_num      varchar(32)
        , IN in_company_num      varchar(32)
        , IN in_department_num      varchar(32)
        , IN in_employee_num      varchar(32)
        , IN in_check_time    int(5)
        , IN in_request_date int(10)
        )
BEGIN /* 프로시저 로직 시작 */
    DECLARE over_time int(11); /* DECLARE는 프로시저 안에서 사용할 변수를 생성한다. */
    DECLARE deadline int(10);
    DECLARE exist_same_date int(3);
    DECLARE result varchar(10) default '성공';
 
    SET over_time = 600 /* SET은 존재하는 변수의 값을 바꿔주거나 대입할 수 있다. */   
    SET deadline = 20180305; 
    SET exist_same_date = (SELECT count(requestWorkTime.request_day)
                               FROM request_work_time requestWorkTime
                              WHERE requestWorkTime.group_num = in_group_num
                                AND requestWorkTime.company_num = in_company_num
                                AND requestWorkTime.department_num = in_department_num
                                AND requestWorkTime.employee_num = in_employee_seq
                                AND requestWorkTime.request_date = in_reqeust_date); /* 쿼리의 결과 값도 넣어줄 수 있다. */
   
    
    IF in_check_time > over_time /* IF문과 ELSEIF문은 다음과 같이 사용한다. */
    THEN SET result = '시간초과';  /* 근무한 시간이 600분을 넘겼을 때 */
     
    ELSEIF in_request_date > deadline 
    THEN SET result = '마감'; /* 신청일자가 마감기한을 넘겼을 때 */
    
    ELSEIF exist_same_date != 0
    THEN SET result = '중복';  /* 신청한 날짜가 이미 DB에 있을 때 */
    END IF;
   
    IF result = '성공' THEN /* 이상없을 경우 정상 실행 */
    
     INSERT INTO request_work_time(pk_seq, detail_seq, group_num, company_num, department_num, 
     employee_num, check_time, request_date)
     VALUES (in_pk_seq, in_detail_seq, in_group_num, in_company_num, in_department_num, in_employee_num, in_check_time, in_request_date);
   
    END IF; /* IF문 생성 후 종료시 넣을 것*/
    
    SELECT result; /* 이 프로시저를 실행할 경우 select된 result 값이 리턴된다. */
END;

```

## 키워드

- 프로시저를 사용할 상황 생각하기
  - 쿼리 호출을 많이 할때 쓰는 것이 좋다.
  - 대신 코드변경을 할 상황이 있으면 안좋다.
- 프로시저 생성 틀을 알아두기

[참고 페이지](https://zorba91.tistory.com/29)