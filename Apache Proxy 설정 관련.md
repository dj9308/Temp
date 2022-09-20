# Apache Proxy 설정 관련

---

## 환경

![servers badge](https://img.shields.io/badge/Servers-Apache-yellow)![servers badge](https://img.shields.io/badge/OS-Linux(CentOS)-green)

---

## Index

1. Proxy 정의 및 특징
2. Proxy 종류(Forward Proxy Reverse Proxy)
3. Apache Reverse Proxy 설정
4. 설정 중 오류 및 해결 과정

---

### 1. Proxy 정의 및 특징

![11. 프록시 (Proxy)](https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F99C0DB3A5D2164970E)

- 서버와 클라이언트 사이에 중계기로서 대리로 통신을 수행하는 것을 가리켜 '프록시', 그 중계 기능을 하는 것을 프록시 서버라고 부른다.
- Proxy를 사용하는 목적은 다음과 같다.
  1. 익명성과 우회접근
     서비스 형태로 제공하는 Proxy가 주로 이 범주에 속하며, IP를 숨겨 보안상 이점을 가지는 것이 주 목적이다. 요청을 대신 수행해주는 프록시 서버를 통해 우회하여 서버에 접근이 가능하다.
  2. Cache를 이용한 데이터 전송시간 절약
     프록시는 프록시 서버에 요청이 된 내용들을 캐시를 이용해 저장해두고, 캐시로 저장해두면 다시 데이터를 가져올 상황이 발생 하지 않기 때문에 
     전송시간을 절약 할 수 있게 된다.
  3. 병목 현상 방지
     불필요한 외부와의 연결을 안하기 때문에 외부와의 트래픽을 감소시켜 병목 현상을 방지하는 효과를 가질 수 있다.



### 2. Proxy 종류

#### Forward Proxy

![img](https://github.com/ParkJiwoon/PrivateStudy/raw/master/images/forward-proxy.png)

- 일반적인 프록시 서버를 말하며, 요청하는 Client 와 Server 사이에 위치하여 중간에서 요청을 중계한다. 
- 클라이언트(사용자)가 인터넷에 직접 접근하는 것이 아니라 프록시 서버가 요청을 받고 인터넷에 연결하여 결과를 클라이언트에 전달(forward) 해준다.

#### Reverse Proxy

![img](https://github.com/ParkJiwoon/PrivateStudy/raw/master/images/reverse-proxy.png)

- 클라이언트가 인터넷에 데이터를 요청하면 리버스 프록시가 이 요청을 받아 내부 서버에서 데이터를 받은 후 클라이언트에 전달한다.
- 클라이언트는 내부 서버에 대한 정보를 알 필요 없이 리버스 프록시에만 요청하면 된다.
- 내부 서버에 대한 설정으로 로드 밸런싱(Load Balancing, 부하 분산)이나 서버 확장 등에 유리하다.
- URL에 프록시 서버의 주소가 표현되기 때문에, 실제 서버가 누구인지 감추는 역할을 한다.



### 3. Apache Reverse Proxy 설정

- 목적 : 기존 3개의 URL을 Reverse Proxy를 설정하여 정해진 URL로 HTTP Request 및 Response 수행.(Parameter 변경 가능해야 함.)
  - http://sansatai.forest.go.kr/lsapi/openapi/rainIssueList.xml?apikey=83b047ce111bbeaa&pageno=1 을
    0.0.0.0/openapi/ldm/rainIssueList.xml?pageno=1 로 변경
  - http://map.forest.go.kr/portalo/openAPI/todayFire.do 을 
    0.0.0.0/openapi/ffas/todayFire.do 로 변경
  - http://sansatai.forest.go.kr/gis1/ldmout/iserver/services/data-HazardParam2019/rest/data/datasources/HazardParam2019/datasets/hazard2019/gridValue.json 을
    0.0.0.0/openapi/ldm/gridValue.json 로 변경

- 과정

  1. CentOS에 Apache 설치(과정 생략)
  2. Apache 설치 폴더(conf 폴더)의 httpd.conf에 다음의 코드를 추가.
     - httpd.conf 파일은 apache 설정 파일이며, 아래의 코드는 http-vhost.conf 파일을 읽어 온다는 코드이다.

  ```
  Include conf/http-vhost.conf
  ```

  3. httpd.conf 파일이 존재하는 폴더(conf 폴더)에 http-vhost.conf 파일을 생성 후 아래의 코드를 입력.

```
## NameVirtualHost, VirtualHost : 가상 호스트 설정 부분. 한 컴퓨터에서 여러 서버를 동작시키기 위해서 가상호스트(Virtual Host)를 사용해야 한다.
## 이름기반 가상호스트를 사용한다면, * 대신 이름기반 가상호스트에 사용할 IP 주소를 사용해야 한다.
## Port는 httpd.conf 파일에 설정된 Port와 같아야 한다.
NameVirtualHost *:8000

<VirtualHost *:8000>

   ## ServerName이 없다면 웹서버를 실행하는 컴퓨터의 호스트명을 대신 사용한다.
   ServerName localhost
   
   ## log 설정 부분. 자세한 것은 https://httpd.apache.org/docs/2.4/logs.html 참조
   ErrorLog "logs/proxy-error.log"
   LogFormat "%h %l %u %t \"%r\" %>s %b \"%{Referer}i\" \"%{User-agent}i\"" combined
   CustomLog "logs/proxy-access.log" combined

   ## Proxy 설정 부분
   ## ProxyRequests : 프록시 서비스의 활성화 여부를 지정. ProxyRequests가 off로 설정되어도 ProxyPass는 유효하다.
   ## ProxyPreserveHost : Proxy 타입 설정 부분. On일 경우 Reverse Proxy, Off일 경우 Forward Proxy이다.
   ProxyRequests Off
   ProxyPreserveHost On
   
   ## Parameter 변경 가능하게 하기 위한 URL 규칙 설정 부분
   ## On으로 해야 RewriteRule 코드가 정상 작동한다.
   RewriteEngine On

   ## Location : URL별 설정 태그
   <Location "/openapi/ldm/rainIssueList.xml">
   
     ## Parameter 변경 가능하게 하기 위한 URL 고정값 설정 부분
     ## 아래 RewriteRule의 코드는 sansatai.forest.go.kr/lsapi/openapi/rainIssueList.xml?apikey=83b047ce111bbeaa로 리다이렉트 한다는 뜻.
     RewriteRule ^(.*)$ http://sansatai.forest.go.kr/lsapi/openapi/rainIssueList.xml?apikey=83b047ce111bbeaa [QSA,P]
     
     ## HTTP Header 요소 중 Host 설정 부분
     RequestHeader set Host sansatai.forest.go.kr
     
     ## Apache가 서비스할 파일의 위치를 찾는 부분
     ## ProxyPass : 서버가 적절한 문서를 가져오도록 설정한다.
     ## ProxyPassReverse : ProxyPass의 URL이 보내는 리다이렉션을 재작성하여 리다이렉션이 현재 서버의 적절한 디렉토리를 가리키도록 한다.
     ProxyPass http://sansatai.forest.go.kr/lsapi/openapi/rainIssueList.xml
     ProxyPassReverse http://sansatai.forest.go.kr/lsapi/openapi/rainIssueList.xml
   </Location>

   <Location "/openapi/ffas/todayFire.do">
     RewriteRule ^(.*)$ http://map.forest.go.kr/portalo/openAPI/todayFire.do [QSA,P]
     RequestHeader set Host map.forest.go.kr
     ProxyPass http://map.forest.go.kr/portalo/openAPI/todayFire.do
     ProxyPassReverse http://map.forest.go.kr/portalo/openAPI/todayFire.do
   </Location>

   <Location "/openapi/ldm/gridValue.json">
     RewriteRule ^(.*)$ http://sansatai.forest.go.kr/gis1/ldmout/iserver/services/data-HazardParam2019/rest/data/datasources/HazardParam2019/datasets/hazard2019/gridValue.json [QSA,P]
     RequestHeader set Host sansatai.forest.go.kr
     ProxyPass http://sansatai.forest.go.kr
     ProxyPassReverse http://sansatai.forest.go.kr
   </Location>

 </VirtualHost>
```

4. Apache 재실행.



### 4. 설정 중 오류 및 해결 과정

1. Reverse Proxy 설정 및 재실행 후, URL 주소 입력 결과, 403 forbidden 발생.

   - Postman 프로그램을 이용해 문제 확인.

   - 확인 결과, http Header 요소 중 Host를 체크 해제 후 Request 해보니, 403 forbidden 발생.
     ![error](C:\Users\dj930\Desktop\error.png)

   -  해당 코드 추가 후 문제 해결.

     ```
     RequestHeader set Host sansatai.forest.go.kr
     ```

   - 각 변경된 URL마다 Host set 적용.

**네트워크 관련 이슈가 있을 경우,  Postman을 이용해보자**





#### 참고 페이지

- [프록시 정의 - 위키백과](https://ko.wikipedia.org/wiki/%ED%94%84%EB%A1%9D%EC%8B%9C_%EC%84%9C%EB%B2%84)
- [프록시 서버 정의 및 설명](https://jins-dev.tistory.com/entry/%ED%94%84%EB%A1%9D%EC%8B%9CProxy-%EC%84%9C%EB%B2%84%EC%9D%98-%EC%A0%95%EC%9D%98%EC%99%80-%EC%A2%85%EB%A5%98%EC%97%90-%EB%8C%80%ED%95%98%EC%97%AC)
- [httpd.conf 설정 관련 - 생활코딩](https://opentutorials.org/course/3647/23838)
- [가상 호스트 관련](https://httpd.apache.org/docs/2.4/ko/vhosts/details.html)
- [Log 관련](https://httpd.apache.org/docs/2.4/logs.html)
- [RewriteRule 정규식 관련](https://httpd.apache.org/docs/2.2/ko/misc/rewriteguide.html)

