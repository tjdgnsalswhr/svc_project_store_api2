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

import com.example.demo.customer.core.application.object.command.StoreRequestDTO;
import com.example.demo.customer.core.application.object.query.ResponseDTO;
import com.example.demo.customer.core.service.StoreInfoService;

import io.swagger.annotations.ApiOperation;

@RestController
public class StoreInfoController {
	
	@Autowired
	StoreInfoService storeInfoService;
	
	@ApiOperation(value = "가게 정보 조회", httpMethod="GET", notes="가게 정보 조회 API.")
	@GetMapping(value="/store/info/{storeId}")
	public ResponseEntity<Object> getOneStore(@PathVariable String storeId)
	{
		return new ResponseEntity<>(new ResponseDTO(storeInfoService.getOneStore(storeId)), HttpStatus.OK);
	}
	
	@ApiOperation(value = "가게 정보 추가", httpMethod="POST", notes="가게 정보 추가 API")
	@PostMapping(value="/store/info")
	public ResponseEntity<Object> addStore(@RequestBody StoreRequestDTO storeRequestDTO)
	{
		storeInfoService.insertStore(storeRequestDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "가게 정보 수정", httpMethod="PUT", notes="가게 정보 수정 API.")
	@PutMapping(value="/store/info")
	public ResponseEntity<Object> updateStore(@RequestBody StoreRequestDTO storeRequestDTO)
	{
		storeInfoService.updateStore(storeRequestDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "가게 정보 삭제", httpMethod="DELETE", notes="가게 정보 삭제 API.")
	@DeleteMapping(value="/store/info/{storeId}")
	public ResponseEntity<Object> deleteStore(@PathVariable String storeId)
	{
		storeInfoService.deleteStore(storeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
