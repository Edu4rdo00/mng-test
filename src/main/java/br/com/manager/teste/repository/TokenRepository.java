package br.com.manager.teste.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.manager.teste.bean.Token;

@Repository
public interface TokenRepository extends CrudRepository<Token, Integer>{

}
