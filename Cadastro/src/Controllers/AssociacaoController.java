package Controllers;

import javax.swing.JOptionPane;

import Util.BD;
import Views.AssociacaoPanel;
import Models.Associacao;

public class AssociacaoController{
    private AssociacaoPanel view;
    private BD bd;

    public AssociacaoController(AssociacaoPanel view, BD bd) {
        this.view = view;
        this.bd = bd;
    }

    public void criarCadastro(Associacao associacao){
        if (associacao.getCPF().isEmpty() || associacao.getEvento().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        bd.salvar(associacao);

        JOptionPane.showMessageDialog(view, "Associacao cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

}
