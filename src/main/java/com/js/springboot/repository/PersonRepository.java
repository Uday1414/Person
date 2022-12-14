package com.js.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.js.springboot.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
