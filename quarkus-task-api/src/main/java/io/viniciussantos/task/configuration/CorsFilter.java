package com.viniciussantos.emprestimosAPI.config;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Provider
@ApplicationScoped
public class CorsFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		List<String> allowedOrigins = Arrays.asList("*");

		responseContext.getHeaders().add("Access-Control-Allow-Origin", String.join(",", allowedOrigins));
		responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
		responseContext.getHeaders().add("Access-Control-Allow-Headers", "Authorization, Content-Type, X-Requested-With");
		responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");

		if (requestContext.getMethod().equals("OPTIONS")) {
			responseContext.setStatus(javax.ws.rs.core.Response.Status.OK.getStatusCode());
		}
	}
}
