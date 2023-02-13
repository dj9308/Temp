# APACHE SSL 설정

1. openssl 라이브러리, mod_ssl 다운로드

2. mod_ssl 컴파일 혹은 .so 파일을 apache2/modules 경로에 복붙

3. apache2/conf에 있는 httpd.conf 설정

   - LoadModule mod_ssl
   - conf/extra/httpd-ssl.conf 주석 해제 혹은 추가 (혹은 httpd conf 파일에 virtualHost 태그 추가)

4. httpd-ssl.conf 설정

   ```properties
   #default port : 443
   <VirtualHost *:8080>
   
   #   General setup for the virtual host
   DocumentRoot "/usr/local/apache2/htdocs"
   # 도메인 설정돼도 localhost 설정 가능.
   ServerName localhost
   ServerAdmin admin@email.com
   
   #tomcat 연동
   JkMount /* node1
   
   ## 설정 부분
   SSLEngine on
   #인증서 파일
   SSLCertificateFile "/usr/local/apache2/conf/인증서.pem(crt)"
   #개인키 파일(비밀번호 입력)
   SSLCertificateKeyFile "/usr/local/apache2/conf/개인키.pem(crt)"
   #체인인증서 파일(비밀번호 입력)
   SSLCertificateChainFile "/usr/local/apache2/conf/체인CA키.pem(crt)"
   #체인인증서 추가 설정(필요시 추가)
   SSLCACertificateFile "/usr/local/apache2/conf/루트CA키.crt"
   
   #fileMatch, Directory(default)
   <FilesMatch "\.(cgi|shtml|phtml|php)$">
       SSLOptions +StdEnvVars
   </FilesMatch>
   <Directory "/usr/local/apache2/cgi-bin">
       SSLOptions +StdEnvVars
   </Directory>
   
   #logs
   CustomLog "/usr/local/apache2/logs/ssl_request_log" \
             "%t %h %{SSL_PROTOCOL}x %{SSL_CIPHER}x \"%r\" %b"
   ErrorLog "/usr/local/apache2/logs/error_log"
   TransferLog "/usr/local/apache2/logs/access_log"
   </VirtualHost>                                  
   
   ```

## 주의 사항 

- 같은 포트 내에서 http->https 리다이렉트는 안된다.

## 출처

[인증서 설치 메뉴얼](https://cert.crosscert.com/wp-content/uploads/2019/02/Apache-SSL-%EC%9D%B8%EC%A6%9D%EC%84%9C-%EC%84%A4%EC%B9%98-%EB%A7%A4%EB%89%B4%EC%96%BC.pdf)