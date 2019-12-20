# R 코딩 관련 정리

## package

- rvest : 웹 페이지 스크래핑
- httr : HTTP Connection을 통한 작업을 위한 라이브러리
- XML : R을 통해 XML 문서를 읽고 만드는 패키지
- openssl : 암호화 관련 패키지(.env)
- DBI : db 관련 인터페이스 제공 
- Stringr = 문자열 다루기 및 정규표현식 관련
- RMySQL : R - mysql 연결 관련 패키지

### ENV 관련

- .Renviron 파일 설정 후 
  ID=값 형식으로 저장.

- Sys.getenv("변수"): 해당 변수의 값을 가져오는 함수.  

### 인코딩

-  iconv() : 인코딩 간에 문자형 벡터 변환

  - i 는 international 을 나타냄.

- ```R
  # 
  # localeToCharset()은 현재 인코딩 상황을 나타내주는 함수.
  iconv(x, from="localeToCharset()[1]",to="UTF-8")
  
  ```

- localeToCharset() : 현재 locale이라는 이름의 적합한 코딩을 찾고 그것이 UTF-8일 경우 적합한  1바이트 인코딩을 찾는 것을 목표로 함.

### 크롤링

- html_session() : HTML 브라우저에서 세션을 시뮬레이션하는 함수.

```R
# html_session(url,...)
# ... : 전체 세션에서 사용할 추가 httr 구성
# is.session(x) / x: 세션인지 확인하기 위해 테스트할 객체
pgsession = html_session(base_url)
```

- jump_to(): 새 url로 이동.(상대 또는 절대 url 로 변경 가능)
  - follow_link("상대 url")
  - back()
- 



### mysql

db names 설정시 중복되지 않으려고 쿼리 설정








iconv(~,   localeToCharset(),"utf-8"): 문자열 인코딩 변환
localeToCharset() : 현재 인코딩 형식 반환
str_sub(문자열,시작,끝) : substring

벡터내 특정 포함 여부 확인 연산자 %in%

12-18 오류일지
html 저장시 경고창뜨면서 저장이 안될수도 있다고함 : 한글 인코딩문제
=> <meta charset="UTF-8">

12/19 오류일지
env가 제대로 불러와지지 않음 : .env파일에 줄이 띄워써져 있으면 안되고 설정 후 껏다 켜야함.
files가 insert 되지 않음 : 데이터 집어넣는 순서가 바뀌어서 에러가 남. types => boards => files
인코딩 에러 : 
db insert types interpolate 에러: parent_id =0 이 아닌 그냥 0으로.