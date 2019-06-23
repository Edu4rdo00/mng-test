package br.com.manager.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.manager.teste.bean.Token;

@Repository
@SuppressWarnings("unchecked")
public interface TokenRepository extends CrudRepository<Token, Integer>{

	List<Token> findAll();
	@Query(value = " SELECT t.* FROM token t WHERE t.id_usuario = :idUser ", nativeQuery = true)
	Token findByUser(@Param("idUser") int idUser);
	@Query(value = " SELECT t.* FROM token t WHERE t.token = :token ", nativeQuery = true)
	Token findByToken(@Param("token") String token);
	Token save(Token token);
	void deleteById(int id);
	boolean existsById(int id);
}
