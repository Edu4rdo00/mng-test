package br.com.manager.teste.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.manager.teste.bean.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

}
