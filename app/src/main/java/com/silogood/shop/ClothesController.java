package com.silogood.shop;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class ClothesController implements Serializable {
	public ArrayList<ClothesModel> ct; // Main에서 입력받은 값들을 받기
	// ArrayList안에 list에 값들을 넣기위한 생성자
	// ArrayList<Object> ct;

	public ClothesController(ArrayList<ClothesModel> list) {
		this.ct = list;
	}

	// 꽉차있는지 확인
	public int getSize() throws IOException {
		return ct.size();
	}

	// 입력(삽입)하기
	public void insert(ClothesModel a) throws IOException {
		ct.add(a);
	}

	// 입력값들을 지우기
	public void remove(ClothesModel a) throws IOException {
		ct.remove(a);
	}

	// 찾는것
	public ClothesModel getLocate(int num) throws IOException { //객체에 있는 index번호를 찾는 메소드
		return ct.get(num);
	}
	public static void swapInstence(int index1, int index2, ArrayList<ClothesModel> ct) {
		ArrayList<ClothesModel> ct1 = ct;
		ClothesModel temp = ct.get(index1);
		ClothesModel temp2 = ct.get(index2);
		ct1.add(index1, temp2);
		ct1.remove(index1 + 1);
		ct1.add(index2, temp);
		ct1.remove(index2 + 1);
		ct = ct1;
	}

}
