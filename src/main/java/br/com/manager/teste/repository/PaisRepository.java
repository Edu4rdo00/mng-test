package br.com.manager.teste.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.manager.teste.bean.Pais;
@SuppressWarnings("unchecked")
@Repository
public interface PaisRepository extends CrudRepository<Pais, Integer>{
	
	List<Pais> findAll();
	List<Pais> findByName(String name);
	Pais save(Pais pais);
	void deleteById(int id);
	boolean existsById(int id);

}