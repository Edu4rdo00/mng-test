package br.com.manager.teste.controller;

import java.util.HashMap;

import br.com.manager.teste.bean.UsuarioAutenticado;

public class Controller {
	
	private static volatile Controller controller;
	
	/** Lista usuários autenticados **/
	private HashMap<String, UsuarioAutenticado> usuarioAutenticadoMap = new HashMap<String, UsuarioAutenticado>();
	
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

	public HashMap<String, UsuarioAutenticado> getUsuarioAutenticadoMap() {
		return usuarioAutenticadoMap;
	}
	
}
