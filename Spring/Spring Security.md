# Spring Security

## 정의 및 특징

---

- Spring 기반의 어플리케이션의 인증과 권한을 담당하는 프레임워크.
- 매 요청마다 올바른 권한을 가진 사용자가 인증 절차를 확인하였는지 대한 검증을 해준다.
- filter 기반으로 동작하며, Dispatcher Servlet으로 가기 전에 먼저 적용되어 가장 먼저 URL 요청을 받는다.
  (Dispatcher와 Controller 사이에 위치한 Interceptor 개념과는 조금 다르다.)

### 보안 관련 용어

- 접근 주체(Principal) : 보호된 대상에 접근하는 사용자
- 인증(Authenticate) : 현재 사용자가 본인이 맞는지 확인하는 절차(ex: 로그인)
- 인가(Authorize) : 인증된 사용자가 요청한 자원에 접근 가능한지 결정하는 절차



## 인증 Architecture 및 Module

---

### 구조

![img](https://t1.daumcdn.net/cfile/tistory/99A7223C5B6B29F003)

### Logic에 따른 Module

#### 1.Filter - Http Request 수신

- 수신된 Request 메세지는 인증 방식에 따라 알맞은 Filter들(Filter chain)을 통하게 된다.
  - ex): HTTP 기본 인증 시 BasicAuthenticationFilter 통과.
  - 로그인 폼에 의한 인증 시 UserPasswordAuthenticationFilter 통과.
  - HTTP Digest 인증 시, DigestAuthenticationFilter 통과.
  - x509 인증 시, X509AuthenticationFilter 통과 등.

#### 2. UsernamePasswordAuthenticationToken

- Authentication을 Implements한 AbstractAuthentication의 하위 Class이다.

- User의 ID가 Principal 역할을 하고, Password가 Credential의 역할을 한다.

- UsernamePasswordAuthenticationToken의 첫 번째 생성자는 인증 전의 객체를 생성하고, 두 번째 생성자는 인증이 완료된 객체를 생성한다.

- ```java
  public class UsernamePasswordAuthenticationToken extends AbstractAuthenticationToken {
      private static final long serialVersionUID = 600L;
      //사용자 ID(Username)
      private final Object principal;
      //사용자 password(Username)
      private Object credentials;
  	//인증 완료 전의 객체 생성
      public UsernamePasswordAuthenticationToken(Object principal, Object credentials) {
          super((Collection)null);
          this.principal = principal;
          this.credentials = credentials;
          this.setAuthenticated(false);
      }
  	//인증 완료 후의 객체 생성
      public UsernamePasswordAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
          super(authorities);
          this.principal = principal;
          this.credentials = credentials;
          super.setAuthenticated(true);
      }
      //이하 생략
  ```

#### 3. AuthenticationManager(ProviderManager)

- 인증에 대한 부분은 AuthenticationManager를 통해 처리하나, 실질적으로는 AuthenticationManager에 등록된 AuthenticationProvider에 의해 처리된다.(Provider에게 인증하라고 명령)

- 인증에 성공하면 두 번째 생성자를 이용해 인증이 성공한 객체를 생성하여 Filter를 거쳐 SecurityContext에 저장한다.

- ```java
  public class ProviderManager implements AuthenticationManager, MessageSourceAware, InitializingBean {
      public Authentication authenticate(Authentication authentication) throws AuthenticationException {
          //내용 생략...
          try {
              //해당 코드로 authentication을 가지고 Provider에 인증 요청.
  	        result = provider.authenticate(authentication);
      }
  }
      
  ```

- AuthenticationManager를 Implement한 ProviderManager는 실제 인증 과정에 대한 로직을 가지고 있는 AuthenticationProvider를 List로 가지고 있다.

- ProviderManager는 loop를 통해 모든 Provider를 조회하면서 Authenticate 처리를 한다.

#### 4. AuthenticationProvider

- 실제 인증에 대한 부분을 처리하며, 인증 전의 Authentication 객체를 받아서 인증이 완료된 객체를 반환하는 역할을 한다.

- ```java
  public class DaoAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
      	//사용자 정보 & 권한 조회
          protected final UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
          this.prepareTimingAttackProtection();
          try {
              UserDetails loadedUser = this.getUserDetailsService().loadUserByUsername(username);
          }
          //내용 생략	
  }
      
  public abstract class AbstractUserDetailsAuthenticationProvider implements AuthenticationProvider, InitializingBean, MessageSourceAware {
      //인증 절차 진행
  	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
          //내용 생략
      }
  }
              
  ```

#### 5. UserDetailsService

- UserDeatilsService는 loadUserByUsername Method를 이용하여 DB에서 사용자 정보 및 권한 조회 및 반환하여 인증할 수 있도록 한다.

- 주로 service 부분에 implement를 하여 사용한다.

