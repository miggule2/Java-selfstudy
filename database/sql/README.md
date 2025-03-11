# SQL 입문
## 1. SQL이란?
### 정의 
* __데이터베이스에 접근하고 관리하는 standard 언어__

## 2. SQL is standard BUT...
* SQL이 표준이지만, 각기 다른 SQL 언어가 있고 그에 따라 조금씩 다른 점이 존재함.
* 하지만 major한 command( ex. SELECT,UPDATE,DELETE,INSERT) 등을 모두 지원함.

## 3. RDBMS
* __RDBMS = Relational Database Management System__
* RDBMS는 모든 SQL의 기초.
* RDBMS의 데이터들은 ```table```이라는 database object에 저장. ```table```은 ```column & row```로 구성   

 
* __table 예시__
```
CustomerID | FirstName  | LastName | City      | Country | Email                     |
-----------|------------|----------|-----------|---------|---------------------------|
1          | John       | Doe      | New York  | USA     | [이메일 주소 삭제됨]      |
2          | Jane       | Smith    | London    | UK      | [이메일 주소 삭제됨] |
3          | Takeshi    | Tanaka   | Tokyo     | Japan   | [이메일 주소 삭제됨] |
4          | Maria      | Garcia   | Madrid    | Spain   | [이메일 주소 삭제됨]  |
5          | Pierre     | Dubois   | Paris     | France  | [이메일 주소 삭제됨]  |
6          | 김         | 철수       | 서울       | Korea   | [이메일 주소 삭제됨]  |
7          | 이         | 영희       | 부산       | Korea   | [이메일 주소 삭제됨] |
8          | Michael    | Brown    | Toronto   | Canada  | [이메일 주소 삭제됨] |
9          | Alessandro | Rossi    | Rome      | Italy   | [이메일 주소 삭제됨] |
10         | Ingrid     | Müller   | Berlin    | Germany | [이메일 주소 삭제됨] |
```
* __row__ : 각각의 개별 데이터
* __column__ : 특정 필드와 관련된 모든 정보를 포함하는 데이터