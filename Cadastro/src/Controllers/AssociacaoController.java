package Controllers;

import javax.swing.JOptionPane;

import Util.BD;
import Views.AssociacaoPanel;
import Models.Associacao;
import Models.Evento;
import Models.Pessoa;

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
    
        boolean pessoaExiste = false;
        Object[] listaPessoas = bd.obterLista("Pessoa");
        for (Object obj : listaPessoas) {
            Pessoa pessoa = (Pessoa) obj;
            if (pessoa != null && pessoa.getCPF().equals(associacao.getCPF())) {
                pessoaExiste = true;
                break;
            }
        }
        if (!pessoaExiste) {
            JOptionPane.showMessageDialog(view, "A pessoa informada não existe!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        boolean eventoExiste = false;
        Object[] listaEventos = bd.obterLista("Evento");
        for (Object obj : listaEventos) {
            Evento evento = (Evento) obj;
            if (evento != null && evento.getNome().equals(associacao.getEvento())) {
                eventoExiste = true;
                break;
            }
        }
        if (!eventoExiste) {
            JOptionPane.showMessageDialog(view, "O evento informado não existe!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        boolean associacaoExistente = false;
        Object[] listaAssociacoes = bd.obterLista("Associacao");
        for (Object obj : listaAssociacoes) {
            Associacao assoc = (Associacao) obj;
            if (assoc != null && assoc.getCPF().equals(associacao.getCPF()) && assoc.getEvento().equals(associacao.getEvento())) {
                associacaoExistente = true;
                break;
            }
        }
        if (associacaoExistente) {
            JOptionPane.showMessageDialog(view, "A pessoa já está associada ao evento informado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    

        bd.salvar(associacao);
        JOptionPane.showMessageDialog(view, "Associação cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }    
}
