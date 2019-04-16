package com.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.Repository.CountryRepository;
import com.main.model.Country;

@SpringBootApplication

public class MainApp {
	
	@Autowired
	CountryRepository repo;

	@RequestMapping("/save")
	public String saveCountry(Country c) {
		
		
		c.setId(6);
		c.setCode("dddd");
		c.setName("deepan");
		
		
		repo.save(c);
		return "Data added successfully";

	}

	@RequestMapping("/find")
	public List<Country> findAll() {
		List<Country> c = (List<Country>) repo.findAll();
		return c;

	}

	@RequestMapping("/findbyidgreaterthan/{id}")
	public List<Country> findByIdGreaterThan(@PathVariable int id) {
		List<Country> list = repo.findByIdGreaterThan(id);
		return list;
	}

	@RequestMapping("/findbyname/{name}")
	public List<Country> findByName(@PathVariable String name) {

		List<Country> ls = repo.findByName(name);
		return ls;
	}

	/*@RequestMapping("/findbynamecode/{code},{name}")
	
	public List<Country> findByCodeName(@PathVariable String code, @PathVariable String name)
	{
		List<Country> lis = repo.findByCodeAndName(code, name);
		return lis;

	}
*/
	@RequestMapping("/findbynamecode")

	public List<Country> findByCodeName(@RequestParam String code, @RequestParam String name) {
		List<Country> lis = repo.findByCodeAndName(code, name);
		return lis;

	}


	public static void main(String[] args) {

		SpringApplication.run(MainApp.class, args);
	}
}
