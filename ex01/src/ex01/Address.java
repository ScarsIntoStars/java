package ex01;

import java.util.Scanner;

public class Address {

	public static void run() {
		Student[] students = new Student[5];

		Scanner s = new Scanner(System.in);
		boolean run = true;
		int count = 0;

		while (run) {
			System.out.println("-------------------------------------------");
			System.out.println("1. 주소등록\n2. 주소목록\n3. 주소검색\n4. 주소변경\n0. 종료");
			System.out.println("-------------------------------------------");
			System.out.print("선택 : ");
			String menu = s.nextLine();

			switch (menu) {
			case "0":
				run = false;
				System.out.println("프로그램을 종료합니다");
				break;
			case "1": // 학생등록
				Student student = new Student();
//				System.out.println(student.toString());

				System.out.print("이름 : ");
				student.setSname(s.nextLine());

				student.setSno("2023" + count + 1); // '문자 + 숫자' String이 됐네
				System.out.println("학번 : " + student.getSno());

				System.out.print("주소 : ");
				student.setAddress(s.nextLine());

				students[count] = student;
				count++;

				System.out.println(count + "명 학생등록");
				break;

			case "2": // 학생목록
				for (int i = 0; i < count; i++) {
					Student stu = students[i];
					System.out.println(stu.toString());

				}

				break;
			case "3": // 학생검색

				System.out.print("검색 할 이름 : ");
				String search = s.nextLine();
				boolean find = false;

				for (int i = 0; i < count; i++) {
					Student stu = students[i]; // Student 타입
					if (search.equals(stu.getSname())) {
						System.out.println(stu.toString());
						find = true;
					}
				}
				if (find == false)
					System.out.println(search + "학생이 존재하지 않습니다.");

				break;

			case "4":
				System.out.print("수정 할 이름 : ");
				String update = s.nextLine();

				find = false;
				for (int i = 0; i < count; i++) {
					Student stu = students[i];
					if (update.equals(stu.getSname())) {
						find = true;
						System.out.println("이름 : " + stu.getSname());
						System.out.println("주소 : " + stu.getAddress());

						System.out.print("새로운 주소 입력 : ");
						String newAddress = s.nextLine();

						if (newAddress != "") {
							stu.setAddress(newAddress);
							System.out.println("새로운 주소로 변경되었습니다.");
						}

//						if (newAddress == "") {
//						} else {
//							stu.setAddress(newAddress);
//							System.out.println("새로운 주소로 변경되었습니다.");
//						}

					}
				}
				if (find == false) {
					System.out.println(update + "학생이 존재하지 않습니다.");
				}

				break;

			default:
				System.out.println("메뉴를 다시 선택하세요!");

			} // switch
		} // while
	} // run
} // class
