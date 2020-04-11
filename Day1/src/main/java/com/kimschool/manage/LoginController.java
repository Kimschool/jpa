package com.kimschool.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kimschool.manage.entity.User_Info;
import com.kimschool.manage.service.UserInfoService;

@Controller
public class LoginController {

	@Autowired
	DataSource ds;

	@Autowired
	UserInfoService service;

//	@RequestMapping("jpa")
//	public String jjpa() throws ClassNotFoundException, SQLException {
//        List<UserInfo> userInfoList = service.findAll();
////        model.addAttribute("guestbookList", guestbookList);
//        System.out.println(userInfoList);
//        return "index";
//	}

	@RequestMapping("login")
	public ModelAndView login() throws ClassNotFoundException, SQLException {

		Connection conn;
		PreparedStatement ps;
		ResultSet rs;

		conn = ds.getConnection();

		// DB����

		System.out.println(conn);
		// SQL ����
		String sql = "select now()";

		// DB�� ������ SQL�� �غ�
		ps = conn.prepareStatement(sql);

		// SQL ���� �� ������� rs�ݳ�
		rs = ps.executeQuery();

		// rs�κ��� ��氪 ���
		while(rs.next()) {
			// rs�κ��� �ð��� ���
			String time = rs.getString("now()");
			// ��氪 ���
			System.out.println(time);
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");

		return mv;
	}

	@RequestMapping("login1")
	public ModelAndView login1() throws ClassNotFoundException, SQLException {

		Connection conn;
		PreparedStatement ps;
		ResultSet rs;

		String url = "jdbc:mysql://localhost:3306/pre_management";
		String id = "root";
		String password = "kimschool1";
		Class.forName("com.mysql.jdbc.Driver");

		// DB����
		conn = DriverManager.getConnection(url, id, password);


		System.out.println(conn);
		// SQL ����
		String sql = "select now()";

		// DB�� ������ SQL�� �غ�
		ps = conn.prepareStatement(sql);

		// SQL ���� �� ������� rs�ݳ�
		rs = ps.executeQuery();

		// rs�κ��� ��氪 ���
		while(rs.next()) {
			// rs�κ��� �ð��� ���
			String time = rs.getString("now()");
			// ��氪 ���
			System.out.println(time);
		}


		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");

		return mv;
	}

}
