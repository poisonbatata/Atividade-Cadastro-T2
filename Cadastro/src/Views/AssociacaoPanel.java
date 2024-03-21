package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Controllers.AssociacaoController;
import Models.Associacao;
import Util.BD;

public class AssociacaoPanel extends JPanel {
    private JTextField cpfField;
    private JTextField eventoField;
    private JButton associarButton;
    Mouse mouse = new Mouse();

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
        associarButton.addMouseListener(mouse);

        this.add(associarButton);
    }

    private void clear() {
        cpfField.setText("");
        eventoField.setText("");
    }

    class Mouse extends JFrame implements MouseListener {
		public void mouseClicked(MouseEvent e){
	    	if(e.getSource()==associarButton) {
                Associacao associacao = new Associacao(cpfField.getText(), eventoField.getText());
                
                BD bd = new BD("F:\\As coisas do SSD\\IFF\\6º Período - 2023.2\\Programação Orientada a Objeto (POO)\\Atividade Cadastro T2\\Cadastro\\src\\Util\\");
	    		
                AssociacaoController controller = new AssociacaoController(AssociacaoPanel.this, bd);
                controller.criarCadastro(associacao);

                clear();
                
                System.out.println("Associacao: " + cpfField.getText() +" + "+ eventoField.getText() + " cadastrado!");
	    	}
	    }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            //throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            //throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            //throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            // TODO Auto-generated method stub
            //throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
        }
	}
    
}
