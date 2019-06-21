package br.com.manager.teste.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.manager.teste.bean.Pais;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Integer>{
	
	List<Pais> findAll();
//	@SuppressWarnings("unchecked")
//	Pais save(Pais pais);

}