package com.example.demo.customer.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.core.application.object.command.StoreRequestDTO;
import com.example.demo.customer.core.application.object.command.TeamCustomerRequestDTO;
import com.example.demo.customer.core.service.AuthStoreService;
import com.example.demo.customer.core.service.AuthTeamCustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AuthStoreController
{
	@Autowired //자동주입
	//가게 정보 인증 서비스
	AuthStoreService authStoreService;
	
	@ApiOperation(value = "가게 정보 인증", httpMethod="POST", notes = "가게 정보 인증 API.")
	@PostMapping(value="/store/auth")
	public ResponseEntity<Object> authTeamCustomer(@RequestBody StoreRequestDTO storeRequestDTO)
	{
		return new ResponseEntity<>(authStoreService.authStore(storeRequestDTO.getId(), storeRequestDTO.getPassword()), HttpStatus.OK);
	}
}
