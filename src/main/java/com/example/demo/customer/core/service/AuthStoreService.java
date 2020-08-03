package com.example.demo.customer.core.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.core.entity.Store;
import com.example.demo.customer.core.port_infra.persistent.StoreRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class AuthStoreService {
	
	@Autowired
	private final StoreRepository storeRepository;
	private final ModelMapper modelMapper;
	
	public boolean authStore(String storeId, String storePassword)
	{
		Optional<Store> optionalStore = storeRepository.findById(storeId);
		if(!optionalStore.isPresent())
		{
			//만약 id에 해당하는 객체가 Repository에 없다면 인증 실패
			return false;
		}
		else
		{
			Store store = optionalStore.get();
			if(storePassword.equals(store.getPassword()))
			{
				//일치하는 아이디가 있고 그 비밀번호까지 맞다면 인증 성공
				return true;
			}
			else
				return false;
		}
	}

}
