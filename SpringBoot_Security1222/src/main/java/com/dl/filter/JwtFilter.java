package com.dl.filter;

import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dl.service.JwtService;
import com.dl.service.MyUserDetailsService;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component

public class JwtFilter implements Filter{
	
	@Autowired
	ApplicationContext context;
	@Autowired
	private JwtService jwtService;
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest httpRequest = (HttpServletRequest) request;
//		HttpServletResponse httpResponse = (HttpServletResponse) response;
//		 String path = httpRequest.getRequestURI();
//		    // Skip JWT processing for SAML2 URLs (modify path to match your SAML2 endpoint pattern)
//		    if (path.startsWith("/saml2") || path.equals("/saml2/login")) {
//		        chain.doFilter(request, response);
//		        return;
//		    }
//		  String authHeader =((HttpServletRequest) request).getHeader("Authorization");
//		  String token =null;
//		  String username =null;
//		  
//		  if (authHeader !=null && authHeader.startsWith("Bearer ")) {
//			  token = authHeader.substring(7);
//			  try {
//		            username = jwtService.extractUserName(token);
//		        } catch (io.jsonwebtoken.ExpiredJwtException e) {
//		            // If the token is expired, return 401 Unauthorized with "Token Expired" message
//		            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//		            httpResponse.setContentType("application/json");
//		            httpResponse.getWriter().write("{\"message\": \"Token Expired\"}");
//		            httpResponse.getWriter().flush();
//		            return;
//		        }
//		  }
//
//		  if (username !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
//			 
//			  UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(username);
//			  if (jwtService.validateToken(token,userDetails)) {
//				  UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) request));
//				SecurityContextHolder.getContext().setAuthentication(authToken);
//				  
//				  
//			  }else if (jwtService.isTokenExpired(token)) {
//				    HttpServletResponse httpResponse1 = (HttpServletResponse) response;
//				    httpResponse1.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//				    response.getWriter().write("Token has expired");
//				    return;
//				}else {
//	                // Return 403 Forbidden if JWT is invalid
//				  httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
//	              //  response.getWriter().write("Invalid token");
//				  httpResponse.setContentType("application/json");
//		            httpResponse.getWriter().write("{\"message\": \"Invalid token\"}");
//		            httpResponse.getWriter().flush();
//	                return;
//	            }
//			  
//		  }
//		  
//		  chain. doFilter(request, response);
//		
//	}
	
    
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		  String authHeader =request.getHeader("Authorization");
//		  String token =null;
//		  String username =null;
//		  
//		  if (authHeader !=null && authHeader.startsWith("Bearer ")) {
//			  token = authHeader.substring(7);
//			  username = jwtService.extractUserName(token);
//		  }
//
//		  if (username !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
//			 
//			  UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(username);
//			  if (jwtService.validateToken(token,userDetails)) {
//				  UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				SecurityContextHolder.getContext().setAuthentication(authToken);
//				  
//				  
//			  }
//			  
//		  }
//		  
//		 filterChain. doFilter(request, response);
//	}
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
		throws IOException, ServletException {
	 String authHeader =((HttpServletRequest) request).getHeader("Authorization");
	  String token =null;
	  String username =null;
	  String requestUri = ((HttpServletRequest) request).getRequestURI();
	    if (requestUri.startsWith("/")) {
	        filterChain.doFilter(request, response);  // Continue the filter chain for SAML2 requests
	        return;  // Return early to avoid unnecessary JWT validation
	    }

	  
	  if (authHeader !=null && authHeader.startsWith("Bearer ")) {
		  token = authHeader.substring(7);
		  username = jwtService.extractUserName(token);
	  }

	  if (username !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
		 
		  UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(username);
		  if (jwtService.validateToken(token,userDetails)) {
			  UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) request));
			SecurityContextHolder.getContext().setAuthentication(authToken);
			  
			  
		  }
		  
	  }
	  
	 filterChain. doFilter(request, response);
}
}
