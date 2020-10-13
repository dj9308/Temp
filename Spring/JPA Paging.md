# JPA Paging

## 정의

- DB에 저장된 Entity들을 페이지로 나누는 것
- 일정 갯수만큼 분류 후, 분류된 파트 중 특정 부분을 보내주는 것.
- front에서 DB의 데이터를 5개씩 분류해서 두 번째 파트를 요청할 경우,
  backend에서 5개씩 분류하고, 분류된 데이터의 두 번째 파트를 front에게 넘겨줌.

## PageRequest를 이용한 paging 구현

### PageRequest  정의

- 한 페이지의 사이즈, Sorting 방법을 가지고, Repository에 Paging을 요청할 때 사용하는 것.

