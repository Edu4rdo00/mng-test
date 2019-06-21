package br.com.manager.teste.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.manager.teste.bean.Pais;
import br.com.manager.teste.service.PaisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pais/")
@Api(value = "pais")
public class PaisRestService {
	
	@Autowired
	PaisService paisService;
	
	@ApiOperation(value = "Busca lista de países.")
	@GetMapping(value = "listar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Pais> listar() {
		List<Pais> paisList = paisService.getAll();
		return paisList;
    }
	
	@ApiOperation(value = "Excluir pais.")
	@GetMapping(value = "excluir/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public boolean remove(@PathVariable int id) {
		return true;
    }
	
	@ApiOperation(value = "Pesquisar pais por nome.")
	@GetMapping(value = "pesquisar/{nome}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Pais> findByName(@PathVariable String nome) {
		List<Pais> paisList = paisService.getAll();
		return paisList;
    }
	
	@ApiOperation(value = "Salvar pais.")
	@PostMapping(value = "salvar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Pais autenticar(@RequestBody Pais pais) {
		return new Pais();
    }

}
