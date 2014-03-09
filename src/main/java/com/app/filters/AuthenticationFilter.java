package com.app.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenticationFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Init Authentication Filter");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		
		System.out.println("here: ");
/*		BufferedReader reader = request.getReader();
		String line = reader.readLine();
		while(line != null) {
			
			System.out.println(line);
			line = reader.readLine();
		}*/
		
/*		System.out.println("Filterring....");
		String username = ((HttpServletRequest)request).getHeader("username");
		String password = ((HttpServletRequest)request).getHeader("password");
		if("someUsername".equals(username) && "somePassword".equals(password)) {*/
			chain.doFilter(request, response);
/*		} else {
			response.getOutputStream().println("Unauthorized");
			return;
		}*/
		
	}

	public void destroy() {
		
		System.out.println("Destroying....");
	}

}
