/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.controller;

import eventmanager.model.User;
import eventmanager.model.UserType;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Murilo
 */
public class RenderView {
    private static RenderView instance = new RenderView();

    private RenderView(){

    }

    public static RenderView getInstance(){
        return instance;
    }

    public ModelAndView renderMenuViewUser(User user,ModelAndView menu){
        if(user.getType() == UserType.ADMIN){
            //Setando Interface
            menu.addObject("link1","eventos");
            menu.addObject("link1Label","Meus Eventos");
            menu.addObject("link2","inscricoes");
            menu.addObject("link2Label","Minhas Inscricoes");
            menu.addObject("link3","pagamentos");
            menu.addObject("link3Label","Meus Pagamentos");
            menu.addObject("link4","recebimentos");
            menu.addObject("link4Label","Meus Recebimentos");
            menu.addObject("link5","config");
            menu.addObject("link5Label","Configuração do Sistema");
            return menu;
        } else if (user.getType() == UserType.EMPRESA){
            //Setando Interface
            menu.addObject("link1","eventos");
            menu.addObject("link1Label","Meus Eventos");
            menu.addObject("link2","inscricoes");
            menu.addObject("link2Label","Minhas Inscricoes");
            menu.addObject("link3","pagamentos");
            menu.addObject("link3Label","Meus Pagamentos");
            menu.addObject("link4","recebimentos");
            menu.addObject("link4Label","Meus Recebimentos");
            return menu;
        } else {
            //Setando Interface
            menu.addObject("link1","inscricoes");
            menu.addObject("link1Label","Minhas Inscricoes");
            menu.addObject("link2","pagamentos");
            menu.addObject("link2Label","Meus Pagamentos");
            return menu;
        }
    }

    ModelAndView renderEventosViewUser(User user, ModelAndView menuEventos) {
        if(user.getType() == UserType.ADMIN){
            //Setando Interface
            menuEventos.addObject("link1","menu");
            menuEventos.addObject("link1Label","Menu");
            menuEventos.addObject("link2","inscricoes");
            menuEventos.addObject("link2Label","Minhas Inscricoes");
            menuEventos.addObject("link3","pagamentos");
            menuEventos.addObject("link3Label","Meus Pagamentos");
            menuEventos.addObject("link4","recebimentos");
            menuEventos.addObject("link4Label","Meus Recebimentos");
            menuEventos.addObject("link5","config");
            menuEventos.addObject("link5Label","Configuração do Sistema");
            return menuEventos;
        } else if (user.getType() == UserType.EMPRESA){
            //Setando Interface
            menuEventos.addObject("link1","menu");
            menuEventos.addObject("link1Label","Menu");
            menuEventos.addObject("link2","inscricoes");
            menuEventos.addObject("link2Label","Minhas Inscricoes");
            menuEventos.addObject("link3","pagamentos");
            menuEventos.addObject("link3Label","Meus Pagamentos");
            menuEventos.addObject("link4","recebimentos");
            menuEventos.addObject("link4Label","Meus Recebimentos");
            return menuEventos;
        } else {
            //Setando Interface
            menuEventos.addObject("link1","inscricoes");
            menuEventos.addObject("link1Label","Minhas Inscricoes");
            menuEventos.addObject("link2","pagamentos");
            menuEventos.addObject("link2Label","Meus Pagamentos");
            return menuEventos;
        }
    }

