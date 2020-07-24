package main;

import java.util.Scanner;

import dto.UserDTO;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDTO dto = new UserDTO();
		for (;;) {
			try {
				System.out.println("DB 연습");
				System.out.print("이름 입력 > ");
				Scanner sc = new Scanner(System.in);
				String name = sc.next();
				System.out.print("메일 입력 > ");
				String mail = sc.next();
				System.out.println(mail.contains("@"));
				while (mail.contains("@") != true) {
					System.out.print("잘못 입력하셨습니다 다시 입력하세요 > ");
					mail = sc.next();
				}
				System.out.print("비밀번호 입력 > ");
				String pw = sc.next();
				System.out.print("전화번호 입력 > ");
				String mobile = sc.next();
				if (mobile.length() == 13) {
					dto.setMobile(mobile);
				} else {
					String mobile1 = mobile.substring(0, 3);
					String mobile2 = mobile.substring(3, 7);
					String mobile3 = mobile.substring(7, 11);
					mobile = mobile1 + "-" + mobile2 + "-" + mobile3;
					dto.setMobile(mobile);
				}
				dto.setMail(mail);
				dto.setUsername(name);
				dto.setPw(pw);
				String[] id = mail.split("@");
				System.out.println(mobile);
				dto.setId(id[0]);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("잘못입력하심");
			}
		}
		// 전화번호 하이픈 기능 사용
//		String MyMobile = MyUtil.makePhoneNumber(mobile); // 자바 정규식
//		UserDAOImpl ud = new UserDAOImpl();		
//		ud.insert(dto);
//		ud.update(dto);
	}

}
