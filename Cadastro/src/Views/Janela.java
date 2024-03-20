package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        add(tabbedPane);
        this.setVisible(true);
    }
}

class CadastroPessoaPanel extends JPanel {
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField emailField;
    private JButton cadastrarButton;

    public CadastroPessoaPanel() {
        this.setLayout(new GridLayout(4, 2));

        this.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        this.add(nomeField);

        this.add(new JLabel("CPF:"));
        cpfField = new JTextField();
        this.add(cpfField);

        this.add(new JLabel("Email:"));
        emailField = new JTextField();
        this.add(emailField);
        this.setBackground(Color.YELLOW);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pessoa: "+nomeField.getText()+" adicionada!");
                //
                //
                // FAZER A LÓGICA PRO BOTÃO
                //
                //
            }
        });
        add(cadastrarButton);
    }
}

class CadastroEventoPanel extends JPanel {
    private JTextField nomeField;
    private JTextField tipoField;
    private JTextField localField;
    private JButton cadastrarButton;

    public CadastroEventoPanel() {
        this.setLayout(new GridLayout(4, 2));
        this.setBackground(Color.GREEN);

        this.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        this.add(nomeField);

        this.add(new JLabel("Tipo:"));
        tipoField = new JTextField();
        this.add(tipoField);

        this.add(new JLabel("Local:"));
        localField = new JTextField();
        this.add(localField);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Evento: "+nomeField.getText()+" adicionada!");
                //
                //
                // FAZER A LÓGICA PRO BOTÃO
                //
                //
            }
        });
        this.add(cadastrarButton);
    }
}

class AssociacaoPanel extends JPanel {
    private JTextField cpfField;
    private JTextField eventoField;
    private JButton associarButton;

    public AssociacaoPanel() {
        this.setLayout(new GridLayout(3, 2));
        this.setBackground(Color.CYAN);

        this.add(new JLabel("CPF:"));
        cpfField = new JTextField();
        this.add(cpfField);

        this.add(new JLabel("Evento:"));
        eventoField = new JTextField();
        this.add(eventoField);

        associarButton = new JButton("Associar");
        associarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Associação: "+cpfField.getText()+" e "+eventoField.getText()+" adicionada!");
                //
                //
                // FAZER A LÓGICA PRO BOTÃO
                //
                //
            }
        });

        this.add(associarButton);
    }
    
}

class ListagemPanel extends JPanel {
    private JTextField eventoTextField;
    private JButton okButton;
    private JTextArea listagemTextArea;

    public ListagemPanel() {
        this.setLayout(new BorderLayout());
        JPanel superiorPanel = new JPanel(new FlowLayout());
        JLabel eventoLabel = new JLabel("Evento:");
        eventoTextField = new JTextField(20);
        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Evento: "+eventoTextField.getText()+" buscado!");
                //
                //
                // FAZER A LÓGICA PRO BOTÃO
                //
                //
            }
        });

        superiorPanel.add(eventoLabel);
        superiorPanel.add(eventoTextField);
        superiorPanel.add(okButton);

        listagemTextArea = new JTextArea();
        listagemTextArea.setEditable(false);

        this.add(superiorPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(listagemTextArea), BorderLayout.CENTER);
    }

    // Método para atualizar o conteúdo da área de texto com a listagem
    public void updateListagem(String listagem) {
        listagemTextArea.setText(listagem);
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