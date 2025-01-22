package br.edu.up.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class MenuPrincipal {

	JFrame frame;

	public MenuPrincipal() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lucas\\eclipse-workspace\\Biblioteca_vrs2\\src\\assets\\book.png"));
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JButton btnEndereco = new JButton("Endereço");
		btnEndereco.setFont(new Font("Arial", Font.BOLD, 15));
		btnEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppEndereco appEndereco = new AppEndereco();
				appEndereco.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnEndereco.setBounds(90, 95, 150, 40);
		frame.getContentPane().add(btnEndereco);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Arial", Font.BOLD, 15));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppCliente appCliente = new AppCliente();
				appCliente.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCliente.setBounds(90, 155, 150, 40);
		frame.getContentPane().add(btnCliente);
		
		JButton btnFuncionario = new JButton("Funcionario");
		btnFuncionario.setFont(new Font("Arial", Font.BOLD, 15));
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppFuncionario appFuncionario = new AppFuncionario();
				appFuncionario.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnFuncionario.setBounds(90, 215, 150, 40);
		frame.getContentPane().add(btnFuncionario);
		
		JButton btnEmprestimo = new JButton("Emprestimo");
		btnEmprestimo.setFont(new Font("Arial", Font.BOLD, 15));
		btnEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppEmprestimo appEmprestimo = new AppEmprestimo();
				appEmprestimo.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnEmprestimo.setBounds(260, 155, 150, 40);
		frame.getContentPane().add(btnEmprestimo);
		
		JButton btnLivro = new JButton("Livro");
		btnLivro.setFont(new Font("Arial", Font.BOLD, 15));
		btnLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppLivro appLivro = new AppLivro();
				appLivro.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnLivro.setBounds(260, 95, 150, 40);
		frame.getContentPane().add(btnLivro);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Arial", Font.BOLD, 15));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnSair.setBounds(260, 215, 150, 40);
		frame.getContentPane().add(btnSair);
		
		JLabel lblMenuPrincipal = new JLabel("Menu Principal");
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrincipal.setFont(new Font("Arial", Font.BOLD, 20));
		lblMenuPrincipal.setBounds(90, 23, 320, 40);
		frame.getContentPane().add(lblMenuPrincipal);
	}
}
