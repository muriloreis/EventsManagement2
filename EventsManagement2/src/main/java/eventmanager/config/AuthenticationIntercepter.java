/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Murilo
 */
public class AuthenticationIntercepter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if(request.getSession().getAttribute("usuario_logado") == null){
            String uri = request.getRequestURI();
            if(uri.endsWith("/login") || uri.endsWith("/loginForm") || uri.endsWith("/EventsManagement2")){
                return true;
            }
            response.sendRedirect("/EventsManagement2/loginForm");
            return false;
            
        } else {
            return true;
        }
    }

 }