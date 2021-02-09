package com.ba.filter;

import com.ba.service.CustomUserDetailService;
import com.ba.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIwMDAiLCJleHAiOjE2MTI4OTIxNzAsImlhdCI6MTYxMjg1NjE3MH0.HCT6ILaPoczepG55lRgODf_8dV-amxIi7STeHzIzowM

        String autherizationHeader = request.getHeader("Authorization");
        String token = null;
        String tc = null;
        if (autherizationHeader != null && autherizationHeader.startsWith("Bearer")) {
            token = autherizationHeader.substring(7);
            tc = jwtUtil.extractUsername(token);
        }

        if (tc != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = customUserDetailService.loadUserByUsername(tc);

            if (jwtUtil.validateToken(token, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
