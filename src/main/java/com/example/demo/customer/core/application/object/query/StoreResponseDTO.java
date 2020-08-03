package com.example.demo.customer.core.application.object.query;

import io.swagger.annotations.ApiModelProperty;

public class StoreResponseDTO {
	

	String id; 			//가게 아이디
	String password; 	//가게 비밀번호
	String storename; 	//가게 이름
	String ownername; 	//가게 주인 이름
	String address; 	//가게 주소
	String openinfo; 	//가게 영업 정보
	String phonenumber; //가게 전화번호
	String storecode; 		//남은 금액
	int monthprofit; 	//월 수익

}
