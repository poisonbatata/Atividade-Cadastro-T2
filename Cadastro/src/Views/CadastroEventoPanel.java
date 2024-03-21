package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Controllers.CadastroEventoController;
import Models.Evento;
import Util.BD;

public class CadastroEventoPanel extends JPanel {
    private JTextField nomeField;
    private JTextField tipoField;
    private JTextField localField;
    private JButton cadastrarButton;
    Mouse mouse = new Mouse();

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
        cadastrarButton.addMouseListener(mouse);

        this.add(cadastrarButton);
    }

    private void clear() {
        nomeField.setText("");
        tipoField.setText("");
        localField.setText("");
    }

    class Mouse extends JFrame implements MouseListener {
		public void mouseClicked(MouseEvent e){
	    	if(e.getSource()==cadastrarButton) {
                Evento evento = new Evento(nomeField.getText(), tipoField.getText(), localField.getText());
                
                BD bd = new BD("F:\\As coisas do SSD\\IFF\\6º Período - 2023.2\\Programação Orientada a Objeto (POO)\\Atividade Cadastro T2\\Cadastro\\src\\Util\\");
	    		
                CadastroEventoController controller = new CadastroEventoController(CadastroEventoPanel.this, bd);
                controller.criarCadastro(evento);

                clear();
                
                System.out.println("Evento: " + nomeField.getText() +" cadastrado!");
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

