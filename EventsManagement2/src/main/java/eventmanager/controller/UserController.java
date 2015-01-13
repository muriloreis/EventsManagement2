/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.controller;

import eventmanager.dao.EventDAO;
import eventmanager.dao.UserDAO;
import eventmanager.model.Busca;
import eventmanager.model.User;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Murilo
 */
@Controller
public class UserController {
    UserDAO userDAO = new UserDAO();
    
    @RequestMapping(value = "/User/addForm")
    public ModelAndView userForm(){
        ModelAndView modelAndView = new ModelAndView("/User/addForm","user",new User());
        modelAndView.addObject("action", "add");
        modelAndView.addObject("button", "Add");
        return modelAndView;
    }
    
    @RequestMapping(value = "/User/add",method = RequestMethod.POST)
    public ModelAndView addPost(@ModelAttribute User user){
        ModelAndView modelAndView = new ModelAndView("/User/addForm");
        userDAO.add(user);
        modelAndView.addObject("action", "add");
        modelAndView.addObject("button", "Add");
        modelAndView.addObject("message", "usuario adicionado com sucesso");
        return modelAndView;
    }
    
    @RequestMapping(value = "/User/List")
    public ModelAndView allUsers(){
        ModelAndView modelAndView = new ModelAndView("/User/list");
        List users = userDAO.getAllUsers();
        modelAndView.addObject("users", users);
        return modelAndView;
    }
    
    @RequestMapping(value = "/User/editForm/{id}")
    public ModelAndView editForm(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/User/addForm");
        User user = userDAO.getUserById(id);
        modelAndView.addObject("user", user);
        modelAndView.addObject("button", "Save");
        modelAndView.addObject("action", "edit/"+id);
        return modelAndView;
    }
    
    @RequestMapping(value = "/User/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute User user,@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("forward:/User/List");
        System.out.println("ID: "+user.getIduser());
        user.setIduser(id);
        userDAO.edit(user);
        List users = userDAO.getAllUsers();
        modelAndView.addObject("users", users);
        modelAndView.addObject("message", "Alteracao de dados concluida");
        return modelAndView;
    }
    
    @RequestMapping(value = "/User/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("forward:/User/List");
        User user = userDAO.getUserById(id);
        userDAO.delete(user);
        List users = userDAO.getAllUsers();
        modelAndView.addObject("users", users);
        modelAndView.addObject("message", "usuario deletado com sucesso");
        return modelAndView;
    }
    
    @RequestMapping(value = "/User/eventos")
    public ModelAndView eventos(HttpSession session){
        User user = (User)session.getAttribute("usuario_logado");
        ModelAndView modelAndView = new ModelAndView("menu");
        //Setando Parametros da Pagina
        
        modelAndView.addObject("usuario", user.getNome());
        modelAndView.addObject("events", userDAO.getUserById(user.getIduser()).getMeusEventos() );
        modelAndView.addObject("nomeEvento", new Busca());
        
        //Setando Interface
        modelAndView.addObject("message", "Meus Eventos");
        modelAndView.addObject("link1","menu");
        modelAndView.addObject("link1Label","Menu");
        modelAndView.addObject("link2","inscricoes");
        modelAndView.addObject("link2Label","Minhas Inscricoes");
        return modelAndView;
    }
    
    @RequestMapping(value = "/User/menu")
    public ModelAndView menu(HttpSession session){
        User user = (User)session.getAttribute("usuario_logado");
        ModelAndView modelAndView = new ModelAndView("menu");
        //Setando Parametros da Pagina
        modelAndView.addObject("usuario", user.getNome());
        modelAndView.addObject("events", new EventDAO().getAllEvents());
        modelAndView.addObject("nomeEvento", new Busca());
        
        //Setando Interface
        modelAndView.addObject("link1","eventos");
        modelAndView.addObject("link1Label","Meus Eventos");
        modelAndView.addObject("link2","inscricoes");
        modelAndView.addObject("link2Label","Minhas Inscricoes");
        return modelAndView;
    }
    
    @RequestMapping(value = "/User/inscricoes")
    public ModelAndView inscricoes(HttpSession session){
        User user = (User)session.getAttribute("usuario_logado");
        ModelAndView modelAndView = new ModelAndView("menu");
        //Setando Parametros da Pagina
        modelAndView.addObject("usuario", user.getNome());
        modelAndView.addObject("events", userDAO.getUserById(user.getIduser()).getMinhasInscricoes());
        modelAndView.addObject("nomeEvento", new Busca());
        
        //Setando Interface
        modelAndView.addObject("message", "Minhas Inscricoes");
        modelAndView.addObject("link1","menu");
        modelAndView.addObject("link1Label","Menu");
        modelAndView.addObject("link2","eventos");
        modelAndView.addObject("link2Label","Meus Eventos");
        return modelAndView;
    }
    
}
