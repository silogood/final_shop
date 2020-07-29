package com.silogood.shop.dpny.cms;

import com.silogood.shop.AccController;
import com.silogood.shop.AccModel;
import com.silogood.shop.ClothesController;
import com.silogood.shop.ClothesModel;
import com.silogood.shop.ShoesController;
import com.silogood.shop.ShoesModel;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class View implements Serializable {
	public static Scanner sc = new Scanner(System.in);

	public static Scanner getScanner() {
		return sc;
	}

	ClothesModel ct = new ClothesModel();
	ShoesModel st = new ShoesModel();
	AccModel at = new AccModel();

	public void firstView(ClothesController ct, ShoesController st, AccController at) throws IOException {
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println("★★ 0. 회원                                 ★★");
		System.out.println("★★ 1. 관리자                              ★★");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.printf(" >> 번호 입력 : ");

		String input = sc.next();
		switch (input) {
		case "0":
			mainViewMmbr(ct, st, at);
			break;
		case "1":
			mainViewMngr(ct, st, at);
			break;
		}
	}

	public void mainViewMmbr(ClothesController ct, ShoesController st, AccController at) throws IOException {
		while (true) {
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println("★★1. Clothes              ★★");
			System.out.println("★★2. Shoes                ★★");
			System.out.println("★★3. Acc                  ★★");
			System.out.println("★★4. 돌아가기                          ★★");
			System.out.println("★★5. Service Exit         ★★");
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★");

			String input = sc.next(); // switch문 선택값 입력받음
			switch (input) {
			case "1":
				cSubMenu1(ct); // clothes에 대한 서브메뉴
				break;
			case "2":
				sSubMenu1(st); // Shoes에 대한 서브메뉴
				break;
			case "3":
				aSubMenu1(at); // Acc에 대한 서브메뉴
				break;
			case "4":
				firstView(ct, st, at);
			case "5":
				System.out.println("프로그램이 종료됩니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}

	public void mainViewMngr(ClothesController ct, ShoesController st, AccController at) throws IOException {
		while (true) {
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println("★★1. Clothes              ★★");
			System.out.println("★★2. Shoes                ★★");
			System.out.println("★★3. Acc                  ★★");
			System.out.println("★★4. Inventory All Print  ★★");
			System.out.println("★★5. 돌아가기                          ★★");
			System.out.println("★★6. Service Exit         ★★");
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★");

			String input = sc.next(); // switch문 선택값 입력받음
			switch (input) {
			case "1":
				cSubMenu(ct); // clothes에 대한 서브메뉴
				break;
			case "2":
				sSubMenu(st); // Shoes에 대한 서브메뉴
				break;
			case "3":
				aSubMenu(at); // Acc에 대한 서브메뉴
				break;
			case "4":
				printAll(ct, st, at); // Clothes, Shoes, Acc 전체 출력
				break;
			case "5":
				firstView(ct, st, at);
			case "6":
				System.out.println("프로그램이 종료됩니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}

	// 관리자메뉴
	public void cSubMenu(ClothesController ct) throws IOException {// subview
		System.out.println("================================");
		System.out.println("1. 옷 재고 입력                             ");
		System.out.println("2. 옷 재고 수정                             ");
		System.out.println("3. 옷 재고 삭제                             ");
		System.out.println("4. 옷 재고 검색                             ");
		System.out.println("5. 옷 재고 전체 출력                       ");
		System.out.println("6. 돌아가기                                  ");
		System.out.println("================================");
		cSubmenuCt(ct); // 두번째 switch문
	}

	// 회원메뉴
	public void cSubMenu1(ClothesController ct) throws IOException {// subview
		System.out.println("================================");
		System.out.println("1. 옷 재고 목록                           ");
		System.out.println("2. 옷 재고 검색                           ");
		System.out.println("3. 옷 발주                           ");
		System.out.println("4. 옷 발주 내역                           ");
		System.out.println("5. 돌아가기                           ");
		System.out.println("================================");
		cSubmenuCt1(ct); // 두번째 switch문
	}

	// 관리자메뉴
	public void sSubMenu(ShoesController st) throws IOException {// subview
		System.out.println("================================");
		System.out.println("1. 신발 재고 입력                           ");
		System.out.println("2. 신발 재고 수정                           ");
		System.out.println("3. 신발 재고 삭제                           ");
		System.out.println("4. 신발 재고 검색                           ");
		System.out.println("5. 신발 재고 전체 출력                    ");
		System.out.println("6. 돌아가기                                  ");
		System.out.println("================================");
		sSubmenuCt(st); // 두번째 switch문
	}

	// 회원메뉴
	public void sSubMenu1(ShoesController st) throws IOException {// subview
		System.out.println("================================");
		System.out.println("1. 신발 재고 목록                           ");
		System.out.println("2. 신발 재고 검색                           ");
		System.out.println("3. 신발 발주                           ");
		System.out.println("4. 신발 발주 내역                           ");
		System.out.println("5. 돌아가기                           ");
		System.out.println("================================");
		sSubmenuCt(st); // 두번째 switch문
	}

	// 관리자메뉴
	public void aSubMenu(AccController at) throws IOException {// subview
		System.out.println("================================");
		System.out.println("1. 악세사리 재고 입력                     ");
		System.out.println("2. 악세사리 재고 수정                     ");
		System.out.println("3. 악세사리 재고 삭제                     ");
		System.out.println("4. 악세사리 재고 검색                     ");
		System.out.println("5. 악세사리 재고 전체 출력               ");
		System.out.println("6. 돌아가기                                  ");
		System.out.println("================================");
		aSubmenuCt(at); // 두번째 switch문
	}

	// 회원메뉴
	public void aSubMenu1(AccController at) throws IOException {// subview
		System.out.println("================================");
		System.out.println("1. 악세사리 재고 목록                      ");
		System.out.println("2. 악세사리 발주                     ");
		System.out.println("3. 악세사리 발주 내역                     ");
		System.out.println("================================");
		aSubmenuCt(at); // 두번째 switch문
	}

	/**************************** 옷 subMenuCt ************************************/
	// 관리자
	public void cSubmenuCt(ClothesController ct) throws IOException {
		int num = getUserSelect();
		switch (num) {
		case 1:
			System.out.println("옷 재고 입력을 시작합니다.");
			cInsert(ct);// 입력 메서드 호출
			cSubMenu(ct);
			break;
		case 2:
			System.out.println("옷 재고 수정을 시작합니다.");
			cEdit(ct);// 수정 메서드 호출
			cSubMenu(ct);
			break;
		case 3:
			System.out.println("옷 재고 삭제를 시작합니다.");
			cRemove(ct);// 삭제 메서드 호출
			cSubMenu(ct);
			break;
		case 4:
			System.out.println("옷 재고 검색을 시작합니다.");
			cSearch(ct);// 검색 메서드 호출
			cSubMenu(ct);
			break;
		case 5:
			System.out.println("옷 재고 출력을 시작합니다.");
			cPrintAll(ct);// 재고 출력 메서드 호출
			cSubMenu(ct);
			break;
		case 6: // 돌아가기
			return;
		default:
			System.out.println("잘못 누르셨습니다.");
			cSubMenu(ct);
			break;
		}
	}

	// 회원
	public void cSubmenuCt1(ClothesController ct) throws IOException {
		int num = getUserSelect();
		switch (num) {
		case 1:
			System.out.println("옷 재고 출력을 시작합니다.");
			cPrintAll(ct);// 재고 출력 메서드 호출
			cSubMenu1(ct);
			break;
		case 2:
			System.out.println("옷 재고 검색을 시작합니다.");
			cSearch(ct);// 검색 메서드 호출
			cSubMenu1(ct);
			break;
		case 3:
			System.out.println("옷 발주");
			cBuy(ct);// 수정 메서드 호출
			cSubMenu1(ct);
			break;
		case 4:
			System.out.println("옷 발주 내역입니다.");

			break;
		case 5: // 돌아가기
			return;
		default:
			System.out.println("잘못 누르셨습니다.");
			cSubMenu1(ct);
			break;
		}
	}

	/**************************** 신발 subMenuCt ************************************/
	public void sSubmenuCt(ShoesController st) throws IOException {
		int num = getUserSelect();
		switch (num) {
		case 1:
			System.out.println("신발 재고 입력을 시작합니다.");
			sInsert(st);// 입력 메서드 호출
			sSubMenu(st);
			break;
		case 2:
			System.out.println("신발 재고 수정을 시작합니다.");
			sEdit(st);// 수정 메서드 호출
			sSubMenu(st);
			break;
		case 3:
			System.out.println("신발 재고 삭제를 시작합니다.");
			sRemove(st);// 삭제 메서드 호출
			sSubMenu(st);
			break;
		case 4:
			System.out.println("신발 재고 검색을 시작합니다.");
			sSearch(st);// 검색 메서드 호출
			sSubMenu(st);
			break;
		case 5:
			System.out.println("신발 재고 출력을 시작합니다.");
			sPrintAll(st);// 재고 출력 메서드 호출
			sSubMenu(st);
			break;
		case 6: // 돌아가기
			return; // mainMenu로 돌아감
		default:
			System.out.println("잘못 누르셨습니다.");
			sSubMenu(st);
			break;
		}
	}

	/****************************
	 * 악세서리 subMenuCt
	 ************************************/
	public void aSubmenuCt(AccController at) throws IOException {
		int num = getUserSelect();
		switch (num) {
		case 1:
			System.out.println("악세사리 재고 입력을 시작합니다.");
			aInsert(at);// 입력 메서드 호출
			aSubMenu(at);
			break;
		case 2:
			System.out.println("악세사리 재고 수정을 시작합니다.");
			aEdit(at);// 수정 메서드 호출
			aSubMenu(at);
			break;
		case 3:
			System.out.println("악세사리 재고 삭제를 시작합니다.");
			aRemove(at);// 삭제 메서드 호출
			aSubMenu(at);
			break;
		case 4:
			System.out.println("악세사리 재고 검색을 시작합니다.");
			aSearch(at);// 검색 메서드 호출
			aSubMenu(at);
			break;
		case 5:
			System.out.println("악세사리 재고 출력을 시작합니다.");
			aPrintAll(at);// 재고 출력 메서드 호출
			aSubMenu(at);
			break;
		case 6: // 돌아가기
			return; // mainMenu로 돌아감
		default:
			System.out.println("잘못 누르셨습니다.");
			aSubMenu(at);
			break;
		}
	}

	int getUserSelect() { // 메뉴를 사용하기 위한 입력값
		System.out.print("번호를 입력해주세요 >>> ");
		int sel = sc.nextInt();
		return sel;
	}

	public int exceptionString() {
		int num = 0; // 변수선언
		boolean rd = true; // while 탈출하기위한 boolean 선언
		while (rd) {
			try { // 시도
				System.out.print("개수를 입력해주세요 : ");
				num = sc.nextInt();
				if (num < 0) {
					System.out.println("0 미만 숫자는 입력이 불가합니다.");
				} else {
					rd = false; // while문 탈출
				}
			} catch (Exception e) { // 만약에 int값이 아닐 경우 catch로 예외 처리
				sc.nextLine();
				System.out.println("정상적인 숫자를 입력해주세요.");
				continue; // 계속 실행
			}
		}
		return num;
	}

	/*-----------------------Clothes insert메소드-----------------------------------------*/
	public void cInsert(ClothesController ct) throws IOException { // 입력
		FileSave save = new FileSave(); // 파일을 저장하기 위한 객체 생성
		System.out.print("제품명을 입력해주세요 : ");
		String name = sc.next(); // 제품명
		System.out.print("상품코드를 입력해주세요 :"); // 상품코드
		String code = cDoubleCheck(ct); // 같은 상품코드 예외처리 메서드 호출
		int qt = exceptionString(); // 상품 개수 , // 문자열,음수 예외
		ClothesModel i = new ClothesModel(); // 모델에 대한 객체를 생성
		i.setAll(name, code, qt);// 이렇게 하면 view에서 control로 거치지 않고 바로 모델로 감
		ct.insert(i); // list에 입력받은 값을 객체를 저장
		save.cListWriter(ct); // list를 파일에 저장
	}

	public String cDoubleCheck(ClothesController ct) throws IOException {
		String check = "";
		boolean ds = true;
		while (ds) {
			check = sc.next();
			if (ct.getSize() == 0) { // 어레이리스트에 객체가 0일 경우 다시 입력받는다
				return check;
			} else { // 아닐 경우 for문 실행
				for (int i = 0; i < ct.getSize(); i++) { // Arraylist에 객체를 0번부터~끝까지 for문을 돌림
					if (ct.getLocate(i).getCode().equals(check)) { // if문으로 getLocate를 사용해서 index 0~i번까지 찾는 메소드
						System.out.println("이미 존재하는 품번입니다.");
						System.out.println("상품코드를 다시 입력해주세요 :");
						break;
					}
					if (i == ct.getSize() - 1) { // Arraylist에 객체의 index 번호가 끝까지 없을 경우 탈출
						ds = false; // 배열 개수 -1이 배열의 index 마지막번호이기 때문에 while문 탈출
					}
				}
			}
		}
		return check;
	}

	/*-----------------------Clothes edit 메소드-----------------------------------------*/
	public void cEdit(ClothesController ct) throws IOException {
		FileSave save = new FileSave();
		cPrintAll(ct);
		System.out.print("품번을 말씀하세요.");
		String code = sc.next();
		System.out.print("정말 변경하시겠습니까 ?"); // 2020_07_27_최정재

		while (true) { // 2020_07_27_최정재
			String yn_chek = sc.next();
			if (yn_chek.equals("y") || yn_chek.equals("Y")) {

				for (int i = 0; i < ct.getSize(); i++) { // 품번을 찾기 위해 for문 사용
					if (ct.getLocate(i).getCode().equals(code)) { // 배열 0부터 끝까지 품번이 일치하는 객체를 불러오기
						System.out.print("변경할 제품명: ");
						sc.nextLine();
						String cName = sc.nextLine();
						ct.getLocate(i).setName(cName);
						System.out.print("변경할 품번: ");
						String cCode = sc.next();
						ct.getLocate(i).setCode(cCode);
						int cQt = exceptionString(); // 문자열, 음수 예외
						ct.getLocate(i).buy(cQt);
						System.out.print("변경되었습니다.");
						System.out.println();
						save.cListWriter(ct);
						cSubMenu(ct);
						break;
					} else if (i == ct.getSize() - 1) {
						System.out.println("찾으시는 품번이 없습니다.");
						cEdit(ct); // 재귀함수 사용
					}
				}
			} else if (yn_chek.equals("n") || yn_chek.equals("N")) {
				cSubMenu(ct);
			} else {
				System.out.println("다시 입력해 주세요");
			}
		}
	}

	/*-----------------------Clothes buy 메소드-----------------------------------------*/
	public void cBuy(ClothesController ct) throws IOException {
		FileSave save = new FileSave();
		cPrintAll(ct);
		System.out.print("품번을 입력해주세요.");
		String code = sc.next();
		for (int i = 0; i < ct.getSize(); i++) { // 품번을 찾기 위해 for문 사용
			if (ct.getLocate(i).getCode().equals(code)) { // 배열 0부터 끝까지 품번이 일치하는 객체를 불러오기
				int cQt = exceptionString(); // 문자열, 음수 예외
				ct.getLocate(i).buy(cQt);
				System.out.print("성공적으로 구매하였습니다.");
				System.out.println();
				save.cListWriter(ct);
				cSubMenu1(ct);
				break;
			} else if (i == ct.getSize() - 1) {
				System.out.println("찾으시는 품번이 없습니다.");
			}
		}

		cSubMenu1(ct);
	}

	/*-----------------------Clothes remove 메소드-----------------------------------------*/
	public void cRemove(ClothesController ct) throws IOException { // 삭제
		FileSave save = new FileSave();
		cPrintAll(ct);
		System.out.print("삭제하실 품번을 입력해주세요:");
		String code = sc.next(); // 삭제할 품번 입력
		System.out.print("정말 삭제하시겠습니까 ? "); // 2020_07_27_최정재

		while (true) { // 2020_07_27_최정재
			String yn_chek = sc.next();
			if (yn_chek.equals("y") || yn_chek.equals("Y")) {
				System.out.println("계속 진행하겠습니다.");

				if (ct.getSize() == 0) { // list에 값이 없을 경우 이전단계로 이동
					System.out.println("아무 것도 없습니다.");
					return;
				} else {
					for (int i = 0; i < ct.getSize(); i++) {
						if (ct.getLocate(i).getCode().equals(code)) { // 품번이 info.code에 저장되있는 code와 같다면
							ct.remove(ct.getLocate(i)); // 삭제
							System.out.print("삭제 되었습니다.");
							System.out.println();
							save.cListWriter(ct);
							return;
						}
						if (i == ct.getSize() - 1) {
							System.out.println("찾으시는 품번이 없습니다.");
							cRemove(ct);
						}
					}
				}

			} else if (yn_chek.equals("n") || yn_chek.equals("N")) {
				cSubMenu(ct);
			} else {
				System.out.println("다시 입력해 주세요");
			}
		}
	}

	/*-----------------------Clothes search 메소드-----------------------------------------*/
	public void cSearch(ClothesController ct) throws IOException { // 검색
		boolean isTrue = true;
		while (isTrue) {
			System.out.println("검색할 품번을 입력해주세요: ");
			String code = sc.next();
			for (int i = 0; i < ct.getSize(); i++) {
				if (ct.getLocate(i).getCode().equals(code)) {
					System.out.println(ct.getLocate(i).getAll() + "\n");// getAll메소드 수정하기 getAll() 모두출력
					isTrue = false;
					break;
				} else {
					if (i == ct.getSize() - 1) {
						System.out.println("잘못된 품번입니다.");
					}
				}
			}
		}
	}

	/*-----------------------Clothes printAll 메소드-----------------------------------------*/
	public void cPrintAll(ClothesController list) throws IOException { // 전체출력
		// ArrayList<ClothesModel>cQtlist = list.ct; //얕은 복사시 사용
		ArrayList<ClothesModel> cQtlist = new ArrayList<ClothesModel>();
		System.out.println();
		cQtlist.addAll(list.ct);
		System.out.println();
		Collections.sort(cQtlist);
		/*
		 * for (int i = 0; i < list.getSize(); i++) { list.getLocate(i).infoPrint(); }
		 * 추가 설명: 총 2가지 방법으로 sort할 수 있음. 얕은복사 - DB에서 직접 신발 재고 수량 기준으로 sorting 해줌 깊은 복사
		 * -DB에서 직접 sorting하지 않고 값을 복사해서 거기서 sorting 해줌 - 깊은 복사 사용함
		 */
		System.out.println("[상품 이름]\t\t[품번]\t[개수]");
		for (int i = 0; i < cQtlist.size(); i++) { // 깊은 복사
			cQtlist.get(i).infoPrint();
		}
	}

	/*-----------------------Shoes insert메소드-----------------------------------------*/
	public void sInsert(ShoesController st) throws IOException { // 입력
		FileSave save = new FileSave();
		System.out.print("제품명을 입력해주세요 : ");
		sc.nextLine();
		String name = sc.nextLine(); // 호형 했음
		System.out.print("상품코드를 입력해주세요 :");
		String code = sDoubleCheck(st); // 같은 상품코드 예외처리 메서드 호출
		int qt = exceptionString();
		// 문자열, 0이랑 음수 예외
		ShoesModel i = new ShoesModel();
		i.setAll(name, code, qt);// 이렇게 하면 view에서 control로 거치지 않고 바로 모델로 감
		st.insert(i);
		save.sListWriter(st);
	}

	public String sDoubleCheck(ShoesController st) throws IOException {
		String check = "";
		boolean ds = true;
		while (ds) {
			check = sc.next();
			if (st.getSize() == 0) {
				return check;
			} else {
				for (int i = 0; i < st.getSize(); i++) {
					if (st.getLocate(i).getCode().equals(check)) {
						System.out.println("이미 존재하는 품번입니다.");
						System.out.println("상품코드를 다시 입력해주세요 :");
						break;
					}
					if (i == st.getSize() - 1) {
						ds = false;
					}
				}
			}
		}
		return check;
	}

	/*-----------------------Shoes edit 메소드-----------------------------------------*/
	public void sEdit(ShoesController st) throws IOException { // 수정 - 형연지
		FileSave save = new FileSave();
		sPrintAll(st);
		System.out.print("품번을 입력해주세요: ");
		String code = sc.next();
		System.out.print("정말 변경하시겠습니까 ? "); // 2020_07_27_최정재

		while (true) {
			String yn_chek = sc.next();
			if (yn_chek.equals("y") || yn_chek.equals("Y")) {
				for (int i = 0; i < st.getSize(); i++) {
					if (st.getLocate(i).getCode().equals(code)) {
						System.out.print("변경할 제품명: ");
						sc.nextLine();
						String cName = sc.nextLine();
						st.getLocate(i).setName(cName);
						System.out.print("변경할 품번:");
						String cCode = sc.next();
						st.getLocate(i).setCode(cCode);
						int cQt = exceptionString();
						st.getLocate(i).setQt(cQt);
						System.out.print("변경되었습니다.");
						System.out.println();
						save.sListWriter(st);
					} else if (i == st.getSize() - 1) {
						System.out.println("찾으시는 품번이 없습니다.");
						sEdit(st);
						sSubMenu(st);
					}
				}
			} else if (yn_chek.equals("n") || yn_chek.equals("N")) {
				sSubMenu(st);
			} else {
				System.out.println("다시 입력해 주세요");
			}
		}
	}
	
	/*-----------------------Shoes buy 메소드-----------------------------------------*/
	public void sBuy(ShoesController st) throws IOException {
		FileSave save = new FileSave();
		sPrintAll(st);
		System.out.print("품번을 입력해주세요.");
		String code = sc.next();
		for (int i = 0; i < st.getSize(); i++) { // 품번을 찾기 위해 for문 사용
			if (st.getLocate(i).getCode().equals(code)) { // 배열 0부터 끝까지 품번이 일치하는 객체를 불러오기
				int cQt = exceptionString(); // 문자열, 음수 예외
				st.getLocate(i).buy(cQt);
				System.out.print("성공적으로 구매하였습니다.");
				System.out.println();
				save.sListWriter(st);
				sSubMenu1(st);
				break;
			} else if (i == st.getSize() - 1) {
				System.out.println("찾으시는 품번이 없습니다.");
			}
		}

		sSubMenu1(st);
	}

	/*-----------------------Shoes remove 메소드-----------------------------------------*/
	public void sRemove(ShoesController st) throws IOException { // 삭제
		FileSave save = new FileSave();
		sPrintAll(st);
		System.out.print("삭제하실 품번을 입력해주세요: ");
		String code = sc.next(); // 삭제할 품번 입력
		System.out.print("정말 삭제하시겠습니까 ? "); // 2020_07_27_최정재

		while (true) { // 2020_07_27_최정재
			String yn_chek = sc.next();
			if (yn_chek.equals("y") || yn_chek.equals("Y")) {

				if (st.getSize() == 0) {
					System.out.println("아무것도없습니다.");
					return;
				} else {
					for (int i = 0; i < st.getSize(); i++) {
						// ClothesModel info = ct.getLocate(i); // ClothesModel info 안에 list.get(i)를 입력
						if (st.getLocate(i).getCode().equals(code)) { // 품번이 info.code에 저장되있는 code와 같다면
							st.remove(st.getLocate(i)); // 삭제
							System.out.print("삭제 되었습니다.");
							System.out.println();
							save.sListWriter(st);
							return;
						}
						if (i == st.getSize() - 1) {
							System.out.println("찾으시는 품번이 없습니다.");
							sRemove(st);
						}
					}
				}

			} else if (yn_chek.equals("n") || yn_chek.equals("N")) {
				sSubMenu(st);
			} else {
				System.out.println("다시 입력해 주세요");
			}
		}
	}

	/*-----------------------Shoes search 메소드-----------------------------------------*/
	public void sSearch(ShoesController st) throws IOException { // 검색
		boolean isTrue = true;
		while (isTrue) {
			System.out.println("검색할 품번을 입력해주세요: ");
			String code = sc.next();
			for (int i = 0; i < st.getSize(); i++) {
				if (st.getLocate(i).getCode().equals(code)) {
					System.out.println(st.getLocate(i).getAll() + "\n");
					isTrue = false;
					break;
				} else {
					if (i == st.getSize() - 1) {
						System.out.println("잘못된 품번입니다.");
					}
				}
			}
		}
	}

	/*-----------------------Shoes printAll 메소드-----------------------------------------*/
	public void sPrintAll(ShoesController list) throws IOException { // 전체출력
		ArrayList<ShoesModel> sQtlist = new ArrayList<ShoesModel>();
		System.out.println();
		sQtlist.addAll(list.st);
		System.out.println();
		Collections.sort(sQtlist);
		System.out.println("[상품 이름]\t[품번]\t[개수]");
		for (int i = 0; i < sQtlist.size(); i++) { // 깊은 복사
			sQtlist.get(i).infoPrint();
		}
	}

	/*-----------------------acc insert메소드-----------------------------------------*/
	public void aInsert(AccController at) throws IOException { // 입력
		FileSave save = new FileSave();
		System.out.print("제품명을 입력해주세요: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("상품코드를 입력해주세요:");
		String code = aDoubleCheck(at); // 같은 상품코드 예외처리 메서드 호출
		int qt = exceptionString();
		AccModel i = new AccModel();
		i.setAll(name, code, qt);// 이렇게 하면 view에서 control로 거치지 않고 바로 모델로 감
		at.insert(i);
		save.aListWriter(at);
	}

	public String aDoubleCheck(AccController at) throws IOException {
		String check = "";
		boolean ds = true;
		while (ds) {
			check = sc.next();
			if (at.getSize() == 0) {
				return check;
			} else {
				for (int i = 0; i < at.getSize(); i++) {
					if (at.getLocate(i).getCode().equals(check)) {
						System.out.println("이미 존재하는 품번입니다.");
						System.out.println("상품코드를 다시 입력해주세요 :");
						break;
					}
					if (i == at.getSize() - 1) {
						ds = false;
					}
				}
			}
		}
		return check;
	}

	/*-----------------------acc edit 메소드-----------------------------------------*/
	public void aEdit(AccController at) throws IOException {
		FileSave save = new FileSave();
		aPrintAll(at);
		System.out.print("품번을 입력해주세요: ");
		String code = sc.next();
		System.out.print("정말 변경하시겠습니까 ? "); // 2020_07_27_최정재

		while (true) { // 2020_07_27_최정재
			String yn_chek = sc.next();
			if (yn_chek.equals("y") || yn_chek.equals("Y")) {
				for (int i = 0; i < at.getSize(); i++) {
					if (at.getLocate(i).getCode().equals(code)) {
						System.out.print("변경할 제품명: ");
						sc.nextLine();
						String cName = sc.nextLine();
						at.getLocate(i).setName(cName);
						System.out.print("변경할 품번: ");
						String cCode = sc.next();
						at.getLocate(i).setCode(cCode);
						int cQt = exceptionString();
						at.getLocate(i).setQt(cQt);
						System.out.print("변경되었습니다.");
						System.out.println();
						save.aListWriter(at);
						return;
					} else if (i == at.getSize() - 1) {
						System.out.println("찾으시는 품번이 없습니다.");
						aEdit(at);
						aSubMenu(at);
					}
				}
			} else if (yn_chek.equals("n") || yn_chek.equals("N")) {
				aSubMenu(at);
			} else {
				System.out.println("다시 입력해 주세요");
			}
		}

	}

	/*-----------------------Acc buy 메소드-----------------------------------------*/
	public void aBuy(AccController at) throws IOException {
		FileSave save = new FileSave();
		aPrintAll(at);
		System.out.print("품번을 입력해주세요.");
		String code = sc.next();
		for (int i = 0; i < at.getSize(); i++) { // 품번을 찾기 위해 for문 사용
			if (at.getLocate(i).getCode().equals(code)) { // 배열 0부터 끝까지 품번이 일치하는 객체를 불러오기
				int cQt = exceptionString(); // 문자열, 음수 예외
				at.getLocate(i).buy(cQt);
				System.out.print("성공적으로 구매하였습니다.");
				System.out.println();
				save.aListWriter(at);
				aSubMenu1(at);
				break;
			} else if (i == at.getSize() - 1) {
				System.out.println("찾으시는 품번이 없습니다.");
			}
		}

		aSubMenu1(at);
	}

	/*-----------------------acc remove 메소드-----------------------------------------*/
	public void aRemove(AccController at) throws IOException { // 삭제
		FileSave save = new FileSave();
		aPrintAll(at);
		System.out.print("삭제하실 품번을 입력해주세요: ");
		String code = sc.next(); // 삭제할 품번 입력
		System.out.print("정말 삭제하시겠습니까 ? "); // 2020_07_27_최정재

		while (true) { // 2020_07_27_최정재
			String yn_chek = sc.next();
			if (yn_chek.equals("y") || yn_chek.equals("Y")) {
				if (at.getSize() == 0) {
					System.out.println("아무 것도 없습니다.");
					return;
				} else {
					for (int i = 0; i < at.getSize(); i++) {
						// ClothesModel info = ct.getLocate(i); // ClothesModel info 안에 list.get(i)를
						// 입력++
						if (at.getLocate(i).getCode().equals(code)) { // 품번이 info.code에 저장되있는 code와 같다면
							at.remove(at.getLocate(i)); // 삭제
							System.out.print("삭제 되었습니다.");
							System.out.println();
							save.aListWriter(at);
							return;
						}
						if (i == at.getSize() - 1) {
							System.out.println("찾으시는 품번이 없습니다.");
							aRemove(at);
						}
					}
				}
			} else if (yn_chek.equals("n") || yn_chek.equals("N")) {
				aSubMenu(at);
			} else {
				System.out.println("다시 입력해 주세요");
			}
		}
	}

	/*-----------------------acc search 메소드-----------------------------------------*/
	public void aSearch(AccController at) throws IOException { // 검색
		boolean isTrue = true;
		while (isTrue) {
			System.out.println("검색할 품번을 입력해주세요: ");
			String code = sc.next();
			for (int i = 0; i < at.getSize(); i++) {
				if (at.getLocate(i).getCode().equals(code)) {
					System.out.println(at.getLocate(i).getAll() + "\n");
					isTrue = false;
					break;
				} else {
					if (i == at.getSize() - 1) {
						System.out.println("잘못된 품번입니다.");
					}
				}
			}
		}
	}

	/*-----------------------acc printAll 메소드-----------------------------------------*/
	public void aPrintAll(AccController list) throws IOException { // 전체출력
		ArrayList<AccModel> aQtlist = new ArrayList<AccModel>();
		System.out.println();
		aQtlist.addAll(list.at); // list.at를 사용하려면 AccModel 클래스를 퍼블릭으로 해줘야함
		System.out.println();
		Collections.sort(aQtlist);
		System.out.println("[상품 이름]\t[품번]\t[개수]");
		for (int i = 0; i < aQtlist.size(); i++) { // 깊은 복사
			aQtlist.get(i).infoPrint();
		}
	}

	/*----------------------전체 출력 메소드-----------------------------------------*/
	public void printAll(ClothesController ct, ShoesController st, AccController at) throws IOException {
		for (int i = 0; i < ct.getSize() - 1; i++) {
			for (int j = i; j < ct.getSize(); j++) {
				if (ct.getLocate(i).getQt() < ct.getLocate(j).getQt()) {
					ClothesController.swapInstence(i, j, ct.ct);
				}
			}
		}
		System.out.println("=================Clothes===============");
		for (int i = 0; i < ct.getSize(); i++) {
			System.out.println(ct.getLocate(i).getAll());
		}
		System.out.println();
		for (int i = 0; i < st.getSize() - 1; i++) {
			for (int j = i; j < st.getSize(); j++) {
				if (st.getLocate(i).getQt() < st.getLocate(j).getQt()) {
					ShoesController.swapInstence(i, j, st.st);
				}
			}
		}
		System.out.println("=================Shoes=================");
		for (int i = 0; i < st.getSize(); i++) {
			System.out.println(st.getLocate(i).getAll());
		}
		System.out.println();
		for (int i = 0; i < at.getSize() - 1; i++) {
			for (int j = i; j < at.getSize(); j++) {
				if (at.getLocate(i).getQt() < at.getLocate(j).getQt()) {
					AccController.swapInstence(i, j, at.at);
				}
			}
		}
		System.out.println("=================Acc===================");
		for (int i = 0; i < at.getSize(); i++) {
			System.out.println(at.getLocate(i).getAll());
		}
		System.out.println("=======================================");
		System.out.println();
	}

	void exitDpny() { // Exit
		System.exit(0);
	}
}

