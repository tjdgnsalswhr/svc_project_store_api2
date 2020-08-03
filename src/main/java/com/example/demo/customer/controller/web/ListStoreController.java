package com.example.demo.customer.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.core.service.ListStoreService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ListStoreController {
	
	@Autowired
	ListStoreService listStoreService;
	
	@ApiOperation(value="전체 가게 조회", httpMethod = "GET", notes="전체 가게 목록 조회 API.")
	@GetMapping(value="/store/list/all")
	public ResponseEntity<Object> getAllStore()
	{
		return new ResponseEntity<>(listStoreService.getAllStoreList(),HttpStatus.OK);
	}
	
	@ApiOperation(value="종류별 가게 조회", httpMethod = "GET", notes="종류별 가게 목록 조회 API.")
	@GetMapping(value="/store/list/type/{storecode}")
	public ResponseEntity<Object> getTypeStore(@PathVariable String storecode)
	{
		return new ResponseEntity<>(listStoreService.getTypeStore(storecode),HttpStatus.OK);
	}

}
