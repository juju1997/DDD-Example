# Domain Driven Design Example Project

DDD 패턴을 적용하여 일반적인 1:N 관계를 표현한 API 서비스입니다.<br><br>
<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white"/> 
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
<img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=Gradle&logoColor=white">

<br>

## Architecture
<img width="500" alt="스크린샷 2024-02-14 오후 8 11 13" src="https://github.com/juju1997/DDD-Example/assets/57661869/cbea4420-83a8-42b3-b9b6-c029c4203a06">

<br>

## ERD
<img width="500" alt="스크린샷 2024-02-14 오후 8 11 13" src="https://github.com/juju1997/DDD-Example/assets/57661869/5f967782-fae6-4593-a883-2159277365f4">

<br>

## APIs _/api/v1_
 - **POST** /root
   - RootEntity와 하위에 SubEntity들을 추가한다.
 - **POST** /add-sub
   - SubEntity를 추가한다.
 - **POST** /disable-root
   - RootEntity의 Status를 Enable로 바꾼다.
 - **POST** /disable-sub
   - SubEntity의 Status를 Enable로 바꾼다.
 - **GET** /{rootToken}
   - 특정 RootEntity와 하위의 SubEntity들을 호출한다.

<br>
<br>
