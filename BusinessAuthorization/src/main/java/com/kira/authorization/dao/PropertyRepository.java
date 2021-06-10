package com.kira.authorization.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kira.authorization.dto.BusinessPropertyDTO;

@Repository
public interface PropertyRepository extends JpaRepository<BusinessPropertyDTO, Serializable> {
	
	Optional<BusinessPropertyDTO> findByPropertyId(Long propertyId);
	List<BusinessPropertyDTO> findByCustomerId(Long customerId);
	
	

}
