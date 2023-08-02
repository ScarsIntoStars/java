package ex09;

import java.util.*;
import java.sql.*;

public class Main {

	public static void main(String[] args) {
		UserDAO udao = new UserDAO(); // DAO가 클래스라 객체로 만들어서 사용가능
		Scanner s = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("\n\n******* 메인메뉴 *****************************");
			System.out.println("-------------------------------------------------");
			System.out.println("1.사용자목록 |2.사용자조회 |3.사용자수정 |4.사용자등록 |5.사용자삭제 |0.종료");
			System.out.println("6.메세지관리 ");
			System.out.println("-------------------------------------------------");
			System.out.print("선택> ");
			String menu = s.nextLine();

			switch (menu) {

			case "0":
				run = false;
				System.out.println("프로그램을 종료합니다.");
				break;

			case "1":
				for (UserVO vo : udao.list()) {
					System.out.printf("%s\t%s\t%s\t%d\n", vo.getId(), vo.getUname(), vo.getPhone(), vo.getPoint());
				}
				System.out.println(udao.list().size() + "명 등록되었습니다.");
				break;

			case "2":
				System.out.print("조회 할 ID > ");
				String id = s.nextLine();
				if (id == "") {
					System.out.println("조회를 종료합니다.");
					break;
				} else {
					UserVO uvo = udao.read(id);
					if (uvo.getUname() == null) {
						System.out.println("존재하지 않는 사용자입니다.");
					} else {
						System.out.println("사용자 이름 : " + uvo.getUname());
						System.out.println("사용자 전화 : " + uvo.getPhone());
						System.out.println("사용자 점수 : " + uvo.getPoint());
					}
				}
				break;

			case "3":
				System.out.print("수정 할 아이디 > ");
				id = s.nextLine();
				if (id == "") {
					System.out.println("수정을 종료합니다.");
				} else {
					UserVO uvo = udao.read(id);
					if (uvo.getUname() == null) {
						System.out.println("사용자가 존재하지 않습니다.");
					} else {
						System.out.println("이름 : " + uvo.getUname() + "> ");
						String uname = s.nextLine();
						if (uname != "")
							uvo.setUname(uname);
						System.out.println("전화 : " + uvo.getPhone() + "> ");
						String phone = s.nextLine();
						if (phone != "")
							uvo.setPhone(phone);
						System.out.println(uvo.toString());

						System.out.print("정말 수정하실래요? (Y/y) ");
						String sel = s.nextLine();
						if (sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
							udao.update(uvo);
							System.out.println("수정이 완료되었습니다.");
						} else {
							System.out.println("수정이 취소되었습니다.");
						}
					}
				}
				break;
			case "4":
				while (true) {
					System.out.print("아이디 > ");
					id = s.nextLine();
					if (id == "") {
						System.out.println("등록을 취소합니다.");
						break;
					} else {
						UserVO uvo = udao.read(id);
						if (uvo.getUname() == null) {
							System.out.print("이름 > ");
							String sname = s.nextLine();
							if (sname == "") {
								System.out.println("이름은 꼭 입력하세요!");
								break;
							} else {
								uvo.setId(id);
								uvo.setUname(sname);
								System.out.print("전화 > ");
								String phone = s.nextLine();
								uvo.setPhone(phone);
								System.out.println(uvo.toString());
								System.out.println("등록하실래요? (Y/y) ");
								String sel = s.nextLine();
								if (sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
									udao.insert(uvo);
									System.out.println("등록완료!");
								} else {
									System.out.println("등록취소 ㅠㅠ");
								}

							}
							break;
						} else {
							System.out.println("사용중인 아이디입니다.");
						}
					}
				}
				break;

			case "5":
				System.out.print("삭제할 아이디 > ");
				id = s.nextLine();
				if (id == "") {
					System.out.println("삭제를 취소합니다.");
					break;
				} else {
					UserVO uvo = udao.read(id);
					if (uvo.getUname() == null) {
						System.out.println("사용자가 존재하지 않습니다.");
					} else {
						System.out.println("사용자 이름 : " + uvo.getUname());
						System.out.print("삭제하십니까? (Y/y) >");
						String sel = s.nextLine();
						if (sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
							try {
								udao.delete(id);
								System.out.println("사용자가 삭제되었습니다ㅠㅠ");
							} catch (Exception e) {
								System.out.println("사용자 삭제 실패했습니다.");
							}
						} else {
							System.out.println("삭제를 취소했습니다.");
						}
					}
				}

				break;

			case "6":
				System.out.print("아이디 > ");
				id=s.nextLine();
				if(id=="") {
					System.out.println("메세지관리를 취소합니다.");
				} else {
					UserVO uvo = udao.read(id);
					if(uvo.getUname()==null) {
						System.out.println("사용자가 존재하지 않습니다.");
					} else {
						Messages.run(uvo);
						
					}
				}
				
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요");
			}// 스위치
		} // 와일
	} // 매인

}// 매인
