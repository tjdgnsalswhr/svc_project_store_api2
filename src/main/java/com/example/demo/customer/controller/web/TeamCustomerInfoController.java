package com.example.demo.customer.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.core.application.object.command.TeamCustomerRequestDTO;
import com.example.demo.customer.core.application.object.query.ResponseDTO;
import com.example.demo.customer.core.service.TeamCustomerInfoService;

import io.swagger.annotations.ApiOperation;

@RestController
public class TeamCustomerInfoController {
	
	@Autowired
	TeamCustomerInfoService teamCustomerInfoService;
	
	@ApiOperation(value = "팀 정보 조회", httpMethod="GET", notes="팀 정보 조회 API.")
	@GetMapping(value="/teamcustomer/info/{teamId}")
	public ResponseEntity<Object> getOneTeamCustomer(@PathVariable String teamId)
	{
		return new ResponseEntity<>(new ResponseDTO(teamCustomerInfoService.getOneTeamCustomer(teamId)), HttpStatus.OK);
	}
	
	@ApiOperation(value = "팀 정보 추가", httpMethod="POST", notes="팀 정보 추가 API")
	@PostMapping(value="/teamcustomer/info")
	public ResponseEntity<Object> addTeamCustomer(@RequestBody TeamCustomerRequestDTO teamCustomerRequestDTO)
	{
		teamCustomerInfoService.insertTeamCustomer(teamCustomerRequestDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "팀 정보 수정", httpMethod="PUT", notes="팀 정보 수정 API.")
	@PutMapping(value="/teamcustomer/info")
	public ResponseEntity<Object> updateTeamCustomer(@RequestBody TeamCustomerRequestDTO teamCustomerRequestDTO)
	{
		teamCustomerInfoService.updateTeamCustomer(teamCustomerRequestDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "팀 정보 삭제", httpMethod="DELETE", notes="팀 정보 삭제 API.")
	@DeleteMapping(value="/teamcustomer/info/{teamId}")
	public ResponseEntity<Object> deleteTeamCustomer(@PathVariable String teamId)
	{
		teamCustomerInfoService.deleteTeamCustomer(teamId);;
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
