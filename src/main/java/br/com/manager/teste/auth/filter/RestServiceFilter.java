package br.com.manager.teste.auth.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.ext.Provider;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class RestServiceFilter extends AuthenticationFilter {

	@Override
	protected void validateToken(String token) throws Exception {
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
	}

//	@Override
//	public void filter(ContainerRequestContextrequestContext) throws IOException {
//
////		final HttpSession session = webRequest.getSession();
////		String salt = requestContext.getHeaderString("csrfPreventionSalt");
//
////		// Validate that the salt is in the cache
////		@SuppressWarnings("unchecked")
////		Cache<String, Boolean> csrfPreventionSaltCache = (Cache<String, Boolean>) session.getAttribute("csrfPreventionSaltCache");
////		try {
////			// Valida o CSRF
////			validadeCsrfToken(csrfPreventionSaltCache, salt);
////		} catch (Exception e) {
////			abortWithUnauthorizedTEST(requestContext);
////		}
//
//
//
//		//Pega o header de autenticação do cabeçalho da requisição
//		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
//		// Valida o header de autenticação
//		if (!isTokenBasedAuthentication(authorizationHeader)) {
//			abortWithUnauthorized(requestContext);
//			return;
//		}
//		// Extrai o token do cabeçalho de autenticação
//		String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();
//		try {
//			// Valida o token
//			validateToken(token);
//		} catch (Exception e) {
//			abortWithUnauthorized(requestContext);
//		}
//	}
//
//	@Override
//	public void validateToken(String token) throws Exception {
//		TokenValidator tokenValidator = TokenValidator.build();
//		TokenData t = tokenValidator.validate(token);
//		if(!t.isValid()) {
//			throw new AccessPermissionException();
//		}
//	}

}
