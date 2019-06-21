package br.com.manager.teste.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.manager.teste.auth.filter.Secured;
import br.com.manager.teste.bean.UsuarioAutenticado;
import br.com.manager.teste.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuario/")
@Api(value = "usuario")
public class UsuarioRestService {
	
	@Autowired
	UsuarioService usuarioService;
	
	@ApiOperation(value = "Autenticar usuário.")
	@PostMapping(value = "autenticar/{login}/{senha}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UsuarioAutenticado autenticar(@PathVariable String login, @PathVariable String senha) {
		return usuarioService.autenticar(login, senha);
    }
	
	@Secured
	@ApiOperation(value = "Renovar token.")
	@GetMapping(value = "renovar-ticket/{token}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public boolean listar(@PathVariable String token) {
		return usuarioService.renovarTicket(token);
    }

}
