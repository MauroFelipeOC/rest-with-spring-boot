package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@Modifying //operações que não são nativas do spring data precisam dessa anotação
	@Query("UPDATE Person p SET p.enabled = false WHERE p.id =:id")
	void disablePerson(@Param("id") Long id);
}
