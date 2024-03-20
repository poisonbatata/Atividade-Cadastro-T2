package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AssociacaoPanel extends JPanel {
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
