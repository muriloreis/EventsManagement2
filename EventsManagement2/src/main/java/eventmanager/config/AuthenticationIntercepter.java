/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.config;

import eventmanager.model.User;
import eventmanager.model.UserType;
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
        User user = (User)request.getSession().getAttribute("usuario_logado");
        if(user == null){
            String uri = request.getRequestURI();
            if(uri.endsWith("/login") || uri.endsWith("/loginForm")){
                return true;
            }
            response.sendRedirect("/EventsManagement2/loginForm");
            return false;
            
        } else {
            String uri = request.getRequestURI();
            if(uri.endsWith("/loginForm") || uri.endsWith("/EventsManagement2/login")){
                response.sendRedirect("/EventsManagement2/User/menu");
                return false;
            }
            if(user.getType() == UserType.EMPRESA){
                if(uri.endsWith("/config") || uri.contains("/User/delete")
                   || uri.contains("/User/edit") ){
                    response.sendRedirect("/EventsManagement2/User/menu");
                    return false;
                }
            } else if(user.getType() == UserType.PARTICIPANTE){
                if(uri.endsWith("/config") || uri.contains("/User/delete")
                   || uri.contains("/User/edit") || uri.contains("/Event/delete") 
                   || uri.contains("/Event/edit")){
                    response.sendRedirect("/EventsManagement2/User/menu");
                    return false;
                }
            }
            return true;
        }
    }

 }
