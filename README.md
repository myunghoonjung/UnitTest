# UnitTest

# API 테스트 프로젝트 (ApiTest)

## 프로젝트 설명
JSONPlaceholder의 무료 API를 사용하여 데이터를 가져오고, 이를 JUnit과 Hamcrest를 사용하여 테스트합니다.
만약 org.hamcrest.CoreMatchers import 에러가 나시는분들은 Class Path에 JUnit5(4버전도 무방함)을 추가하도록 합니다.

---

## 주요 기능
1. JSONPlaceholder API를 호출하여 게시물 데이터를 가져옴.
2. 테스트를 통해 데이터의 유효성을 검증:
   - **posts가 null이 아닌지 확인**
   - **리스트 크기가 0보다 큰지 확인**
   - **첫 번째 게시물이 title 키를 포함하는지 확인**
3. 반대 조건도 검증:
   - **posts가 null인지 확인**
   - **리스트 크기가 0보다 작거나 같은지 확인**
   - **첫 번째 게시물이 title 키를 포함하지 않는지 확인**

---

## API 정보
- **API URL**: `https://jsonplaceholder.typicode.com/posts`
- 샘플 응답 데이터:
  ```json
  [
    {
      "userId": 1,
      "id": 1,
      "title": "Sample Title",
      "body": "Sample Body"
    }
  ]
