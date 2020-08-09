package com.personsimplespringboot.personsimplespringbootapplication.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.personsimplespringboot.personsimplespringbootapplication.model.Person;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
	
	//http://localhost:8080/person/hello
	@GetMapping("/hello")
	public String hello() {
		return "Hello Person";
	}
	
	//http://localhost:8080/person/dummy
	@GetMapping("/dummy")
	public Person getPerson() {
		return new Person(1,"dummy",23);
	}
	
	//http://localhost:8080/person/id/1/name/abc/age/23
	@GetMapping("/id/{id}/name/{name}/age/{age}")
	public Person getPerson(@PathVariable int id, @PathVariable String name, @PathVariable int age) {
		return new Person(id, name, age);
	}

	//http://localhost:8080/person/all
	@GetMapping("/all")
	public List<Person> getAllPerson() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1,"shafa",23));
		persons.add(new Person(2,"shadab",24));
		return persons;
	}
	
	/**
     * POST CALL
     *
     * http://localhost:8080/person/save
     * Body
     * {
     * 	"id":3,
     * 	"name":"shireen",
     * 	"age":24
     * }
     * Headers
     * Content-Type : application/json
     *
     */
	@PostMapping("/save")
	public Person create(@RequestBody Person person) {
		System.out.println(person);
		return person;
	}
}
