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

public class Login {

	JFrame frame;
	private JTextField txtLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public Login() {
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
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(160, 80, 45, 20);
		frame.getContentPane().add(lblCpf);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(160, 105, 120, 20);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(160, 135, 45, 13);
		frame.getContentPane().add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 160, 120, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnEntrar = new JButton("Entrar");
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
		btnEntrar.setBounds(160, 200, 120, 30);
		frame.getContentPane().add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(160, 20, 120, 30);
		frame.getContentPane().add(lblNewLabel);
	}
}
