package br.edu.up.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnEndereco = new JButton("Endereço");
		btnEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppEndereco appEndereco = new AppEndereco();
				appEndereco.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnEndereco.setBounds(55, 60, 150, 40);
		frame.getContentPane().add(btnEndereco);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppCliente appCliente = new AppCliente();
				appCliente.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCliente.setBounds(55, 110, 150, 40);
		frame.getContentPane().add(btnCliente);
		
		JButton btnFuncionario = new JButton("Funcionario");
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppFuncionario appFuncionario = new AppFuncionario();
				appFuncionario.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnFuncionario.setBounds(55, 160, 150, 40);
		frame.getContentPane().add(btnFuncionario);
		
		JButton btnEmprestimo = new JButton("Emprestimo");
		btnEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppEmprestimo appEmprestimo = new AppEmprestimo();
				appEmprestimo.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnEmprestimo.setBounds(215, 110, 150, 40);
		frame.getContentPane().add(btnEmprestimo);
		
		JButton btnLivro = new JButton("Livro");
		btnLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppLivro appLivro = new AppLivro();
				appLivro.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnLivro.setBounds(215, 60, 150, 40);
		frame.getContentPane().add(btnLivro);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnSair.setBounds(215, 160, 150, 40);
		frame.getContentPane().add(btnSair);
	}
}
