package main;

import java.util.Scanner;

import dao.UserDAOImpl;
import dto.UserDTO;
import utll.MyUtil;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDTO dto = new UserDTO();
		System.out.println("DB 연습");
		System.out.print("이름 입력 > ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.print("메일 입력 > ");
		String mail = sc.next();
		System.out.print("비밀번호 입력 > ");
		String pw = sc.next();
		System.out.print("전화번호 입력 > ");
		String mobile = sc.next();
		// 전화번호 하이픈 기능 사용
//		String MyMobile = MyUtil.makePhoneNumber(mobile); // 자바 정규식
		dto.setUsername(name);
		dto.setMail(mail);
		dto.setPw(pw);
		
		if (mobile.length() == 13) {
			dto.setMobile(mobile);
		}else {
			String mobile1 = mobile.substring(0,3);
			String mobile2 = mobile.substring(3,7);
			String mobile3 = mobile.substring(7,11);
			mobile = mobile1 + "-" + mobile2 + "-" + mobile3;
			dto.setMobile(mobile);
		}
		String[] id = mail.split("@");
		dto.setId(id[0]);
		UserDAOImpl ud = new UserDAOImpl();		
		ud.insert(dto);
		ud.update(dto);
	}

}
