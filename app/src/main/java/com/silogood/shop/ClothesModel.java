package com.silogood.shop;

import java.io.Serializable;

public class ClothesModel implements Serializable, Comparable<ClothesModel> {
	//2020-02-03 기능 추가: ClothesModel 출력 시 신발 수량 크기 내림차순 기준으로 비교하기 위해 Comparable<>구현 - 형연지 작성
	//수정 사항: ClothesModel 신발 수량 내림차순 기준으로 출력하기 위해 ClothesModel클래스를 public으로 해야함.
	private String name; // 품목이름
	private String code;
	private int qt; // 품목개수

	public ClothesModel() {
		this.name = "";
		this.code = "";
		this.qt = 0;
	}

	public ClothesModel(String Name, String code, int qt) {
		this.name = Name;
		this.code = code;
		this.qt = qt;
	}

	public void setAll(String Name, String code, int qt) {
		this.name = Name;
		this.code = code;
		this.qt = qt;
	}

	public int getQt() {
		return qt;
	}
	public void setQt(int qt) {
		this.qt = qt;
	}
	public void buy(int qt) {
		if(qt <= this.qt)
		this.qt -=qt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAll() {
		return name + " "  + code + " " + qt;
	}

	// ArrayLsit에서 indexOf나 remove를 사용할때에는
	// 클래스 equals() 메소드를 만들어줘야한다.
	public boolean equals(Object o) {
		if (o instanceof ClothesModel) {
			ClothesModel a = (ClothesModel) o;
			if (this.name.equals(a.name))
				return true;
		}
		return false;
	}

	public void infoPrint() {
		System.out.println(name + "\t\t" + code + "\t " + qt);
	}
	
	//2020-02-03 기능 추가: ShoesModel 출력 시 신발 수량 크기 내림차순 기준으로 비교하는 메서드 추가 - 형연지 작성
		public int compareTo(ClothesModel o) {
			if (qt > o.getQt())
				return -1;
			else if (qt < o.getQt())
				return 1;
			return 0;
		}

}