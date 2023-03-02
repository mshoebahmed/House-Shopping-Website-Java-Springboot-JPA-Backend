package com.Housing.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Housing.Model.HouseData;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface mySqlDaoJPA extends JpaRepository<HouseData ,Integer> {

	List<HouseData> findById(long id);
	
	@Transactional
	List<HouseData> deleteById(long id);
	
	List<HouseData> findByCityContaining(String city);
	
	

}
