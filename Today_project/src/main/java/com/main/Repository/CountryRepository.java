package com.main.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.main.model.Country;

public interface CountryRepository extends CrudRepository<Country, Integer>{

	public List<Country> findByIdGreaterThan(int id);
	

	public List<Country> findByName(String name);
	
	
	/*@Query(value="select C from Country C where C.code=?1 AND C.name=?2 ")*/
	@Query(value="select C from Country C where C.code=:code AND C.name=:name ")
	public List<Country> findByCodeAndName(@Param("code")String code,@Param("name") String name);

}
