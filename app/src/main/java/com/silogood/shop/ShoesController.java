package com.silogood.shop;

import java.io.Serializable;
import java.util.ArrayList;

public class ShoesController implements Serializable  {
		public ArrayList<ShoesModel> st; // Main에서 입력받은 값들을 받기
		// ArrayList안에 list에 값들을 넣기위한 생성자
		// ArrayList<Object> ct;

		public ShoesController(ArrayList<ShoesModel> list) {
			this.st = list;
		}

		// 꽉차있는지 확인
		public int getSize() {
			return st.size();
		}

		// 입력(삽입)하기
		public void insert(ShoesModel a) {
			st.add(a);
		}

		// 입력값들을 지우기
		public void remove(ShoesModel a) {
			st.remove(a);
		}
	
		// 찾는것
		public ShoesModel getLocate(int num) {
			return st.get(num);
		}
		
		public static void swapInstence(int index1, int index2, ArrayList<ShoesModel> st) {
			ArrayList<ShoesModel> st1 = st;
			ShoesModel temp = st.get(index1);
			ShoesModel temp2 = st.get(index2);
			st1.add(index1,temp2);
			st1.remove(index1+1);
			st1.add(index2,temp);
			st1.remove(index2+1);
			st = st1;
		}

	}
