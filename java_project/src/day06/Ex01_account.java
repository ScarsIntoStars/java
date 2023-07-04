package day06;

import java.util.Scanner;

public class Ex01_account {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] name = new String[10];
		String[] account = new String[10];
		int[] balance = new int[10];
		int cnt = 0;

		while (true) {
			System.out.println("=====은행=====");
			System.out.println("1.계좌생성 \n2.입금 \n3.출금 \n4.이체 \n5.계좌목록 \n0.종료");
			System.out.print("선택> ");
			int menu = sc.nextInt();

			if (menu == 1) {
				System.out.println("---계좌생성---");
				System.out.print("이름 : ");
				name[cnt] = sc.next();
				System.out.print("계좌번호 : ");
				account[cnt] = sc.next();
				System.out.print("초기입금금액 : ");
				balance[cnt] = sc.nextInt();
				cnt++;

			} else if (menu == 2) { // 입금
				System.out.println("---입금---");
				System.out.print("입금 계좌번호 : ");
				String inAccount = sc.next();
				System.out.print("입금 금액 : ");
				int inMoney = sc.nextInt();
				boolean find = false;

				for (int i = 0; i < cnt; i++) {
					if (account[i].equals(inAccount)) {
						balance[i] += inMoney;
						System.out.println(inMoney + "원 입금 완료");
//						System.out.println("[%,d원] 입금완료", inMoney);
						find = true;
						break;
					}
				}
				if (!find) {
					System.out.println("계좌없음");
				}

			} else if (menu == 4) { // 목록
				System.out.println("예금주\t계좌번호\t잔액");
				System.out.println("========================");
				for (int i = 0; i < cnt; i++) {
					System.out.printf("%s\t%s\t%,d\n", name[i], account[i], balance[i]);
				}

			} else if (menu == 3) { // 출금
				System.out.println("---출금---");
				System.out.print("출금 계좌번호 : ");
				String outAccount = sc.next();
				System.out.print("출금 금액 : ");
				int outMoney = sc.nextInt();
				boolean findd = false;

				for (int i = 0; i < cnt; i++) {
					if (account[i].equals(outAccount)) {
						if (outMoney > balance[i]) {
							System.out.println("잔액부족");
						} else {
							balance[i] -= outMoney;
							System.out.printf("[%,d원]출금완료", outMoney);
						}
						findd = true;
						break;
					}
				}
				if (!findd) {
					System.out.println("계좌없음");
				}

			} else if (menu == 4) { // 이체

			}

			else if (menu == 0) { // 종료
				System.out.println("종료합니다.");
				break;

			} else

			{
				System.out.println("0~3을 입력하시오");
			}
			System.out.println();

		}
		System.out.println();

	}
}
