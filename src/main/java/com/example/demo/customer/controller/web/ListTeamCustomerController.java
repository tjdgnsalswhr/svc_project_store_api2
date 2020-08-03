package com.example.demo.customer.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.core.service.ListTeamCustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ListTeamCustomerController {
	
	@Autowired
	ListTeamCustomerService listTeamCustomerService;
	
	@ApiOperation(value="전체 팀 목록 조회", httpMethod = "GET", notes="전체 팀 목록 조회 API.")
	@GetMapping(value="/teamcustomer/list/all")
	public ResponseEntity<Object> getAllTeamCustomer()
	{
		return new ResponseEntity<>(listTeamCustomerService.getAllTeamCustomerList(), HttpStatus.OK);
	}
	
	@ApiOperation(value="검색 팀 목록 조회", httpMethod = "GET", notes="검색 팀 목록 조회 API.")
	@GetMapping(value="/teamcustomer/list/searching/{teamName}")
	public ResponseEntity<Object> getSerchingTeamCustomer(@PathVariable String teamName)
	{
		return new ResponseEntity<>(listTeamCustomerService.getSearchingTeamCustomerList(teamName), HttpStatus.OK);
	}
	

}
