package br.edu.up.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
<<<<<<< HEAD
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
=======
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11

public class MenuPrincipal {

	JFrame frame;

<<<<<<< HEAD
=======
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
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
	public MenuPrincipal() {
		initialize();
	}

<<<<<<< HEAD
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
=======
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnEndereco = new JButton("Endereço");
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		btnEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppEndereco appEndereco = new AppEndereco();
				appEndereco.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
<<<<<<< HEAD
		btnEndereco.setBounds(90, 95, 150, 40);
		frame.getContentPane().add(btnEndereco);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Arial", Font.BOLD, 15));
=======
		btnEndereco.setBounds(55, 60, 150, 40);
		frame.getContentPane().add(btnEndereco);
		
		JButton btnCliente = new JButton("Cliente");
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppCliente appCliente = new AppCliente();
				appCliente.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
<<<<<<< HEAD
		btnCliente.setBounds(90, 155, 150, 40);
		frame.getContentPane().add(btnCliente);
		
		JButton btnFuncionario = new JButton("Funcionario");
		btnFuncionario.setFont(new Font("Arial", Font.BOLD, 15));
=======
		btnCliente.setBounds(55, 110, 150, 40);
		frame.getContentPane().add(btnCliente);
		
		JButton btnFuncionario = new JButton("Funcionario");
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppFuncionario appFuncionario = new AppFuncionario();
				appFuncionario.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
<<<<<<< HEAD
		btnFuncionario.setBounds(90, 215, 150, 40);
		frame.getContentPane().add(btnFuncionario);
		
		JButton btnEmprestimo = new JButton("Emprestimo");
		btnEmprestimo.setFont(new Font("Arial", Font.BOLD, 15));
=======
		btnFuncionario.setBounds(55, 160, 150, 40);
		frame.getContentPane().add(btnFuncionario);
		
		JButton btnEmprestimo = new JButton("Emprestimo");
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		btnEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppEmprestimo appEmprestimo = new AppEmprestimo();
				appEmprestimo.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
<<<<<<< HEAD
		btnEmprestimo.setBounds(260, 155, 150, 40);
		frame.getContentPane().add(btnEmprestimo);
		
		JButton btnLivro = new JButton("Livro");
		btnLivro.setFont(new Font("Arial", Font.BOLD, 15));
=======
		btnEmprestimo.setBounds(215, 110, 150, 40);
		frame.getContentPane().add(btnEmprestimo);
		
		JButton btnLivro = new JButton("Livro");
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		btnLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppLivro appLivro = new AppLivro();
				appLivro.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
<<<<<<< HEAD
		btnLivro.setBounds(260, 95, 150, 40);
		frame.getContentPane().add(btnLivro);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Arial", Font.BOLD, 15));
=======
		btnLivro.setBounds(215, 60, 150, 40);
		frame.getContentPane().add(btnLivro);
		
		JButton btnSair = new JButton("Sair");
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
<<<<<<< HEAD
		btnSair.setBounds(260, 215, 150, 40);
		frame.getContentPane().add(btnSair);
		
		JLabel lblMenuPrincipal = new JLabel("Menu Principal");
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrincipal.setFont(new Font("Arial", Font.BOLD, 20));
		lblMenuPrincipal.setBounds(90, 23, 320, 40);
		frame.getContentPane().add(lblMenuPrincipal);
=======
		btnSair.setBounds(215, 160, 150, 40);
		frame.getContentPane().add(btnSair);
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
	}
}
