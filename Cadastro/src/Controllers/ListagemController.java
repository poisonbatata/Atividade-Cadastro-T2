package Controllers;

import javax.swing.JOptionPane;

import Util.BD;
import Views.ListagemPanel;
//import Models.Associacao;

public class ListagemController{
    private ListagemPanel view;
    private BD bd;

    public ListagemController(ListagemPanel view, BD bd) {
        this.view = view;
        this.bd = bd;
    }

    public Object[] listar(String string){
        //System.out.println("Listagem:     "+bd.obterLista(string));
        //return bd.obterLista(string);
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        return cars;
    }
}
/*
    public void criarCadastro(Evento evento){
        if (evento.getNome().isEmpty() || evento.getTipo().isEmpty() || evento.getLocal().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            if(!existeEvento(evento)){
                bd.salvar(evento);
                JOptionPane.showMessageDialog(view, "Evento cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }else{
                JOptionPane.showMessageDialog(view, "O evento digitado já está cadastrado! Tente outro.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro ao salvar os dados no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    public boolean existeEvento(Evento evento){
        int num=0;
        Object[] lista = new Object[1000];
        lista = bd.obterLista("Evento");
        try {
            for(Object i : lista ) {
                if(((Evento) i).getNome().equals(evento.getNome())){
                    return true;
                }
                num++;
            }    
        } catch (Exception e) {
            if(num == bd.obterTamanho("Evento")){
                return false;
            }
        }
        return false;
    }

}
*/