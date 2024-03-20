package Controllers;

import Util.BD;
import Views.CadastroPessoaPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroPessoaController implements ActionListener {
    private CadastroPessoaPanel view;
    private BD bd;

    public CadastroPessoaController(CadastroPessoaPanel view, BD bd) {
        this.view = view;
        this.bd = bd;

        // Adicionando o listener ao botão Cadastrar
        this.view.addCadastrarButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtendo os dados digitados nos campos de texto
        String nome = view.getNome();
        String cpf = view.getCPF();
        String email = view.getEmail();

        // Verificando se algum campo está vazio
        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty()) {
            // Exibir mensagem de erro ao usuário
            JOptionPane.showMessageDialog(view, "Todos os campos devem ser preenchidos!", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificando se o CPF é válido (apenas para fins de exemplo)
        if (!validarCPF(cpf)) {
            JOptionPane.showMessageDialog(view, "CPF inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Criando um objeto Pessoa com os dados informados
        Pessoa pessoa = new Pessoa(nome, cpf, email);

        // Salvando a pessoa no banco de dados
        bd.salvar(pessoa);

        // Exibindo mensagem de sucesso ao usuário
        JOptionPane.showMessageDialog(view, "Pessoa cadastrada com sucesso!", "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);

        // Limpando os campos de texto após o cadastro
        view.clearFields();
    }

    // Método para validar o CPF (apenas para fins de exemplo)
    private boolean validarCPF(String cpf) {
        // Adicione aqui a lógica de validação do CPF
        // Retorne true se o CPF for válido, caso contrário, retorne false
        // Esta implementação é apenas um exemplo simplificado
        return true;
    }
}