- ```java
  public interface LoginService extends UserDetailsService {}
  
  @Service("LoginService")
  public class LoginServiceImpl implements LoginService {
      @Override
      public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
          // DB에서 사용자 정보 & 권한 조회
          User userinfo = userRepository.findByUserId(userId);
          if(userinfo.getChiefYn().toString().equals("Y")){
              roles.add("CHIEF");
          }
          if(userinfo.getUserAddInfo().getAdminYn().equals("Y")){
              roles.add("ADMIN");
          }
  		
          //DB 조회 후, UserDetail 객체를 만들어 데이터를 넣고 반환한다.
          return org.springframework.security.core.userdetails.User.builder()
                  .username(userId)
                  .password(userinfo.getUserAddInfo().getUserPasswd())
                  .roles(roles.toArray(new String[0])).build();
      }
  }
  ```

#### 6. UserDetails

- 인증에 성공하여 생성된 UserDetails는 Authentication 객체를 구현한 UsernamePasswordAuthenticationToken을 생성하기 위해 사용된다.

- UserDetails를 Implements 하여 아래의 정보를 가져올 수 있다.

- ```java
  public interface UserDetails extends Serializable {
      Collection<? extends GrantedAuthority> getAuthorities();
      String getPassword();
      String getUsername();
      boolean isAccountNotExpried();   
      boolean isAccountNonLocked();    
      boolean isCrendentailsNotExpired();    
      boolean isEnabled();
  }
  ```



### 그 외 Module

#### SpringContextHolder(SecurityContextHolder)

- 보안 주체의 세부 정보를 포함하여 응용프로그램의 현재 보안 Context에 대한 세부 정보가 저장된다.

- SpringContextHolder 내부의 Authenticaiton에 접근해 사용자 정보를 가져올 수 있다.

  ```java
  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
  ```

#### SecurityContext

- Authentication을 보관하는 역할을 하며, SecurityContext를 통해 Authenticaiton 객체를 가져올 수 있다.

#### Authentication

- 현재 접근하는 주체(Principal)의 정보와 권한을 담은 인터페이스이다.
- SecurityContextHolder를 통해 SecurityContext에 접근하고, SecurityContext를 통해 Authentication에 접근할 수 있다.

#### PasswordEncoding

- AuthenticationManagerBuilder.userDetailsService().passwordEncoder()를 통해 패스워드 암호화에 사용될 PasswordEncoder 구현체를 지정할 수 있다.

```java
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
}
//아래처럼 bean으로 등록한 후, @autowired 매핑하여 사용할 수 있다.
@Bean
public PasswordEncoder passwordEncoder(){
	return new BCryptPasswordEncoder();
}
```

#### GrantedAuthority

- 현재 사용자(Principal)가 가지고 있는 권한을 의미한다.
-  ROLE_ADMIN이나 ROLE_USER와 같이 ROLE_*의 형태로 사용하며, 보통 "roles"라고 한다.
- GrantedAuthority 객체는 UserDetailsService에 의해 불러올 수 있고, 특정 자원에 대한 권한이 있는지를 검사하여 접근 허용 여부를 결정한다.

## 기본 API & Filter 이해

---

### 처리 절차

- 서블릿 filter와 이들로 구성된 filter chain으로의 위임 모델을 사용한다.
- 서블릿 filter는 사용자 요청을 가로채서 전처리 하거나 서버의 응답을 가로채서 후처리 할 수 있다
  ![img](https://t1.daumcdn.net/cfile/tistory/16399D424F97697E32)



### Filter Chain

- Spring Security namespace가 제공하는 http 엘리먼트의 auto-config attribute를 사용하면 Spring Security는 일련의 filter chain을 구성한다.
  ![img](https://t1.daumcdn.net/cfile/tistory/144E8D474F976A3F1D)
- 주요 filter
  - SecurityContextPersistenceFilter
    - SecurityContextRepository에서 SecurityContext를 로딩하거나, SecurityContextRepository으로 SecurityContext를 저장하는 역할을 한다.
    - SecurityContext 란 사용자의 보호 및 인증된 세션을 의미한다.
  - LogoutFilter
    - 로그아웃 URL(default : /j_spring_security_logout)으로 요청을 감시하여 해당 사용자를 로그아웃 시킨다.

## 관련 Method 설명

#### Config

- @EnableWebSecurity : Security 활성화 Annotation
- @Configuration : 해당 config Class를 Bean에 등록하게 해주는 Configuration Class로 선언하는 Annotation 
- csrf().disable() : csrf 인증 토큰 확인 안 하도록 설정.(보안 상 필요할 수 있으나, HTTP 특성 상 서버에 인증 정보를 보관하지 않아서 할 필요X)


## 출처

- [빨간색코딩](https://sjh836.tistory.com/165)
- [Rednics Blog](https://springsource.tistory.com/80)
- [네로개발일기](https://frogand.tistory.com/188)
- 

