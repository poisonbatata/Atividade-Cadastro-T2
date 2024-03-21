package Controllers;

import javax.swing.JOptionPane;

import Util.BD;
import Views.ListagemPanel;
import Models.Associacao;

public class ListagemController{
    private ListagemPanel view;
    private BD bd;

    public ListagemController(ListagemPanel view, BD bd) {
        this.view = view;
        this.bd = bd;
    }

    public Object[] listar(String string){
        System.out.println("Listagem:     "+bd.obterLista(string));
        return bd.obterLista(string);
    }
}
