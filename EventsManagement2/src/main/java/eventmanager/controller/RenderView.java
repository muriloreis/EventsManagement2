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
            menu.addObject("link",true);
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
            menu.addObject("link6","relatorio");
            menu.addObject("link6Label","Relatorio");
            return menu;
        } else if (user.getType() == UserType.EMPRESA){
            //Setando Interface
            menu.addObject("link",true);
            menu.addObject("link1","eventos");
            menu.addObject("link1Label","Meus Eventos");
            menu.addObject("link2","inscricoes");
            menu.addObject("link2Label","Minhas Inscricoes");
            menu.addObject("link3","pagamentos");
            menu.addObject("link3Label","Meus Pagamentos");
            menu.addObject("link4","recebimentos");
            menu.addObject("link4Label","Meus Recebimentos");
            menu.addObject("link5","relatorio");
            menu.addObject("link5Label","Relatorio");
            return menu;
        } else {
            //Setando Interface
            menu.addObject("link",true);
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
            menuEventos.addObject("link",false);
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
            menuEventos.addObject("link6","relatorio");
            menuEventos.addObject("link6Label","Relatorio");
            return menuEventos;
        } else if (user.getType() == UserType.EMPRESA){
            //Setando Interface
            menuEventos.addObject("link",false);
            menuEventos.addObject("link1","menu");
            menuEventos.addObject("link1Label","Menu");
            menuEventos.addObject("link2","inscricoes");
            menuEventos.addObject("link2Label","Minhas Inscricoes");
            menuEventos.addObject("link3","pagamentos");
            menuEventos.addObject("link3Label","Meus Pagamentos");
            menuEventos.addObject("link4","recebimentos");
            menuEventos.addObject("link4Label","Meus Recebimentos");
            menuEventos.addObject("link5","relatorio");
            menuEventos.addObject("link5Label","Relatorio");
            return menuEventos;
        } else {
            //Setando Interface
            menuEventos.addObject("link",false);
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
            menuInscricoes.addObject("link",false);
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
            menuInscricoes.addObject("link6","relatorio");
            menuInscricoes.addObject("link6Label","Relatorio");
            return menuInscricoes;
        } else if (user.getType() == UserType.EMPRESA){
            //Setando Interface
            menuInscricoes.addObject("link",false);
            menuInscricoes.addObject("link1","menu");
            menuInscricoes.addObject("link1Label","Menu");
            menuInscricoes.addObject("link2","eventos");
            menuInscricoes.addObject("link2Label","Meus Eventos");
            menuInscricoes.addObject("link3","pagamentos");
            menuInscricoes.addObject("link3Label","Meus Pagamentos");
            menuInscricoes.addObject("link4","recebimentos");
            menuInscricoes.addObject("link4Label","Meus Recebimentos");
            menuInscricoes.addObject("link5","relatorio");
            menuInscricoes.addObject("link5Label","Relatorio");
            return menuInscricoes;
        } else {
            //Setando Interface
            menuInscricoes.addObject("link",false);
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
            menuPagamentos.addObject("link",false);
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
            menuPagamentos.addObject("link6","relatorio");
            menuPagamentos.addObject("link6Label","Relatorio");
            return menuPagamentos;
        } else if (user.getType() == UserType.EMPRESA){
            //Setando Interface
            menuPagamentos.addObject("link",false);
            menuPagamentos.addObject("link1","menu");
            menuPagamentos.addObject("link1Label","Menu");
            menuPagamentos.addObject("link2","eventos");
            menuPagamentos.addObject("link2Label","Meus Eventos");
            menuPagamentos.addObject("link3","inscricoes");
            menuPagamentos.addObject("link3Label","Minhas Inscricoes");
            menuPagamentos.addObject("link4","recebimentos");
            menuPagamentos.addObject("link4Label","Meus Recebimentos");
            menuPagamentos.addObject("link5","relatorio");
            menuPagamentos.addObject("link5Label","Relatorio");
            return menuPagamentos;
        } else {
            //Setando Interface
            menuPagamentos.addObject("link",false);
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
            menuRecebimentos.addObject("link",false);
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
            menuRecebimentos.addObject("link6","relatorio");
            menuRecebimentos.addObject("link6Label","Relatorio");
            return menuRecebimentos;
        } else if (user.getType() == UserType.EMPRESA){
            //Setando Interface
            menuRecebimentos.addObject("link",false);
            menuRecebimentos.addObject("link1","menu");
            menuRecebimentos.addObject("link1Label","Menu");
            menuRecebimentos.addObject("link2","eventos");
            menuRecebimentos.addObject("link2Label","Meus Eventos");
            menuRecebimentos.addObject("link3","inscricoes");
            menuRecebimentos.addObject("link3Label","Minhas Inscricoes");
            menuRecebimentos.addObject("link4","pagamentos");
            menuRecebimentos.addObject("link4Label","Meus Pagamentos");
            menuRecebimentos.addObject("link5","relatorio");
            menuRecebimentos.addObject("link5Label","Relatorio");
            return menuRecebimentos;
        } else {
            //Setando Interface
            menuRecebimentos.addObject("link",false);
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
            menuConfig.addObject("link6","relatorio");
            menuConfig.addObject("link6Label","Relatorio");

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
            menuConfig.addObject("link5","relatorio");
            menuConfig.addObject("link5Label","Relatorio");
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
            menuConfigEdit.addObject("link6","relatorio");
            menuConfigEdit.addObject("link6Label","Relatorio");

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

    ModelAndView renderRelatorioViewUser(User user, ModelAndView menuRelatorio) {
        if(user.getType() == UserType.ADMIN){
            //Setando Interface
            menuRelatorio.addObject("link1","menu");
            menuRelatorio.addObject("link1Label","Menu");
            menuRelatorio.addObject("link2","eventos");
            menuRelatorio.addObject("link2Label","Meus Eventos");
            menuRelatorio.addObject("link3","inscricoes");
            menuRelatorio.addObject("link3Label","Minhas Inscricoes");
            menuRelatorio.addObject("link4","pagamentos");
            menuRelatorio.addObject("link4Label","Meus Pagamentos");
            menuRelatorio.addObject("link5","recebimentos");
            menuRelatorio.addObject("link5Label","Meus Recebimentos");
            menuRelatorio.addObject("link5","config");
            menuRelatorio.addObject("link5Label","Configuração Do Sistema");

            return menuRelatorio;
        } else if (user.getType() == UserType.EMPRESA){
            //Setando Interface
            menuRelatorio.addObject("link1","menu");
            menuRelatorio.addObject("link1Label","Menu");
            menuRelatorio.addObject("link2","eventos");
            menuRelatorio.addObject("link2Label","Meus Eventos");
            menuRelatorio.addObject("link3","inscricoes");
            menuRelatorio.addObject("link3Label","Minhas Inscricoes");
            menuRelatorio.addObject("link4","pagamentos");
            menuRelatorio.addObject("link4Label","Meus Pagamentos");
            menuRelatorio.addObject("link5","recebimentos");
            menuRelatorio.addObject("link5Label","Meus Recebimentos");

            return menuRelatorio;
        } else {
            //Setando Interface
            menuRelatorio.addObject("link1","menu");
            menuRelatorio.addObject("link1Label","Menu");
            menuRelatorio.addObject("link2","inscricoes");
            menuRelatorio.addObject("link2Label","Minhas Inscricoes");
            return menuRelatorio;
        }
    }
}
