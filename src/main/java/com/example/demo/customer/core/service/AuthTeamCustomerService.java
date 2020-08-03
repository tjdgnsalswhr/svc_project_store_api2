package com.example.demo.customer.core.service;

import java.util.Optional;



import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.core.entity.TeamCustomer;
import com.example.demo.customer.core.port_infra.persistent.TeamCustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional //트랙잭션을 선언하는 어노테이션
public class AuthTeamCustomerService{
	
	@Autowired
	private final TeamCustomerRepository teamCustomerRepository;
	private final ModelMapper modelMapper;
	
	public boolean authTeamCustomer(String teamId, String teamPassword)
	{
		Optional<TeamCustomer> optionalTeamCustomer = teamCustomerRepository.findById(teamId);
		if(!optionalTeamCustomer.isPresent())
		{
			//만약 id에 해당하는 객체가 Repository에 없다면 인증 실패
			return false;
		}
		else
		{
			TeamCustomer teamCustomer = optionalTeamCustomer.get();
			if(teamPassword.equals(teamCustomer.getPassword()))
			{
				//일치하는 아이디가 있고 그 비밀번호까지 맞다면 인증 성공
				return true;
			}
			else
				return false;
		}
	}

}
