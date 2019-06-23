package br.com.manager.teste.exception;

public class AccessPermissionException extends Exception {

	private static final long serialVersionUID = 6940721177402348669L;
	private static String msg = "";

	public AccessPermissionException(String exception) {
		super(exception);  
		msg = exception;  
	}

	public AccessPermissionException() {
		msg = "{\"message\": \"O usuário não possui permissão para executar esta ação.\"}";
	}

	public String getMessage(){
		return msg;  
	}  

}

