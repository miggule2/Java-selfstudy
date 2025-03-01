# Servlet and JSP
## day 1 - 웹 서버 프로그래밍
### 1. 정적 웹 페이지와 그 한계
* 초창기 웹이 출현했을 때는 정적(static)인 웹 페이지 만으로 충분했다
* 하지만 __정적 웹 페이지는 내용이 이미 정해져 있기 때문에, 각각 사용자의 요구를 맞출 수가 없음.__

### 2. 웹 서버와 WAS
* ```웹 서버```는 클라이언트의 요청을 받아 __정적인 요소__ (HTML,CSS,JavaScript 파일, 이미지 등)을 제공하는 역할.
* ```WAS```는 웹 서버의 기능을 포함하면서 __동적인 요소__ (데이터베이스 연동 등)를 처리하여 클라이언트에게 제공하는 역할.
* ```웹 서버와 WAS의 관계``` : 일반적으로 웹 서버는 정적인 컨텐츠를 처리, WAS는 동적인 컨텐츠를 처리하도록 구성하여 효율적인 서비스 제공. 웹 서버는 클라이언트의 요청을 받아 정적인 컨텐츠는 즉시 처리, 동적인 컨텐츠 요청은 WAS에게 넘겨 처리하도록 함.

### 3. server APP
* 사용자가 요청한 여러 기능들을 수행 -> 이는 보통 WAS 위에서 실행.

### 4. 웹 기반의 클라이언트/서버 프로그램 예시 과정
1. 클라이언트 (웹 브라우저): 사용자가 웹 브라우저를 통해 웹 사이트에 접속하여 멤버 리스트를 요청합니다.

2. 웹 서버 (Web Server):
* 클라이언트의 요청을 받습니다.
* 정적인 콘텐츠 (HTML, CSS, JavaScript 파일 등)가 있다면 즉시 클라이언트에게 제공합니다.
* 멤버 리스트와 같은 동적인 콘텐츠 요청은 WAS에게 전달합니다. 

3. WAS (Web Application Server):
* 웹 서버로부터 동적인 콘텐츠 요청 (멤버 리스트 요청)을 받습니다.
* 해당 요청을 처리할 서버 앱을 선택합니다.
* 서버 앱을 실행하여 요청을 처리합니다.

4. 서버 앱 (Server Application):
* WAS 환경에서 실행되며, 멤버 리스트를 가져오는 기능을 수행합니다.
* 데이터베이스 또는 다른 저장소에서 멤버 정보를 조회합니다.
* 조회된 멤버 정보를 WAS에게 반환합니다.

6. WAS:
* 서버 앱으로부터 받은 멤버 정보를 클라이언트에게 전달할 수 있는 형태로 가공합니다 (예: JSON, XML 형식).
* 가공된 데이터를 웹 서버에게 전달합니다.

7. 웹 서버:
* WAS로부터 받은 데이터를 클라이언트에게 응답합니다.
* 클라이언트 (웹 브라우저):

* 웹 서버로부터 받은 멤버 리스트 데이터를 화면에 표시합니다.

## 2. 웹 문서 추가해보기
### 1. 테스트 문서 만들고 서비스하기 
1. 먼저 __웹서버__ 와 __WAS__ 기능을 동시에 가지는 __tomcat__ 을 설치.
2. __startup.bat__ 을 실행하여 웹서버 시작.
3. __홈 디렉토리__ (웹사이트의 시작점이자 웹 서버의 기준 폴더)에 문서(nana.txt) 추가.
<img src="./images/nana.png">
<img src="./images/home_directory.png">    
 

4. ```localhost:8080/nana.txt```로 접속하면 홈디렉토리에 있는 ```nana.txt```문서를 웹에서 볼 수 있음.
<img src="./images/web_nana.png">

### 2. context 사이트 추가
* 위의 방법처럼 홈 디렉토리를 기준으로 여러 하위 디렉토리를 만들어 웹 애플리케이션을 관리할 수도 있지만, 그렇게 하게되면 __개발의 불편함과 너무 규모가 커지는 문제__ 등의 문제들이 발생한다.
* 그래서 웹 서버에서는 __context를 나누어 규모가 커지는 웹 애플리케이션을 효율적으로 관리__ 함.
* __Context 분리의 추가적인 장점__
  * __애플리케이션 격리__: 각 Context는 독립적으로 실행되어 서로 영향을 주지 않음. 하나의 Context에 문제가 발생해도 다른 Context는 정상적으로 작동할 수 있음.
  * __모듈화 및 관리 용이성__: 대규모 웹 애플리케이션을 기능별, 모듈별로 Context로 분리하여 개발 및 관리를 효율적으로 할 수 있음.
  * __재배포 용이성__: 특정 Context만 수정하거나 재배포해야 할 경우, 전체 서버를 재시작할 필요 없이 해당 Context만 재배포하면 됨.

