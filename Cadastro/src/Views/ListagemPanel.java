package Views;

import javax.swing.*;

import Controllers.ListagemController;
import Models.Associacao;
import Models.Evento;
import Util.BD;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListagemPanel extends JPanel {
    private JTextField eventoTextField;
    private JButton okButton;
    private JTextArea listagemTextArea;
    Mouse mouse = new Mouse();

    public ListagemPanel() {
        this.setLayout(new BorderLayout());
        JPanel superiorPanel = new JPanel(new FlowLayout());
        JLabel eventoLabel = new JLabel("Evento:");
        eventoTextField = new JTextField(30);
        okButton = new JButton("OK");
        okButton.addMouseListener(mouse);

        superiorPanel.add(eventoLabel);
        superiorPanel.add(eventoTextField);
        superiorPanel.add(okButton);

        listagemTextArea = new JTextArea();
        listagemTextArea.setEditable(false);

        this.add(superiorPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(listagemTextArea), BorderLayout.CENTER);
    }

    // Método para atualizar o conteúdo da área de texto com a listagem
    /*public void updateListagem(Object[] listagem){
        listagemTextArea.setFont(new Font("Sans Serif", Font.ITALIC, 13));
        //BD bd = new BD(System.getProperty("user.dir")+"\\src\\Util\\");
        for(Object i : listagem ) {
            listagemTextArea.append((String) i);
            listagemTextArea.append("\n");
            /*
            System.out.println("AAAAAAAA");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            System.out.println("BBBBBB");
            /

        } 
    }*/

    public void updateListagem(Object[] listagem){
        listagemTextArea.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        for(Object obj : listagem ) {
            if (obj instanceof Associacao) {
                Associacao associacao = (Associacao) obj;
                listagemTextArea.append("CPF: " + associacao.getCPF() + ", Evento: " + associacao.getEvento() + "\n");
            }
        } 
    }
    

    private void clear(String choice) {
        if(choice=="NomeDoEvento") {
            eventoTextField.setText("");
        } else if(choice=="ListagemDosCPFs") {
            listagemTextArea.setText("");
        } else if (choice=="Tudo") {
            eventoTextField.setText("");
            listagemTextArea.setText("");
        }
    }

    class Mouse extends JFrame implements MouseListener {
		public void mouseClicked(MouseEvent e){
	    	if(e.getSource()==okButton) {
                BD bd = new BD(System.getProperty("user.dir")+"\\src\\Util\\");
                ListagemController controller = new ListagemController(ListagemPanel.this, bd);
                
                clear("ListagemDosCPFs");
                updateListagem(controller.listar(eventoTextField.getText()));
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