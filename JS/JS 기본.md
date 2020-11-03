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

### 따옴표

- ``,"",'' 차이점 : '', "" 는 차이가 없지만, 
  - 억음부호(``)는 String 사이에 개행이 된 경우 처리가 가능하다.(ES6 부터 가능 / IE는 불가: ES5라서)

## Object

- object와 array 차이점 : object는 각 value에 이름을 지정할 수 있음.

- document :  해당 html 자체를 가진 객체.

  - document.getElementById("id 이름");

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
  // console은 객체, log는 function (alert 포함)
  ```

### function 관련

- function return

- object안에 함수 넣기

- 

  ```javascript
  function test(param){
    console.log('test1' + param);  
  };
  test("what", "the") // test1 what 파라미터가 하나만 받음
  
  function sayhello(name, age){
    console.log(`hello ${name} you are ${age} years old`);
      // hello ${name} you are ${age} years old Undefinend 가 나옴.
      // console.log(console.log)형식이 되기 때문.
    return `hello ${name} you are ${age} years old`;
      // 이럴경우 console.log가 하나가 되서 Undefined가 안나옴.
  }
  
  const greet = sayhello("Seol", 28);
  console.log(greet);
  
  const calculator = {   // 객체안에 함수를 정의할 수 있음.
    plus: function(a, b){
      return a + b;
    }
  };
  
  const plus = calculator.plus(5,5)
  console.log(plus);
  ```

## DOM 관련

- DOM(Document Object Model) : xml이나 html 문서에 접근하기 위한 일종의 인터페이스. 이 객체의 모델은 문서 내의 모든 요소를 정의하고 각각의 요소에 접근하는 방법 제공한다. (document 구조 객체라고 보면 됨.)

- DOM 함수

  - console.dir(dom 객체) : 해당 dom 객체의 전반적인 내용들을 볼 수 있음.(getElementById,InnerHTML 등)
    - 객체가 안들어올 경우, 확인 가능

- ```javascript
  const title = document.getElementById("title");
  title.innerHTML="HELLO!";   //내용 조작 가능
  title.style.color="red"; // 스타일 조작 가능
  // console.dir 찾아보고 하면 좋을듯
  document.title = "test"; // document객체로도 변경 가능
  document.querySelector("#select");   // CSS 선택자로 선택가능
  ```

## event handler

- 페이지 이동, 선택, 클릭, 변화, 제출 등 사건을 말함.

- window(DOM 객체).addEventListener("이벤트",리스너 함수);

- ```javascript
  const title = document.getElementById("title");
  
  function handleResize(event){
      console.log(event)
  }
  
  window.addEventListener("resize",handleResize);
  
  function handleClick(){
      title.style.color="#7f8c8d";
  }
  
  title.addEventListener("click",handleClick);
  // click, resize, mouseenter etc
  
  //document.addEventListener(); dom 객체로 scope 설정 가능
  ```

## 기타

- F12 - application - local storage로 이동하면 저장된 변수 및 정보들을 볼 수 있다.

  - ```javascript
    localStorage.setItem(key,value); // 이것으로 변수 설정 가능
    localStorage.getItem(key) //value 값을 가져옴
    //일종의 세션에 저장하는 역할을 할 수 있음.
    ```

```javascript
   clockTitle.innerText = `${hours < 10 ? `0${hours}`:hours}:${
        minutes < 10 ?`0${minutes}` : minutes}:${
        seconds < 10 ?`0${seconds}` : seconds}`;
}	// 삼함연산자 및 텍스트에 변수 붙이기.

```

## 참조사항

- repl : 온라인 IDE 
- [JS 참조문서](https://developer.mozilla.org/ko/)
- [CSS 색상관련](https://flatuicolors.com/)







