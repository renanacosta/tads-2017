package calculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class Calculadora {

	private JFrame frmCalculadoraSimples;
	private JTextField textVisor;
	float valorAnterior, valorAtual, resultado;
	int operacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
					window.frmCalculadoraSimples.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadoraSimples = new JFrame();
		frmCalculadoraSimples.setTitle("Calculadora Simples");
		frmCalculadoraSimples.setBounds(100, 100, 213, 300);
		frmCalculadoraSimples.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmCalculadoraSimples.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		textVisor = new JTextField();
		textVisor.setEditable(false);
		textVisor.setForeground(UIManager.getColor("CheckBox.foreground"));
		textVisor.setBackground(UIManager.getColor("Button.focus"));
		panel.add(textVisor);
		textVisor.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		frmCalculadoraSimples.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textVisor.setText(textVisor.getText() + "3");
			}
		});
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textVisor.setText(textVisor.getText() + "1");
			}
		});
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		panel_1.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textVisor.setText(textVisor.getText() + "2");
			}
		});
		panel_1.add(btn2);
		panel_1.add(btn3);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textVisor.setText(textVisor.getText() + "0");
			}
		});
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textVisor.setText(textVisor.getText() + "5");
			}
		});
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textVisor.setText(textVisor.getText() + "4");
			}
		});
		panel_1.add(btn4);
		panel_1.add(btn5);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textVisor.setText(textVisor.getText() + "8");
			}
		});
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textVisor.setText(textVisor.getText() + "7");
			}
		});
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textVisor.setText(textVisor.getText() + "6");
			}
		});
		panel_1.add(btn6);
		panel_1.add(btn7);
		panel_1.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textVisor.setText(textVisor.getText() + "9");
			}
		});
		panel_1.add(btn9);
		panel_1.add(btn0);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textVisor.setText(null);
			}
		});
		
		JButton button = new JButton("=");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorAtual =   Float.parseFloat(textVisor.getText());
				
				if (operacao == 1) { resultado = valorAnterior + valorAtual; }
				if (operacao == 2) { resultado = valorAnterior - valorAtual; }
				if (operacao == 3) { resultado = valorAnterior / valorAtual; }
				if (operacao == 4) { resultado = valorAnterior * valorAtual; }
				
				textVisor.setText( String.valueOf(resultado)   );
			}
		});
		panel_1.add(button);
		panel_1.add(btnC);
		
		JPanel panel_2 = new JPanel();
		frmCalculadoraSimples.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorAnterior =  Float.parseFloat(textVisor.getText());
				textVisor.setText(null);
				operacao = 1;
			}
		});
		panel_2.setLayout(new GridLayout(0, 4, 0, 0));
		panel_2.add(btnAdd);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorAnterior =  Float.parseFloat(textVisor.getText());
				textVisor.setText(null);
				operacao = 2;
			}
		});
		panel_2.add(btnSub);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorAnterior =  Float.parseFloat(textVisor.getText());
				textVisor.setText(null);
				operacao = 3;
			}
		});
		panel_2.add(btnDiv);
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorAnterior =  Float.parseFloat(textVisor.getText());
				textVisor.setText(null);
				operacao = 4;
			}
		});
		panel_2.add(btnMul);
	}

}