### 3. Annotation을 이용한 URL 매핑
```java
@WebServlet("/hello")
```
* 서블릿 3.0으로 업데이트 되면서 위와 같은 ```어노테이션```으로 저번에 배웠던 ```web.xml```에다가 직접 매핑 정보를 적는 방법을 대체할 수 있다.

```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         ...
  metadata-complete="false">
```
* 어노테이션으로 URL 매핑을 진행하려면 ```web.xml```파일의 ```metadata-complete``` 값을 ```false```로 변경해줘야 한다.
* 위의 설정을 통해 __web.xml외에 어노테이션 기반의 매핑도 사용하겠다는 의미__ 이다.

### 4. 컨텐츠 출력 형식 지정하기
### MIME 타입 명시
```java
@WebServlet("/hello")
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = resp.getWriter();
		for(int i = 0; i < 100; i++) {
			out.println((i+1) + ": 안녕 Servlet!<br >");
		}
	}
}
```
* 위의 코드를 작성하여 웹 브라우저에서 열면 그 결과
    * __chrome 브라우저___
    ```
    1 : hello Servlet!<br >
    2: hello Servlet!<br >
    3: hello Servlet!<br >
    4: hello Servlet!<br >
    5: hello Servlet!<br >
    6: hello Servlet!<br >
    7: hello Servlet!<br >
    8: hello Servlet!<br >
    ...
    ```
    * __다른 브라우저__
    ```
    1: hello Servlet!
    2: hello Servlet!
    3: hello Servlet!
    4: hello Servlet!
    5: hello Servlet!
    6: hello Servlet!
    7: hello Servlet!
    8: hello Servlet!
    ...
    ```
* 위와 같은 결과가 나오는 이유는 웹서버에서 브라우저로 위 문서를 보낼 떄, __```MIME 타입```을 지정하지 않아, 브라우저마다 자의적인 해석을 하기 떄문이다__
* ```MIME 타입```은 __인터넷을 통해 전송되는 파일의 종류를 나타내는 표준 형식__ 을 뜻함. 
* 위의 문제를 해결하기 위해, servlet 파일 작성시, ```MIME 타입```을 명시해줘야 한다.

### 한글 출력하기
```java
public class Nana extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        for(int i = 0; i < 100; i++) {
            out.println((i+1) + ": 안녕 Servlet!<br >");
        }
    }
}
```
* 위의 코드를 작성하여 웹 브라우저에서 열면 그 결과
```
1: ?? Servlet!
2: ?? Servlet!
3: ?? Servlet!
4: ?? Servlet!
5: ?? Servlet!
6: ?? Servlet!
7: ?? Servlet!
8: ?? Servlet!
9: ?? Servlet!
...
```
* 다음과 같은 결과를 얻을 수 있다   
 

* 위와 같은 결과가 나온 이유
1. __웹서버에서 한글을 지원하지 않는 문자코드로 인코딩한 경우__
2. __서버에서는 ```UTF-8```로 인코딩해서 보냈지만 브라우저에서 다른 코드로 잘못 해석한 경우__
* 이를 해결하기 위해 다음의 코드를 추가해주면 된다,
    ```java
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=UTF-8");
    ```
* 위의 코드를 추가하면 __웹서버에서 ```UTF-8```로 인코딩해서 브라우저로 보내고, 브라우저에서 ```UTF-8```로 디코딩하게 된다.

### 한글과 MIME 타입을 지정한 올바른 코드
```java
@WebServlet("/hello")
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8"); // 응답 데이터의 문자 인코딩 설정 (UTF-8)
		resp.setContentType("text/html; charset=UTF-8"); // 응답 데이터의 MIME 타입 및 문자 인코딩 설정 (HTML, UTF-8)
		
		PrintWriter out = resp.getWriter();
		for(int i = 0; i < 100; i++) {
			out.println((i+1) + ": 안녕 Servlet!<br >");
		}
	}
}
```
* 결과
```
1: 안녕 Servlet!
2: 안녕 Servlet!
3: 안녕 Servlet!
4: 안녕 Servlet!
5: 안녕 Servlet!
6: 안녕 Servlet!
7: 안녕 Servlet!
8: 안녕 Servlet!
9: 안녕 Servlet!
...
```