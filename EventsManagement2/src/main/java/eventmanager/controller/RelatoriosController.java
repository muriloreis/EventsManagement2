/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.controller;

import eventmanager.dao.EventDAO;
import eventmanager.dao.UserDAO;
import eventmanager.model.Busca;
import eventmanager.model.Event;
import eventmanager.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Murilo
 */
@Controller
public class RelatoriosController {
    
    @RequestMapping(value = "/User/relatorio")
    public ModelAndView relatorio(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("relatorio");
        User user = (User)session.getAttribute("usuario_logado");
        ArrayList aux = new ArrayList();
        List<Event> eventoList = user.getMeusEventos();
        for (Event evento : eventoList) {
            aux.add(evento.getInscritos().size());
        }
        int qtd = 0;
        for (Object aux1 : aux) {
            qtd += (int)aux1;
        }
        List inscricaoList = user.getMinhasInscricoes();
        System.out.println(inscricaoList.size());
        modelAndView.addObject("quantidadeEventos", eventoList.size());
        modelAndView.addObject("quantidadeInscritos", inscricaoList.size());
        modelAndView.addObject("quantidadeInscritosMeusEventos",qtd);
        modelAndView.addObject("usuario", user.getNome());
        modelAndView.addObject("nomeEvento", new Busca());
        
        return RenderView.getInstance().renderRelatorioViewUser(user, modelAndView);
    }
    
    @RequestMapping(value = "/User/relatorioSistema")
    public ModelAndView relatorioSistema(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("relatorioSistema");
        User user = (User)session.getAttribute("usuario_logado");
        ArrayList aux = new ArrayList();
        List<Event> events = new EventDAO().getAllEvents();
        for (Event event : events) {
            aux.add(event.getInscritos().size());
        }
        int qtd = 0;
        for (Object aux1 : aux) {
            qtd += (int)aux1;
        }
        modelAndView.addObject("quantidadeEventos",events.size());
        modelAndView.addObject("quantidadeUsuarios", new UserDAO().getAllUsers().size());
        modelAndView.addObject("quantidadeInscritos",qtd);
        modelAndView.addObject("usuario", user.getNome());
        modelAndView.addObject("nomeEvento", new Busca());
        
        return RenderView.getInstance().renderRelatorioViewUser(user, modelAndView);
    }
    
}
