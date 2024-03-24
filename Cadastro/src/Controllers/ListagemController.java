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
        Object[] listaGeral = bd.obterLista("Associacao");
        Object[] listaEvento = new Object[1000];
        int index = 0;
        boolean existe = false;

        if(string.equals("*")){return listaGeral;} // Listar todas as associações

        try {
            for(Object item : listaGeral ) {
                if(((Associacao) item).getEvento().equals(string)){
                    listaEvento[index] = ((Associacao) item);
                    existe = true;
                }
                index++;
            }    
        } catch (Exception e) {
            if(!existe){
                JOptionPane.showMessageDialog(view, "Este evento não existe ou não há ninguém associado a ele.", "Erro", JOptionPane.ERROR_MESSAGE);
                return listaEvento;
            }
        }

        return listaEvento;
    }
}
