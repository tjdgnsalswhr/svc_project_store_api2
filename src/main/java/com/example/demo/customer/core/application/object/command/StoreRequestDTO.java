package com.example.demo.customer.core.application.object.command;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ToString
@NoArgsConstructor
@Getter
@Setter
public class StoreRequestDTO {
	
	@ApiModelProperty(example = "id01")
	String id; 			//가게 아이디
	
	@ApiModelProperty(example = "password01")
	String password; 	//가게 비밀번호
	
	@ApiModelProperty(example = "storename01")
	String storename; 	//가게 이름
	
	@ApiModelProperty(example = "owner01")
	String ownername; 	//가게 주인 이름
	
	@ApiModelProperty(example = "경기도 성남시 판교로 XXX")
	String address; 	//가게 주소
	
	@ApiModelProperty(example = "연중무휴")
	String openinfo; 	//가게 영업 정보
	
	@ApiModelProperty(example = "031-222-2222")
	String phonenumber; //가게 전화번호
	
	@ApiModelProperty(example = "1")
	String storecode; 		//음식 종류
	
	@ApiModelProperty(example = "1000000")
	int monthprofit; 	//월 수익

}
