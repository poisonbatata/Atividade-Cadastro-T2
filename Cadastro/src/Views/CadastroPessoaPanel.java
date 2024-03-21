package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Controllers.CadastroPessoaController;
import Models.Pessoa;
import Util.BD;

public class CadastroPessoaPanel extends JPanel {
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField emailField;
    private JButton cadastrarButton;
    Mouse mouse = new Mouse();

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
        cadastrarButton.addMouseListener(mouse);

        this.add(cadastrarButton);
    }

    private void clear() {
        nomeField.setText("");
        cpfField.setText("");
        emailField.setText("");
    }

	class Mouse extends JFrame implements MouseListener {
		public void mouseClicked(MouseEvent e){
	    	if(e.getSource()==cadastrarButton) {
                Pessoa pessoa = new Pessoa(nomeField.getText(), cpfField.getText(), emailField.getText());
                
                BD bd = new BD(System.getProperty("user.dir")+"\\Cadastro\\src\\Util\\");
	    		
                CadastroPessoaController controller = new CadastroPessoaController(CadastroPessoaPanel.this, bd);
                controller.criarCadastro(pessoa);

                clear();
                
                //System.out.println("Pessoa: " + nomeField.getText() +" cadastrada!");
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