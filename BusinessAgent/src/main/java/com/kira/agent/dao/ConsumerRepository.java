package com.kira.agent.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kira.agent.dto.ConsumerDTO;

@Repository
public interface ConsumerRepository extends JpaRepository<ConsumerDTO, Serializable> {
	
	Optional<ConsumerDTO> findByCustomerId(Long customerId);
	List<ConsumerDTO> findByAgentId(String agentId);
	
	

}
