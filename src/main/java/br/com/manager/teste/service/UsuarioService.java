package br.com.manager.teste.service;

import br.com.manager.teste.bean.UsuarioAutenticado;

public interface UsuarioService {
	
	public UsuarioAutenticado autenticar(String login, String senha);
	public boolean renovarTicket(String token);

}
