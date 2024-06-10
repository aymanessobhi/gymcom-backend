package com.ideracloud.gymcom.security;


import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Value("${jwt.header.string}")
	public String HEADER_STRING;

	@Value("${jwt.token.prefix}")
	public String TOKEN_PREFIX;

	@Resource(name = "userService")
	private UserDetailsService userDetailsService;

	@Autowired
	private TokenProvider jwtTokenUtil;



	@Override
	protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {




		String header = request.getHeader(HEADER_STRING);
		String username = null;
		String authToken = null;





		if (header != null && header.startsWith(TOKEN_PREFIX)) {
			authToken = header.replace(TOKEN_PREFIX, "");

			try {
				username = jwtTokenUtil.getUsernameFromToken(authToken);
			} catch (IllegalArgumentException e) {
				logger.error("Error occurred while retrieving Username from Token", e);
			} catch (ExpiredJwtException e) {
				logger.warn("The token has expired", e);
			}
		} else {
			logger.warn("Bearer string not found, ignoring the header");
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);

			if (jwtTokenUtil.validateToken(authToken, userDetails)) {
				UsernamePasswordAuthenticationToken authentication = jwtTokenUtil.getAuthenticationToken(authToken, SecurityContextHolder.getContext().getAuthentication(), userDetails);
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				logger.info("User authenticated: " + username + ", setting security context");
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}

		filterChain.doFilter(request, response);

	}
}