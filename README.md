# chat-bot-gpt
> chat gpt를 활용한 메일로 면접 질문을 보내주는 서비스입니다   
> 2023.05.13 - 진행중

<br/>

## 서비스 요구사항

- 사용자는 카테고리(`DB, OS, 네트워크, 자료구조`)를 선택할 수 있다
- 사용자는 `입력한 메일`로 `매일 일정 개수`만큼 질문을 받을 수 있다
- 사용자는 이메일 `수신 시간`을 정할 수 있다
- 이메일 전송 시, `답은 없이` 질문만 전송한다

<br/>

## Flow
1. 사용자는 본인의 `메일 주소와, 원하는 수신 시간, 질문 카테고리`를 입력한다  
2. 면접 질문을 `Open AI(Chat GPT)`를 통해 가져온다  
3. 사용자에게 `메일로` 질문을 보낸다   

<br/>

## Stack
- JAVA 17, SpringBoot 2.7.11
- SpringBoot Web, MySQL, Spring Data JPA, Lombok, Spring Cloud Starter
