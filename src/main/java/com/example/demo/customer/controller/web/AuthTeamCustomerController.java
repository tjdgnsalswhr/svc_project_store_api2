package com.example.demo.customer.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.core.application.object.command.TeamCustomerRequestDTO;
import com.example.demo.customer.core.service.AuthTeamCustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AuthTeamCustomerController {
	
	@Autowired //자동주입
	//고객 정보 인증 서비스
	AuthTeamCustomerService authTeamCustomerService;
	
	@ApiOperation(value = "팀 정보 인증", httpMethod="POST", notes = "팀 정보 인증 API.")
	@PostMapping(value="/teamcustomer/auth")
	public ResponseEntity<Object> authTeamCustomer(@RequestBody TeamCustomerRequestDTO teamCustomerRequestDTO)
	{
		return new ResponseEntity<>(authTeamCustomerService.authTeamCustomer(teamCustomerRequestDTO.getId(), teamCustomerRequestDTO.getPassword()), HttpStatus.OK);
	}
}
