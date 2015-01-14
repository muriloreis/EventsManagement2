/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.controller;

import eventmanager.dao.ActivityDAO;
import eventmanager.model.Activity;
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
public class ActivityController {
    ActivityDAO activityDAO = new ActivityDAO();
    
    @RequestMapping(value="/Activity/addForm")
    public ModelAndView activityForm(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/Activity/addForm","activity",new Activity());
        User user = (User)session.getAttribute("usuario_logado");
        modelAndView.addObject("usuario", user.getNome());
        modelAndView.addObject("nomeEvento", new Busca());
        //-----------------------------------------------------------------
        modelAndView.addObject("action", "add");
        modelAndView.addObject("button", "Add");
        return RenderView.getInstance().renderConfigEditViewUser(user, modelAndView);
    }
    
    @RequestMapping(value = "/Activity/add",method = RequestMethod.POST)
    public ModelAndView addPost(@ModelAttribute Activity activity,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/Activity/addForm");
        User user = (User)session.getAttribute("usuario_logado");
        modelAndView.addObject("usuario", user.getNome());
        modelAndView.addObject("nomeEvento", new Busca());
        //------------------------------------------------------------------------
        activityDAO.add(activity);
        modelAndView.addObject("action", "add");
        modelAndView.addObject("button", "Add");
        modelAndView.addObject("message", "Atividade adicionada com sucesso");
        return RenderView.getInstance().renderConfigEditViewUser(user, modelAndView);
    }
    
    @RequestMapping(value = "/Activity/List")
    public ModelAndView allUsers(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/Activity/list");
        User user = (User)session.getAttribute("usuario_logado");
        modelAndView.addObject("usuario", user.getNome());
        modelAndView.addObject("nomeEvento", new Busca());
        //-------------------------------------------------------
        List activities = activityDAO.getAllActivities();
        modelAndView.addObject("activities", activities);
        return RenderView.getInstance().renderConfigEditViewUser(user, modelAndView);
    }
    
    @RequestMapping(value = "/Activity/editForm/{id}")
    public ModelAndView editForm(@PathVariable int id,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/Activity/addForm");
        User user = (User)session.getAttribute("usuario_logado");
        modelAndView.addObject("usuario", user.getNome());
        modelAndView.addObject("nomeEvento", new Busca());
        //------------------------------------------------------------------------
        Activity activity = activityDAO.getActivityById(id);
        modelAndView.addObject("activity", activity);
        modelAndView.addObject("button", "Save");
        modelAndView.addObject("action", "edit/"+id);
        return RenderView.getInstance().renderConfigEditViewUser(user, modelAndView);
    }
    
    @RequestMapping(value = "/Activity/edit/{id}", method=RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute Activity activity,@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("forward:/Activity/List");
        activity.setIdatividade(id);
        activityDAO.edit(activity);
        List activities = activityDAO.getAllActivities();
        modelAndView.addObject("activities",activities);
        modelAndView.addObject("message", "Alteracao de dados concluida");
        return modelAndView;
    }
    
    @RequestMapping(value = "/Activity/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("forward:/Activity/List");
        Activity activity = activityDAO.getActivityById(id);
        activityDAO.delete(activity);
        List events = activityDAO.getAllActivities();
        modelAndView.addObject("activities", events);
        modelAndView.addObject("message", "evento deletado com sucesso");
        return modelAndView;
    }

}
