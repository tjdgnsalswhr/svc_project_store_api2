package com.example.demo.customer.core.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.customer.core.application.object.command.StoreRequestDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j //로그 기록을 위한 Annotation
@ToString //tostirng method 자동 생성
@NoArgsConstructor //파라미터가 없는 생성자 생성
@Getter //접근자 자동 생성
@Setter //설정자 자동 생성
@Table(name="stores") //entity와 매핑할 테이블. 생략시 매핑한 엔티티 이름을 테이블 이름으로 사용.
@Entity //JPA를 사용해서 테이블과 매핑할 클래스. 이 Annotation이 붙으면 JPA가 관리하는 것

public class Store 
{
	
	@Id 				//기본키 할당
	String id; 			//가게 아이디
	String password; 	//가게 비밀번호
	String storename; 	//가게 이름
	String ownername; 	//가게 주인 이름
	String address;		//가게 주소
	String openinfo;
	String phonenumber;
	String storecode;		//1.한식 2.중식 3.일식 4.기타
	int monthprofit; 	//월 수익
	
	
	@Builder
	public Store(String StoreId, String StorePassword, String StoreName, String StoreOwnerName, String StoreAddress, String StorePhoneNumber, String StoreCode)
	{
		this.id = StoreId;
		this.password = StorePassword;
		this.storename = StoreName;
		this.ownername = StoreOwnerName;
		this.address = StoreAddress;
		this.phonenumber = StorePhoneNumber;
		this.storecode = StoreCode;
	}
	
	public void update(StoreRequestDTO storeRequestDTO)
	{
		this.id = storeRequestDTO.getId(); 			
		this.password = storeRequestDTO.getPassword(); 	
		this.storename = storeRequestDTO.getStorename(); 	
		this.ownername = storeRequestDTO.getOwnername(); 	
		this.address = storeRequestDTO.getAddress();		
		this.openinfo = storeRequestDTO.getOpeninfo();
		this.phonenumber = storeRequestDTO.getPhonenumber();
		this.storecode = storeRequestDTO.getStorecode();		
		this.monthprofit = storeRequestDTO.getMonthprofit();
		
	}
}
