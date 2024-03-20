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


/*
class ListagemPanel extends JPanel {
    private JTextArea listaTextArea;
    private JLabel l;
    private Container container;

    public ListagemPanel() {
        setLayout(new BorderLayout());
        container = this.getRootPane();
        //container.setLayout(null);
        setBackground(Color.GRAY);

        l = new JLabel("A");
		l.setSize(80, 30);
		l.setLocation(50, 50);
		l.setForeground(Color.white);
		this.add(l);

        listaTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(listaTextArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public JTextArea getListaTextArea() {
        return listaTextArea;
    }

}
*/