package com.example.demo.customer.core.port_infra.persistent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.customer.core.entity.TeamCustomer;

public interface TeamCustomerRepository extends JpaRepository<TeamCustomer, String> {

	public List<TeamCustomer> findByTeamnameLike(String teamname);
}
