package Views;

import javax.swing.*;
public class Janela extends JFrame {
    private JTabbedPane tabbedPane;

    public Janela() {
        this.setTitle("Controle de Eventos");
        this.setSize(600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocation(200, 200);

        tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Cadastrar Pessoa", new CadastroPessoaPanel());
        tabbedPane.addTab("Cadastrar Evento", new CadastroEventoPanel());
        tabbedPane.addTab("Inscrever Pessoa em Evento", new AssociacaoPanel());
        tabbedPane.addTab("Listar Inscritos", new ListagemPanel());

        this.add(tabbedPane);
        this.setVisible(true);
    }
}
