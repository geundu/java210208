package com.design.zipcode;

import javax.swing.JFrame;

public class ZipCodeSearch extends JFrame {
	//선언부
	
	//생성자
	public ZipCodeSearch() {
		
	}
	
	//화면처리부
	public void initDisplay() {
		this.setTitle("윤하가 부릅니다 오늘 헤어졌어요");
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	//메인
	public static void main(String[] args) {
		ZipCodeSearch zcs = new ZipCodeSearch();
//		zcs.initDisplay();
	}
}
