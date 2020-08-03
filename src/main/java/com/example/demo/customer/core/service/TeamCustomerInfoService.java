package com.example.demo.customer.core.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.common.error.exception.BusinessException;
import com.example.demo.customer.core.application.object.command.TeamCustomerRequestDTO;
import com.example.demo.customer.core.application.object.query.TeamCustomerResponseDTO;
import com.example.demo.customer.core.entity.TeamCustomer;
import com.example.demo.customer.core.port_infra.persistent.TeamCustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class TeamCustomerInfoService {
	private final TeamCustomerRepository teamCustomerRepository;
	private final ModelMapper modelMapper;
	
	
	public TeamCustomerResponseDTO getOneTeamCustomer(String id) //계속 주고 받는 것에 DTO를 쓰는 이유는 원래 객체를 망가뜨리지 않기 위해서 비슷한 것을 복제해 사용하는 것임
	{
		Optional<TeamCustomer> optionalTeamCustomer = teamCustomerRepository.findById(id);
		if(optionalTeamCustomer.isPresent())
		{
			return modelMapper.map(optionalTeamCustomer.get(), TeamCustomerResponseDTO.class);
		}
		else
			return null;
	}
	
	public void insertTeamCustomer(TeamCustomerRequestDTO teamCustomerRequestDTO)
	{
		TeamCustomer teamCustomer = modelMapper.map(teamCustomerRequestDTO, TeamCustomer.class);
		teamCustomerRepository.save(teamCustomer);
	}
	
	public void updateTeamCustomer(TeamCustomerRequestDTO teamCustomerRequestDTO)	
	{
		Optional<TeamCustomer> optionalTeamCustomer = teamCustomerRepository.findById(teamCustomerRequestDTO.getId());
		if(!optionalTeamCustomer.isPresent())
		{
			throw new BusinessException("0000","There is No TeamCustomer");
		}
		TeamCustomer teamCustomer = optionalTeamCustomer.get();
		teamCustomer.update(teamCustomerRequestDTO);
		teamCustomerRepository.save(teamCustomer);
	}
	
	public void deleteTeamCustomer(String id)
	{
		Optional<TeamCustomer> optionalTeamCustomer = teamCustomerRepository.findById(id);
		if(!optionalTeamCustomer.isPresent())
		{
			throw new BusinessException("0000","There is No TeamCustomer");
		}
		teamCustomerRepository.delete(optionalTeamCustomer.get());
	}

}
