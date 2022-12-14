package com.js.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.js.springboot.dao.PersonDao;
import com.js.springboot.dto.Person;
import com.js.springboot.dto.ResponseStructure;
import com.js.springboot.exception.NoIdFoundException;
@Service
public class PersonService {
	
	@Autowired
	PersonDao personDao;
	
	public ResponseStructure<Person> savePerson(Person p) {
		ResponseStructure<Person> pResponseStructure = new ResponseStructure<>();
		Person person = personDao.savePerson(p);
		if(person!=null) {
			pResponseStructure.setStatusCode(HttpStatus.CREATED.value());
			pResponseStructure.setMessage("Data Saved Succesfully");
			pResponseStructure.setData(person);
			return pResponseStructure;
		}else {
			pResponseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
			pResponseStructure.setMessage("Data Failed to Save");
			pResponseStructure.setData(person);
			return pResponseStructure;
		}
	}
	
	public ResponseStructure<List<Person>> getAllPersons(){
		ResponseStructure<List<Person>> pResponseStructure = new ResponseStructure<>();
		List<Person> persons = personDao.getAllPersons();
		if(persons.size()>0) {
			pResponseStructure.setStatusCode(HttpStatus.FOUND.value());
			pResponseStructure.setMessage("All Persons Data");
			pResponseStructure.setData(persons);
			return pResponseStructure;
		}else {
			pResponseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			pResponseStructure.setMessage("No Persons Found");
			pResponseStructure.setData(persons);
			return pResponseStructure;
		}
	}
	
	public ResponseStructure<Person> getPersonById(int id) {
		ResponseStructure<Person> pResponseStructure = new ResponseStructure<>();
		Person person = personDao.getPersonById(id);
		if(person!=null) {
			pResponseStructure.setStatusCode(HttpStatus.FOUND.value());
			pResponseStructure.setMessage("Found the Person");
			pResponseStructure.setData(person);
			return pResponseStructure;
		}else {
			throw new NoIdFoundException("No Person With Given Id");
		}
	}
	
	public ResponseStructure<String> deleteById(int id) {
		ResponseStructure<String> pResponseStructure = new ResponseStructure<>();
		boolean b = personDao.deleteById(id);
		if(b) {
			pResponseStructure.setStatusCode(HttpStatus.FOUND.value());
			pResponseStructure.setMessage("Found the Person");
			pResponseStructure.setData("Deleted");
			return pResponseStructure;
		}else {
			pResponseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			pResponseStructure.setMessage("No Person Found");
			pResponseStructure.setData("Not Found");
			return pResponseStructure;
		}
	}
	
	public ResponseStructure<Person> updateById(int id , Person p) {
		ResponseStructure<Person> pResponseStructure = new ResponseStructure<>();
		Person person = personDao.updateById(id, p);
		if(person!=null) {
			pResponseStructure.setStatusCode(HttpStatus.FOUND.value());
			pResponseStructure.setMessage("Updated");
			pResponseStructure.setData(person);
			return pResponseStructure;
		}else {
			pResponseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			pResponseStructure.setMessage("No Person Found");
			pResponseStructure.setData(person);
			return pResponseStructure;
		}
	}
}
