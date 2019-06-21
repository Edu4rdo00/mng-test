package br.com.manager.teste.service;

import java.util.List;

import br.com.manager.teste.bean.Pais;

public interface PaisService {
	
    public List<Pais> getAll();
    public Pais save(Pais pais);
    public List<Pais> findByName(String name);
	public boolean deleteById(int id);
	public boolean existsById(int id); 
    
}