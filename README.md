# 구조
<div>	
  <img src="구조.PNG" width="90%"></img>	
</div>	

# 폴더별 설명  
Day1 : Jpa연동 직후  
  -youtube URL : https://youtu.be/SQsH1z5rDFQ  
  -과제 : GitHub 생성하기  

Day2 : MVC기본 구조 구축
  -youtube URL : 
  -과제 : result.jsp에 user_info테이블로부터 취득건수 표시 하기



<hr>

# pom.xml에 dependency추가
```bash
      <dependency>
         <groupId>mysql</groupId>
         <artifactId>mysql-connector-java</artifactId>
         <version>5.1.38</version>
      </dependency>

      <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-jdbc</artifactId>
         <version>3.1.1.RELEASE</version>
      </dependency>
      
      <dependency>
	    <groupId>org.hibernate</groupId>
	    <artifactId>hibernate-core</artifactId>
	    <version>5.4.0.Final</version>
	</dependency>
```

# GitHub생성시 유의점
1. fatal: CRLF would be replaced by LF in ...... 에러 발생시
```bash
git config core.autocrlf true
```  
를 cmd 상태에서 입력한다.

# 마크업 작성예
URL : [링크](https://www.makeareadme.com/)
