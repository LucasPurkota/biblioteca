package br.edu.up.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import br.edu.up.entidades.Funcionario;
import br.edu.up.presistencia.FuncionarioPersistencia;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
<<<<<<< HEAD
import java.awt.Toolkit;
=======
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11

public class Login {

	JFrame frame;
	private JTextField txtLogin;
	private JPasswordField passwordField;

<<<<<<< HEAD
=======
	/**
	 * Launch the application.
	 */
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

<<<<<<< HEAD
=======
	/**
	 * Create the application.
	 */
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
	public Login() {
		initialize();
	}

<<<<<<< HEAD
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lucas\\eclipse-workspace\\Biblioteca_vrs2\\src\\assets\\book.png"));
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCpf.setBounds(150, 70, 45, 20);
		frame.getContentPane().add(lblCpf);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Arial", Font.PLAIN, 15));
		txtLogin.setBounds(150, 90, 200, 30);
=======
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(160, 80, 45, 20);
		frame.getContentPane().add(lblCpf);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(160, 105, 120, 20);
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
<<<<<<< HEAD
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSenha.setBounds(150, 130, 45, 20);
		frame.getContentPane().add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordField.setBounds(150, 150, 200, 30);
		frame.getContentPane().add(passwordField);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Arial", Font.PLAIN, 20));
=======
		lblSenha.setBounds(160, 135, 45, 13);
		frame.getContentPane().add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 160, 120, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnEntrar = new JButton("Entrar");
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha;
				char senhaCar[];
				Funcionario funcionario = new Funcionario();
				funcionario.setCpf(txtLogin.getText());
				funcionario = FuncionarioPersistencia.procuraPorCPF(funcionario);
				if(funcionario != null) {
					senhaCar = passwordField.getPassword();
					senha = new String(senhaCar);
					if(senha.equals(funcionario.getSenha())) {
						JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
						MenuPrincipal menuPrincipal = new MenuPrincipal();
						menuPrincipal.frame.setVisible(true);
						frame.setVisible(false);
					}else {
						for (int i = 0; i < senhaCar.length; i++) {
		                    senhaCar[i] = ' ';
		                }
						JOptionPane.showMessageDialog(null, "Senha Invalida!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "CPF Invalido!");
				}
			}
		});
<<<<<<< HEAD
		btnEntrar.setBounds(150, 220, 200, 30);
=======
		btnEntrar.setBounds(160, 200, 120, 30);
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		frame.getContentPane().add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
<<<<<<< HEAD
		lblNewLabel.setBounds(150, 20, 200, 30);
=======
		lblNewLabel.setBounds(160, 20, 120, 30);
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		frame.getContentPane().add(lblNewLabel);
	}
}
