package com.silogood.shop;

import java.io.Serializable;

public class ShoesModel implements Serializable, Comparable<ShoesModel>{ 
	private String name; // 제품이름
	private String code; // 제품 코드
	private int qt; // 수량


	public ShoesModel() {
		this.name = "";
		this.code = "";
		this.qt = 0;
	}

	public ShoesModel(String name, String code, int qt) {
		this.name = name;
		this.code = code;
		this.qt = qt;
	}

	public void setAll(String name, String code, int qt) {
		this.name = name;
		this.code = code;
		this.qt = qt;
		//ll
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

	public String get() {
		return "상품명은 : " + name + "   " + "상품 품번은: " + code + "   " + "상품 개수 :" + qt;
	}
	public String getAll() {
		return name + " " + code + " " + qt;
	}

	// ArrayLsit에서 indexOf나 remove를 사용할때에는
	// 클래스 equals() 메소드를 만들어줘야한다.
	public boolean equals(Object o) {
		if (o instanceof ShoesModel) {
			ShoesModel a = (ShoesModel) o;
			if (this.name.equals(a.name)) {
				return true;
			}
		}
		return false;
	}
	public void infoPrint() {
		System.out.println(name + "\t\t" + code + "\t " + qt);
	}
	
	public int compareTo(ShoesModel o) {
		if (qt > o.getQt())
			return -1;
		else if (qt < o.getQt())
			return 1;
		return 0;
	}

}