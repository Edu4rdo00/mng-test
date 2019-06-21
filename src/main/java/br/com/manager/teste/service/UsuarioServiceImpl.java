package br.com.manager.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.manager.teste.bean.Token;
import br.com.manager.teste.bean.Usuario;
import br.com.manager.teste.bean.UsuarioAutenticado;
import br.com.manager.teste.controller.Controller;
import br.com.manager.teste.repository.TokenRepository;
import br.com.manager.teste.repository.UsuarioRepository;
import br.com.manager.teste.utils.TokenUtils;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired 
	private TokenRepository tokenRepository;

	@Override
	public UsuarioAutenticado autenticar(String login, String senha) {
		UsuarioAutenticado usuarioAutenticado = new UsuarioAutenticado();
		Usuario usuario = usuarioRepository.autenticar(login, senha);
		if(usuario != null) {
			Token token = tokenRepository.findByUser(usuario.getId());
			usuarioAutenticado.setAdministrador(usuario.isAdministrador());
			usuarioAutenticado.setAutenticado(true);
			usuarioAutenticado.setExpiracao(TokenUtils.generateTokenDateExpiration());
			usuarioAutenticado.setLogin(usuario.getLogin());
			usuarioAutenticado.setToken("aaaaaaaaaaaa"+usuario.getNome());
			Controller.getInstance().getUsuarioAutenticadoMap().put(usuarioAutenticado.getToken(), usuarioAutenticado);
			if(token == null) {
				token = new Token();
			}
			token.setExpiracao(usuarioAutenticado.getExpiracao());
			token.setToken(usuarioAutenticado.getToken());
			token.setUsuario(usuario);
			tokenRepository.save(token);
		}
		return usuarioAutenticado;
	}

	@Override
	public boolean renovarTicket(String tokenValue) {
		Token token = tokenRepository.findByToken(tokenValue);
		if(token != null) {
			token.setExpiracao(TokenUtils.generateTokenDateExpiration());
			Controller.getInstance().getUsuarioAutenticadoMap().get(tokenValue).setExpiracao(token.getExpiracao());
			tokenRepository.save(token);
			return true;
		}else {
			return false;
		}
	}

}
