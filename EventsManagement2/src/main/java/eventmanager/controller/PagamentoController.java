/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.controller;

import eventmanager.dao.EventDAO;
import eventmanager.dao.PagamentoDAO;
import eventmanager.dao.UserDAO;
import eventmanager.model.Busca;
import eventmanager.model.Event;
import eventmanager.model.Pagamento;
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
public class PagamentoController {
    private PagamentoDAO pagamentoDAO = new PagamentoDAO();
       
    @RequestMapping(value = "/Pagamento", method = RequestMethod.POST)
    public ModelAndView pagamento(@ModelAttribute Pagamento pagamento,HttpSession session){
        Event event = new EventDAO().getEventById(pagamento.getEventoId());
        double cmp = event.getValorInscricao() - pagamento.getQuantia();
        if(cmp < 0.001){
            ModelAndView modelAndView = new ModelAndView("forward:/Event/inscricao/"+event.getId());
            User user = (User) session.getAttribute("usuario_logado");
            pagamento.setCliente(user);
            pagamento.setRecebedor(event);
            pagamentoDAO.add(pagamento);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("pagamento");
            User user = (User) session.getAttribute("usuario_logado");
            modelAndView.addObject("message", "Quantia Insuficiente");
            modelAndView.addObject("pagamento",pagamento);
            modelAndView.addObject("id", event.getId());
            modelAndView.addObject("evento", event.getNome());
            modelAndView.addObject("usuario",user.getNome());
            return modelAndView;
        }
    }
    
    @RequestMapping(value = "/Pagamento/dados/{id}")
    public ModelAndView pagamentoDados(@PathVariable int id,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("pagamento");
        User user = (User) session.getAttribute("usuario_logado");
        modelAndView.addObject("pagamento", new Pagamento());
        modelAndView.addObject("id", id);
        modelAndView.addObject("evento", new EventDAO().getEventById(id).getNome());
        modelAndView.addObject("usuario",user.getNome());
        return modelAndView;
    }
    
    @RequestMapping(value = "/User/pagamentos")
    public ModelAndView pagamentos(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("pagamentosList");
        User user = (User)session.getAttribute("usuario_logado");
        List list = pagamentoDAO.getPagamentoByUser(user);
        modelAndView.addObject("usuario", user.getNome());
        modelAndView.addObject("pagamentos", list);
        modelAndView.addObject("nomeEvento", new Busca());
        return RenderView.getInstance().renderPagamentosViewUser(user, modelAndView);
    }
    
    @RequestMapping(value = "/User/recebimentos")
    public ModelAndView recebimentos(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("pagamentosList");
        User user = (User)session.getAttribute("usuario_logado");
        List<Event> events = user.getMeusEventos();
        List<Pagamento> recebimentos = new ArrayList<>();
        for (Event event : events) {
            recebimentos.addAll(pagamentoDAO.getPagamentoByEvento(event));
        }
        modelAndView.addObject("pagamentos", recebimentos);
        modelAndView.addObject("nomeEvento", new Busca());
        modelAndView.addObject("usuario", user.getNome());
        return RenderView.getInstance().renderPagamentosViewUser(user, modelAndView);
    }
    
}
