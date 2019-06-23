package br.com.manager.teste.utils;

import br.com.manager.teste.bean.UsuarioAutenticado;
import br.com.manager.teste.controller.Controller;
import br.com.manager.teste.exception.AccessPermissionException;

public class AccessPermissionValidator {
	
	public static void checkAccessAdminPermission(String token) throws AccessPermissionException {
		UsuarioAutenticado user = Controller.getInstance().getUsuarioAutenticadoMap().get(token);
		if(user == null || !user.isAdministrador()){
			throw new AccessPermissionException();
		}
	}

}
