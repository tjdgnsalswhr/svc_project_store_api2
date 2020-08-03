package com.example.demo.customer.core.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.customer.core.application.object.query.TeamCustomerResponseDTO;
import com.example.demo.customer.core.entity.TeamCustomer;
import com.example.demo.customer.core.port_infra.persistent.TeamCustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ListTeamCustomerService {
	
	private final TeamCustomerRepository teamCustomerRepository;
	private final ModelMapper modelMapper;
	
	//팀 전체 조회
	public List<TeamCustomer> getAllTeamCustomerList()
	{
		return teamCustomerRepository.findAll();
	}
	
	public List<TeamCustomer> getSearchingTeamCustomerList(String teamname)
	{
		return teamCustomerRepository.findByTeamnameLike("%"+teamname+"%");
	}

}
