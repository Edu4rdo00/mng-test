package br.com.manager.teste.auth.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public abstract class AuthenticationFilter implements ContainerRequestFilter  {
	@Context
	public HttpServletRequest webRequest;
	
	protected static final String REALM = "Token de acesso inválido.";

	/**
	 * Validar token, lançar exceção caso seja invalido.
	 * @param token
	 * @throws Exception
	 */
	protected abstract void validateToken(String token) throws Exception;
	public abstract void filter(ContainerRequestContext requestContext) throws IOException;

	/**
	 * 
	 * @param authorizationHeader
	 * @return
	 */
	protected boolean isTokenBasedAuthentication(String authorizationHeader) {
		// Verifica se o cabeçalho da autenticação é válido
		return authorizationHeader != null;
	}

	/**
	 * 
	 * @param requestContext
	 */
	protected void abortWithUnauthorized(ContainerRequestContext requestContext) {
		// Cria resposta de acesso negado caso o token não seja valido
		requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
				.header(HttpHeaders.WWW_AUTHENTICATE, " realm=\"" + REALM + "\"")
				.entity("{\"authenticationStatus\":false,\"description\":\"Acesso negado!\"}").type(MediaType.APPLICATION_JSON)
				.build());
	}

}
