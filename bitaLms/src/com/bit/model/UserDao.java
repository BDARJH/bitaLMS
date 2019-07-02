package com.bit.model;

public class UserDao {

	// 아이디와 패스워드를 가지고 입력하면 리턴값으로 belong(소속 번호)를 받는다.
	// belong이 -1 : 회원이 아님, 0 : 등록전 학생 , 1 : 등록학생, 2:영업팀, 3:행정팀, 4:강사
	public int login(String id, String pw) {
		int result = Integer.parseInt(id);//테스트 이니 일단 id로 
		
		
		
		return result;
	}


}
