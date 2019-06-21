package br.com.manager.teste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.manager.teste.bean.Pais;
import br.com.manager.teste.repository.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService  {

	@Autowired
	private PaisRepository paisRepository;
	
	@Override
	public List<Pais> getAll() {
		return paisRepository.findAll();
	}

	@Override
	public Pais save(Pais pais) {
		return null;
	}

	@Override
	public List<Pais> findByName(String name) {
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		return false;
	}

	@Override
	public boolean existsById(int id) {
		return false;
	}


}