    ModelAndView renderInscricoesViewUser(User user, ModelAndView menuInscricoes) {
        if(user.getType() == UserType.ADMIN){
            //Setando Interface
            menuInscricoes.addObject("link1","menu");
            menuInscricoes.addObject("link1Label","Menu");
            menuInscricoes.addObject("link2","eventos");
            menuInscricoes.addObject("link2Label","Meus Eventos");
            menuInscricoes.addObject("link3","pagamentos");
            menuInscricoes.addObject("link3Label","Meus Pagamentos");
            menuInscricoes.addObject("link4","recebimentos");
            menuInscricoes.addObject("link4Label","Meus Recebimentos");
            menuInscricoes.addObject("link5","config");
            menuInscricoes.addObject("link5Label","Configuração do Sistema");
            return menuInscricoes;
        } else if (user.getType() == UserType.EMPRESA){
            //Setando Interface
            menuInscricoes.addObject("link1","menu");
            menuInscricoes.addObject("link1Label","Menu");
            menuInscricoes.addObject("link2","eventos");
            menuInscricoes.addObject("link2Label","Meus Eventos");
            menuInscricoes.addObject("link3","pagamentos");
            menuInscricoes.addObject("link3Label","Meus Pagamentos");
            menuInscricoes.addObject("link4","recebimentos");
            menuInscricoes.addObject("link4Label","Meus Recebimentos");
            return menuInscricoes;
        } else {
            //Setando Interface
            menuInscricoes.addObject("link1","menu");
            menuInscricoes.addObject("link1Label","Menu");
            menuInscricoes.addObject("link2","pagamentos");
            menuInscricoes.addObject("link2Label","Meus Pagamentos");
            return menuInscricoes;
        }
    }
    
    ModelAndView renderPagamentosViewUser(User user, ModelAndView menuPagamentos) {
        if(user.getType() == UserType.ADMIN){
            //Setando Interface
            menuPagamentos.addObject("link1","menu");
            menuPagamentos.addObject("link1Label","Menu");
            menuPagamentos.addObject("link2","eventos");
            menuPagamentos.addObject("link2Label","Meus Eventos");
            menuPagamentos.addObject("link3","inscricoes");
            menuPagamentos.addObject("link3Label","Minhas Inscricoes");
            menuPagamentos.addObject("link4","recebimentos");
            menuPagamentos.addObject("link4Label","Meus Recebimentos");
            menuPagamentos.addObject("link5","config");
            menuPagamentos.addObject("link5Label","Configuração do Sistema");
            return menuPagamentos;
        } else if (user.getType() == UserType.EMPRESA){
            //Setando Interface
            menuPagamentos.addObject("link1","menu");
            menuPagamentos.addObject("link1Label","Menu");
            menuPagamentos.addObject("link2","eventos");
            menuPagamentos.addObject("link2Label","Meus Eventos");
            menuPagamentos.addObject("link3","inscricoes");
            menuPagamentos.addObject("link3Label","Minhas Inscricoes");
            menuPagamentos.addObject("link4","recebimentos");
            menuPagamentos.addObject("link4Label","Meus Recebimentos");
            return menuPagamentos;
        } else {
            //Setando Interface
            menuPagamentos.addObject("link1","menu");
            menuPagamentos.addObject("link1Label","Menu");
            menuPagamentos.addObject("link2","inscricoes");
            menuPagamentos.addObject("link2Label","Minhas Inscricoes");
            return menuPagamentos;
        }
    }
    
    ModelAndView renderRecebimentosViewUser(User user, ModelAndView menuRecebimentos) {
        if(user.getType() == UserType.ADMIN){
            //Setando Interface
            menuRecebimentos.addObject("link1","menu");
            menuRecebimentos.addObject("link1Label","Menu");
            menuRecebimentos.addObject("link2","eventos");
            menuRecebimentos.addObject("link2Label","Meus Eventos");
            menuRecebimentos.addObject("link3","inscricoes");
            menuRecebimentos.addObject("link3Label","Minhas Inscricoes");
            menuRecebimentos.addObject("link4","pagamentos");
            menuRecebimentos.addObject("link4Label","Meus Pagamentos");
            menuRecebimentos.addObject("link5","config");
            menuRecebimentos.addObject("link5Label","Configuração do Sistema");
            return menuRecebimentos;
        } else if (user.getType() == UserType.EMPRESA){
            //Setando Interface
            menuRecebimentos.addObject("link1","menu");
            menuRecebimentos.addObject("link1Label","Menu");
            menuRecebimentos.addObject("link2","eventos");
            menuRecebimentos.addObject("link2Label","Meus Eventos");
            menuRecebimentos.addObject("link3","inscricoes");
            menuRecebimentos.addObject("link3Label","Minhas Inscricoes");
            menuRecebimentos.addObject("link4","pagamentos");
            menuRecebimentos.addObject("link4Label","Meus Pagamentos");
            return menuRecebimentos;
        } else {
            //Setando Interface
            menuRecebimentos.addObject("link1","menu");
            menuRecebimentos.addObject("link1Label","Menu");
            menuRecebimentos.addObject("link2","inscricoes");
            menuRecebimentos.addObject("link2Label","Minhas Inscricoes");
            return menuRecebimentos;
        }
    }
    
