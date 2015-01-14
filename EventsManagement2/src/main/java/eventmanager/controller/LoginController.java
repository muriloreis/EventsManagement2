/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.controller;

import eventmanager.dao.EventDAO;
import eventmanager.dao.UserDAO;
import eventmanager.model.Busca;
import eventmanager.model.Login;
import eventmanager.model.User;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Murilo
 */
@Controller
public class LoginController {
    UserDAO userDAO = new UserDAO();
    
    @RequestMapping(value = "/loginForm")
    public ModelAndView loginForm(){
        ModelAndView modelAndView = new ModelAndView("login","login",new Login());
        return modelAndView;
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute Login login,HttpSession session){
        ModelAndView modelAndView;
        User user = userDAO.getUserByUsername(login.getUsername());
        if(user == null){
           modelAndView = new ModelAndView("login","login",login);
           modelAndView.addObject("message", "Usuario: "+login.getUsername()+" inexistente");
        } else {
            if(user.getPassword().equals(login.getPassword())){
                session.setAttribute("usuario_logado", user);
                modelAndView = new ModelAndView("menu");
                // Setando Parametros da Pagina
                modelAndView.addObject("usuario", user.getNome());
                modelAndView.addObject("events", new EventDAO().getAllEvents());
                modelAndView.addObject("nomeEvento", new Busca());
                
                return RenderView.getInstance().renderMenuViewUser(user, modelAndView);
            } else {
                modelAndView = new ModelAndView("login","login",login);
                modelAndView.addObject("message", "Senha Incorreta");     
            }
        }
        return modelAndView;
    }
    
    
}
