# JS

## JS

- 객체기반 스크립트 프로그래밍 언어.
  - 스크립트 언어 : 특정한 응용프로그램 안에서만 작동하는 언어.
  - js의 경우, 웹 브라우저에서만 실행 가능하다.
- 웹 브라우저 내에서 주로 사용하며, 다른 응용 프로그램의 내장 객체에도 접근할 수 있는 기능을 가지고 있다.
- Node.js와 같은 런타임 환경과 같이 서버 프로그래밍에서도 사용된다.

## ES5

- ECMAScript 5의 약자
  - ECMAScript : 일종의 Specification(사용 설명서)

## Vanilla JS

- library가 없는 JS

## 기본

### 데이터타입

- var : function scope 
  - function에서 선언되면 function이 끝날시 없어짐.
  - 변수 재선언 가능
- let :blocked scope
  - 변수 재선언 불가능
- const : blocked scope
  - 상수 

## 알게된 것

- object와 array 차이점 : object는 각 value에 이름을 지정할 수 있음.

- 

  ```javascript
  const test = {
      name:"MiMe",
      age:28,
      gender:"Male",
      isHandsome:true,
      favFood: [
          {
              name:"kimchi",
              fatty:false
          },
          {
              name:"burger",
              fatty:true
          } // 객체 속 객체
      ]
  } //객체
  console.log(test.favFood[0].name);
  ```

- 