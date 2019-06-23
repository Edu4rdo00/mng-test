package br.com.manager.teste.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.manager.teste.bean.Pais;
import br.com.manager.teste.service.PaisService;
import br.com.manager.teste.utils.AccessPermissionValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pais/")
@Api(value = "pais")
public class PaisRestController {

	@Autowired
	PaisService paisService;

	@ApiOperation(value = "Busca lista de países.")
	@GetMapping(value = "listar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> listar(@RequestParam("token") String token) {
		ResponseEntity<Object> response;
		try {
			response = new ResponseEntity<Object>(paisService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@ApiOperation(value = "Pesquisar pais por nome.")
	@GetMapping(value = "pesquisar/{nome}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> findByName(@PathVariable String nome, @RequestParam("token") String token) {
		ResponseEntity<Object> response;
		try {
			response = new ResponseEntity<Object>(paisService.findByName(nome), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		return response;
	}

	@ApiOperation(value = "Salvar pais.")
	@PostMapping(value = "salvar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> salvar(@RequestBody Pais pais, @RequestParam("token") String token) {
		ResponseEntity<Object> response;
		try {
			AccessPermissionValidator.checkAccessAdminPermission(token);
			response = new ResponseEntity<Object>(paisService.save(pais), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		return response;
	}

	@ApiOperation(value = "Excluir pais.")
	@GetMapping(value = "excluir/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> remove(@PathVariable int id, @RequestParam("token") String token) {
		ResponseEntity<Object> response;
		try {
			AccessPermissionValidator.checkAccessAdminPermission(token);
			response = new ResponseEntity<Object>(paisService.deleteById(id), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		return response;
	}

}
