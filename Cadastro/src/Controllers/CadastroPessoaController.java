package Controllers;

import javax.swing.JOptionPane;

import Util.BD;
import Views.CadastroPessoaPanel;
import Models.Pessoa;

public class CadastroPessoaController{
    private CadastroPessoaPanel view;
    private BD bd;

    public CadastroPessoaController(CadastroPessoaPanel view, BD bd) {
        this.view = view;
        this.bd = bd;
    }

    public void criarCadastro(Pessoa pessoa){
        if (pessoa.getNome().isEmpty() || pessoa.getCPF().isEmpty() || pessoa.getEmail().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /*
        if (!validarCPF(pessoa.getCPF())) {
            JOptionPane.showMessageDialog(view, "CPF inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        */

        try {
            if(!existePessoa(pessoa)){
                bd.salvar(pessoa);
                JOptionPane.showMessageDialog(view, "Pessoa cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }else{
                JOptionPane.showMessageDialog(view, "O CPF digitado já está cadastrado! Tente outro.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro ao salvar os dados no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    public boolean existePessoa(Pessoa pessoa){
        int num=0;
        Object[] lista = new Object[1000];
        lista = bd.obterLista("Pessoa");
        try {
            for(Object i : lista ) {
                if(((Pessoa) i).getCPF().equals(pessoa.getCPF())){
                    return true;
                }
                num++;
            }    
        } catch (Exception e) {
            if(num == bd.obterTamanho("Pessoa")){
                return false;
            }
        }
        return false;
    }

    public static boolean validarCPF(String cpf) {
        // Verifica se o CPF tem 11 dígitos
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
        // Verifica se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        // Calcula e verifica os dígitos verificadores
        int soma = 0;
        int resto;
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(cpf.substring(i, i + 1)) * (10 - i);
        }
        resto = 11 - (soma % 11);
        if (resto == 10 || resto == 11) {
            resto = 0;
        }
        if (resto != Integer.parseInt(cpf.substring(9, 10))) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Integer.parseInt(cpf.substring(i, i + 1)) * (11 - i);
        }
        resto = 11 - (soma % 11);
        if (resto == 10 || resto == 11) {
            resto = 0;
        }
        if (resto != Integer.parseInt(cpf.substring(10))) {
            return false;
        }

        return true;
    }
}
