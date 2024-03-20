package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CadastroEventoPanel extends JPanel {
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

