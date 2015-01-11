/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.controller;

import eventmanager.dao.ActivityDAO;
import eventmanager.dao.EventDAO;
import eventmanager.model.Activity;
import eventmanager.model.Event;
import eventmanager.model.User;
import java.util.ArrayList;
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
public class EventController {
    EventDAO eventDAO = new EventDAO();
    ActivityDAO activityDAO = new ActivityDAO();
    
    @RequestMapping(value="/Event/addForm")
    public ModelAndView eventForm(){
        ModelAndView modelAndView = new ModelAndView("/Event/addForm","event",new Event());
        modelAndView.addObject("action", "add");
        modelAndView.addObject("button", "Add");
        modelAndView.addObject("atividades", activityDAO.getAllActivities());
        return modelAndView;
    }
    
    @RequestMapping(value = "/Event/add",method = RequestMethod.POST)
    public ModelAndView addPost(@ModelAttribute Event event,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/Event/addForm");
        String [] aux = event.getAtividade();
        User user = (User)session.getAttribute("usuario_logado");
        event.setCriador(user);
        List<Activity> atividades = activityDAO.getAllActivities();
        for (Activity atividade : atividades) {
            for (String aux1 : aux) {
                if(atividade.getNome().equals(aux1)){
                    event.addAtividade(atividade);
                }
            }    
        }
        eventDAO.add(event);
        modelAndView.addObject("action", "add");
        modelAndView.addObject("button", "Add");
        modelAndView.addObject("atividades", atividades);
        modelAndView.addObject("message", "evento adicionado com sucesso");
        return modelAndView;
    }
    
    @RequestMapping(value = "/Event/List")
    public ModelAndView allUsers(){
        ModelAndView modelAndView = new ModelAndView("/Event/list");
        List events = eventDAO.getAllEvents();
        modelAndView.addObject("events", events);
        return modelAndView;
    }
    
    @RequestMapping(value = "/Event/editForm/{id}")
    public ModelAndView editForm(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/Event/addForm");
        Event event = eventDAO.getEventById(id);
        modelAndView.addObject("event", event);
        modelAndView.addObject("button", "Save");
        modelAndView.addObject("atividades", activityDAO.getAllActivities());
        modelAndView.addObject("action", "edit/"+id);
        return modelAndView;
    }
    
    @RequestMapping(value = "/Event/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute Event event,@PathVariable int id,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("forward:/Event/List");
        event.setId(id);
        String [] aux = event.getAtividade();
        User user = (User)session.getAttribute("usuario_logado");
        event.setCriador(user);
        List<Activity> atividades = activityDAO.getAllActivities();
        for (Activity atividade : atividades) {
            for (String aux1 : aux) {
                if(atividade.getNome().equals(aux1)){
                    event.addAtividade(atividade);
                }
            }
        }
        eventDAO.edit(event);
        List events = eventDAO.getAllEvents();
        modelAndView.addObject("events", events);
        modelAndView.addObject("message", "Alteracao de dados concluida");
        return modelAndView;
    }
    
    @RequestMapping(value = "/Event/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("forward:/Event/List");
        Event user = eventDAO.getEventById(id);
        eventDAO.delete(user);
        List events = eventDAO.getAllEvents();
        modelAndView.addObject("events", events);
        modelAndView.addObject("message", "Evento deletado com sucesso");
        return modelAndView;
    }

}