    ModelAndView renderConfigViewUser(User user, ModelAndView menuConfig) {
        if(user.getType() == UserType.ADMIN){
            //Setando Interface
            menuConfig.addObject("link1","menu");
            menuConfig.addObject("link1Label","Menu");
            menuConfig.addObject("link2","eventos");
            menuConfig.addObject("link2Label","Meus Eventos");
            menuConfig.addObject("link3","inscricoes");
            menuConfig.addObject("link3Label","Minhas Inscricoes");
            menuConfig.addObject("link4","pagamentos");
            menuConfig.addObject("link4Label","Meus Pagamentos");
            menuConfig.addObject("link5","recebimentos");
            menuConfig.addObject("link5Label","Meus Recebimentos");

            return menuConfig;
        } else if (user.getType() == UserType.EMPRESA){
            //Setando Interface
            menuConfig.addObject("link1","menu");
            menuConfig.addObject("link1Label","Menu");
            menuConfig.addObject("link2","eventos");
            menuConfig.addObject("link2Label","Meus Eventos");
            menuConfig.addObject("link3","inscricoes");
            menuConfig.addObject("link3Label","Minhas Inscricoes");
            menuConfig.addObject("link4","recebimentos");
            menuConfig.addObject("link4Label","Meus Recebimentos");
            return menuConfig;
        } else {
            //Setando Interface
            menuConfig.addObject("link1","menu");
            menuConfig.addObject("link1Label","Menu");
            menuConfig.addObject("link2","inscricoes");
            menuConfig.addObject("link2Label","Minhas Inscricoes");
            return menuConfig;
        }
    }
    
    ModelAndView renderConfigEditViewUser(User user, ModelAndView menuConfigEdit) {
        if(user.getType() == UserType.ADMIN){
            //Setando Interface
            menuConfigEdit.addObject("link1","menu");
            menuConfigEdit.addObject("link1Label","Menu");
            menuConfigEdit.addObject("link2","eventos");
            menuConfigEdit.addObject("link2Label","Meus Eventos");
            menuConfigEdit.addObject("link3","inscricoes");
            menuConfigEdit.addObject("link3Label","Minhas Inscricoes");
            menuConfigEdit.addObject("link4","pagamentos");
            menuConfigEdit.addObject("link4Label","Meus Pagamentos");
            menuConfigEdit.addObject("link5","recebimentos");
            menuConfigEdit.addObject("link5Label","Meus Recebimentos");
            menuConfigEdit.addObject("link5","config");
            menuConfigEdit.addObject("link5Label","Configuração Do Sistema");

            return menuConfigEdit;
        } else if (user.getType() == UserType.EMPRESA){
            //Setando Interface
            menuConfigEdit.addObject("link1","menu");
            menuConfigEdit.addObject("link1Label","Menu");
            menuConfigEdit.addObject("link2","eventos");
            menuConfigEdit.addObject("link2Label","Meus Eventos");
            menuConfigEdit.addObject("link3","inscricoes");
            menuConfigEdit.addObject("link3Label","Minhas Inscricoes");
            menuConfigEdit.addObject("link4","recebimentos");
            menuConfigEdit.addObject("link4Label","Meus Recebimentos");
            return menuConfigEdit;
        } else {
            //Setando Interface
            menuConfigEdit.addObject("link1","menu");
            menuConfigEdit.addObject("link1Label","Menu");
            menuConfigEdit.addObject("link2","inscricoes");
            menuConfigEdit.addObject("link2Label","Minhas Inscricoes");
            return menuConfigEdit;
        }
    }
}
