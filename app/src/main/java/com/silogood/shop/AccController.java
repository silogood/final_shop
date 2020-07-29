package com.silogood.shop;

import java.io.Serializable;
import java.util.ArrayList;

public class AccController implements Serializable {
		public ArrayList<AccModel> at ; // Main에서 입력받은 값들을 받기
		// ArrayList안에 list에 값들을 넣기위한 생성자
		// ArrayList<Object> ct;

		public AccController(ArrayList<AccModel> list) {
			this.at = list;
		}

		// 꽉차있는지 확인
		public int getSize() {
			return at.size();
		}

		// 입력(삽입)하기
		public void insert(AccModel a) {
			at.add(a);
		}

		// 입력값들을 지우기
		public void remove(AccModel a) {
			at.remove(a);
		}

		public AccModel getLocate(int num) { //해당객체를 찾는 메소드
			return at.get(num);
		}
		
		public static void swapInstence(int index1, int index2, ArrayList<AccModel> at) {
			ArrayList<AccModel> at1 = at;
			AccModel temp = at.get(index1);
			AccModel temp2 = at.get(index2);
			at1.add(index1, temp2);
			at1.remove(index1 + 1);
			at1.add(index2, temp);
			at1.remove(index2 + 1);
			at = at1;
		}

	}
