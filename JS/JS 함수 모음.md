# JS 함수 모음

- setInterval(함수이름, 시간(milisecond))  : 시간에 맞춰 함수 실행

  - ```javascript
    getTime();   // 함수를 실행한다고 선언해야 setInterval이 돌아감.
    setInterval(getTime,1000);	// 이름만 참조하는 것이기 때문에, ()는 붙이지 않음
    ```

- 변수.classList.add(remove) : 클래스 값 추가 제거

- localStorage.setItem(key, value); 로컬 스토리지에 정보 넣기

- localStorage.getItem(key) : 로컬 스토리지에 있는 정보 가져오기