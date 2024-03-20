package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListagemPanel extends JPanel {
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