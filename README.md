[소개](#소개)  
[프로젝트 설정](#프로젝트-설정) &nbsp;&nbsp;&nbsp; _Profile정보, Server Port변경, 프로파일별 Log 설정 등에 대하여 프로젝트 별 설정과 관련하여 설명_  
[빌드 방법](#프로젝트-빌드-방법) &nbsp;&nbsp;&nbsp; _메이븐 빌드방법에 관련하여 설명_  
[주의 사항](#주의사항)  &nbsp;&nbsp;&nbsp; _프로젝트에 필요한항목에 대하여_ 

# 소개

**추천**, **검수**, **이미지** 서버개발 프로젝트를 위한 공통 프로젝트구조입니다.  
현재 프로젝트에 구성된 스펙은 아래와 같습니다.

- Openjdk8 (java8)   
- Spring Boot 2.0 (Spring Framework 5)  
- Maven 3.6.0 (Build Tool)  
- MyBatis (ORM Framework)

프로젝트 설정 전략
===


<U>프로파일</U>
- local 로컬
- dev
- stage 
- prod

<U>로그</U>  
<업데이트예정>

<U>포트 설정</U>  
포트는 프로파일별 yml(야믈)파일 application-[profile-name].yml (예: application-dev.yml) 에 지정되어있다. 
옵션명 : server.port
```
server.port=8080
```

프로젝트 빌드 방법
===

현재 구성된 공통프로젝트의 경우 **Apache Maven**(이하 메이븐) 빌드 도구를 사용합니다.  
여기서는 빌드를 하는 두가지 방법에 대해서 소개하겠습니다.  

<U>**IDE(통합개발환경) 개발도구를 활용하여 빌드**</U>


**_프로젝트 우클릭 > Run As > Maven build..._** 선택 후  
Edit Configuration 창이 뜨면  Goals 항목에 **_clean package_** 입력합니다.

빌드가 완료되면 target 폴더에 jar 확장자 파일이 생성된것을 확인 할 수 있습니다. 

<span style="color:red">개발도구 및 환경설정에 따라 빌드가 실패 할 수 있으니 [주의사항](#주의사항)을 참고하세요. </span>


<U>**Maven Command 명령어를 활용한 빌드**</U>
 
<span style="color:red">프로젝트 빌드를 하기위해서는 컴퓨터에 메이븐이 설치되어있어야 합니다.</span>   
하지만 스프링부트는 mvnw 라고 하는 maven wrapper를 제공하여 메이븐설치 없이도 빌드가 가능합니다.

```bash
$ cd  [프로젝트 디렉토리] # 스프링 부트가 있는 프로젝트로 이동
$ ./mvnw clean package  # mvnw가 있는지 확인 후 명령어 실행
```

빌드가 완료되면 target 폴더에 jar 확장자 파일이 생성된것을 확인 할 수 있습니다. 

프로젝트 실행 방법
===

빌드가 완료 된 프로젝트에는 실행형 jar 파일(executable jar)이 생성  
실행형 jar 파일을 java명령어로 실행하게 되면 어플리케이션 서버가 구동됩니다.

<span style="color:red">Java 버전은 8 이상이 설치되어 있어야 합니다. </span>

```bash
$ cd [프로젝트경로] # 프로젝트
$ java -version # Java 버전 확인
$ java -jar [jar파일] # executable jar 실행
$ java -jar [jar파일] --server.port=9090 # [옵션]포트지정 실행
$ java -jar [jar파일] --tomcat.ajp.port=9090 # [옵션]톰캣포트지정 실행
 ```
 뒤에 옵션을 추가하면 프로젝트내에 옵션이 지정되어있어도 명령어 옵션의 우선순위가 가장 높다. 

# 주의사항

<업데이트예정>

