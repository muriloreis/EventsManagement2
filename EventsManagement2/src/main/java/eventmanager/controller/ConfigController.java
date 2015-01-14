/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.controller;

import eventmanager.model.Busca;
import eventmanager.model.User;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Murilo
 */
@Controller
public class ConfigController {
    
    @RequestMapping(value = "/User/config")
    public ModelAndView config(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("index");
        User user = (User)session.getAttribute("usuario_logado");
        modelAndView.addObject("usuario", user.getNome());
        modelAndView.addObject("link", true);
        modelAndView.addObject("nomeEvento", new Busca());
        return RenderView.getInstance().renderConfigViewUser(user, modelAndView);
    }
}
