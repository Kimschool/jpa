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
# 구성순서

- pom.xml에 dependency추가
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

- com.kimschool.manage.dao패키지
1. persistence접속용 Connection생성  

```java
package com.kimschool.manage.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component
public class Connection {
	
	public EntityManager getConnection() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
		EntityManager em = emf.createEntityManager();
		return em;
	}
}

```

2. LoginDao인터페이스 생성  
인터페이스? 목차(리스트)의 역활
```java
package com.kimschool.manage.dao;

public interface LoginDao {

	public int findUser(String id, String password);

}
```


3. LoginDaoImpl 클래스 생성  
Interface? 목차(리스트)를 구현화하는 클레스
```java
package com.kimschool.manage.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kimschool.manage.entity.User_Info;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	Connection conn;

	EntityManager em;
	
	
	@Override
	public int findUser(String id, String password) {
		em = conn.getConnection();
		List<User_Info> result = em.createNamedQuery("User_Info.findBypassword", User_Info.class).
				setParameter("password", password).
				setParameter("id", id).
				getResultList();
		
		int size = result.size();
		
		return size;
	}

}

```

- com.kimschool.manage.entity패키지
1. User_Info 엔티티 수정
```java
package com.kimschool.manage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
@NamedQuery(
        name = "User_Info.findBypassword",
        query = "select u from User_Info u where u.password = :password and u.id = :id")
public class User_Info {
	
	   private String id;
	   @Id
	   private int no;
	   private String password;
	   private String auth1;
	   private String status;
	   private String reg_date;
	   private String email;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the auth1
	 */
	public String getAuth1() {
		return auth1;
	}
	/**
	 * @param auth1 the auth1 to set
	 */
	public void setAuth1(String auth1) {
		this.auth1 = auth1;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the reg_date
	 */
	public String getReg_date() {
		return reg_date;
	}
	/**
	 * @param reg_date the reg_date to set
	 */
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User_info [id=" + id + ", no=" + no + ", password=" + password + ", auth1=" + auth1 + ", status="
				+ status + ", reg_date=" + reg_date + ", email=" + email + "]";
	}
}


```

- com.kimschool.manage.service패키지
1. LoginService 인터페이스 생성
```java
package com.kimschool.manage.service;

public interface LoginService {
	
	public int checkLogin(String id, String password);

}

```
2. LoginServiceImpe 구현체 생성
```java
package com.kimschool.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimschool.manage.dao.LoginDao;

@Service
public class LoginServiceImpi implements LoginService {
	
	@Autowired
	LoginDao logindao;

	@Override
	public int checkLogin(String id, String password) {
		
		int count = logindao.findUser(id, password);
		
		return count;
	}

}
```
- com.kimschool.manage패키지
1. HomeController 컨트롤러 수정  
```java
package com.kimschool.manage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kimschool.manage.service.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	LoginService loginservice;

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		ModelAndView mv = new ModelAndView("home");

		logger.debug("초기처리");

		return mv;
	}
	
	@RequestMapping(value = "/logincheck")
	public ModelAndView logincheck(String id, String password) {
		
		logger.debug("로그인 체크 처리를 시작합니다.");
		
		ModelAndView mv = new ModelAndView("result");
		
		int count = loginservice.checkLogin(id, password);
		
		mv.addObject("count", count);
		
		return mv;
	}
	
}
```

# GitHub생성시 유의점
1. fatal: CRLF would be replaced by LF in ...... 에러 발생시
```bash
git config core.autocrlf true
```  
를 cmd 상태에서 입력한다.

# 마크업 작성예
URL : [링크](https://www.makeareadme.com/)
