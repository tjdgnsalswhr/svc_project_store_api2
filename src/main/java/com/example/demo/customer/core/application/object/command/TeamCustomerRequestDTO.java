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
public class TeamCustomerRequestDTO {
	
	@ApiModelProperty(example = "id01")
	String id; 			//팀 아이디
	
	@ApiModelProperty(example = "password01")
	String password; 	//팀 비밀번호
	
	@ApiModelProperty(example = "team01")
	String teamname; 	//팀 이름
	
	@ApiModelProperty(example = "leader01")
	String leadername; 	//팀장 이름
	
	@ApiModelProperty(example = "500000")
	int balance; 		//남은 금액
	
	@ApiModelProperty(example = "1000000")
	int totalcharge; 	//총 충전 금액
	
	@ApiModelProperty(example = "500000")
	int totaluse; 		//총 사용 금액
}
