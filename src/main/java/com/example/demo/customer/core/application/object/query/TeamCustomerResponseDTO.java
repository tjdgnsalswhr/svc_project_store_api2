package com.example.demo.customer.core.application.object.query;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Id;
import java.util.Date;

@Slf4j
@ToString
@NoArgsConstructor
@Getter
@Setter
public class TeamCustomerResponseDTO {
	String id; 			//팀 아이디
	String password; 	//팀 비밀번호
	String teamName; 	//팀 이름
	String leaderName; 	//팀장 이름
	int balance; 		//남은 금액
	int totalCharge; 	//총 충전 금액
	int totalUse; 		//총 사용 금액
}
