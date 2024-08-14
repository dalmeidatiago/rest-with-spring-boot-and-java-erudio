package br.com.dalmeida.tiago.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dalmeida.tiago.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
