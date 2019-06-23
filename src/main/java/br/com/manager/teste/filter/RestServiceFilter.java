package br.com.manager.teste.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import br.com.manager.teste.bean.UsuarioAutenticado;
import br.com.manager.teste.controller.Controller;
import br.com.manager.teste.exception.AccessPermissionException;

@Component
@Order(1)
public class RestServiceFilter implements Filter  {

	private void validateToken(UsuarioAutenticado user) throws Exception {
		if(user == null) {
			throw new AccessPermissionException("Token inválido");
		}else if(user.getExpiracao().before(new Date())) {
			throw new AccessPermissionException("Token expirado");
		}
	}

	private void existsToken(String token) throws Exception {
		if(token == null) {
			throw new AccessPermissionException("Token não informado");
		}
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		if(request.getRequestURI().contains("/pais/")) {
			String token = request.getParameter("token");
			try {
				existsToken(token);
				validateToken(Controller.getInstance().getUsuarioAutenticadoMap().get(token));
			} catch (Exception e) {
				response.sendError(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
				return;
			}
		}
		chain.doFilter(request, response);
	}

}
