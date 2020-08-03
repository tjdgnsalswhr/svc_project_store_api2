package com.example.demo.customer.core.port_infra.persistent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.customer.core.entity.Store;

public interface StoreRepository extends JpaRepository<Store, String> 
{
	public List<Store> findByStorecode(String storecode);

}
