package com.example.demo.customer.core.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.customer.core.entity.Store;
import com.example.demo.customer.core.port_infra.persistent.StoreRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ListStoreService {
	
	private final StoreRepository storeRepository;
	private final ModelMapper modelMapper;
	
	
	//가게 전체 조회
	public List<Store> getAllStoreList()
	{
		return storeRepository.findAll();
	}
	
	//음식 종류별 가게 조회
	public List<Store> getTypeStore(String storecode)
	{
		return storeRepository.findByStorecode(storecode);
	}

}
