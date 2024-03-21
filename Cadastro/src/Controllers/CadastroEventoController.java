package Controllers;

import javax.swing.JOptionPane;

import Util.BD;
import Views.CadastroEventoPanel;
import Models.Evento;

public class CadastroEventoController{
    private CadastroEventoPanel view;
    private BD bd;

    public CadastroEventoController(CadastroEventoPanel view, BD bd) {
        this.view = view;
        this.bd = bd;
    }

    public void criarCadastro(Evento evento){
        if (evento.getNome().isEmpty() || evento.getTipo().isEmpty() || evento.getLocal().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        bd.salvar(evento);

        JOptionPane.showMessageDialog(view, "Evento cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

}
