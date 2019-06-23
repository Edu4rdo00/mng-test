package br.com.manager.teste.controller;

import java.util.concurrent.ConcurrentHashMap;

import br.com.manager.teste.bean.UsuarioAutenticado;

public class Controller {

	private static volatile Controller controller;

	private ConcurrentHashMap<String, UsuarioAutenticado> usuarioAutenticadoMap = new ConcurrentHashMap<String, UsuarioAutenticado>();

	private Controller(){
	}

	public static Controller getInstance(){
		synchronized (Controller.class) {
			if(controller == null){
				controller = new Controller();
				controller.init();
			}
		}
		return controller;
	}

	private void init(){
	}

	public ConcurrentHashMap<String, UsuarioAutenticado> getUsuarioAutenticadoMap() {
		return usuarioAutenticadoMap;
	}

}
