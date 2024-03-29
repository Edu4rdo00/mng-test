package br.com.manager.teste.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.manager.teste.bean.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

	@Query(" SELECT u FROM Usuario u WHERE u.login=:login and u.senha=:senha")
	Usuario autenticar(@Param("login") String login, @Param("senha") String senha);
}
