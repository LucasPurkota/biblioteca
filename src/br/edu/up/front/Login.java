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
import java.awt.Toolkit;

public class Login {

	JFrame frame;
	private JTextField txtLogin;
	private JPasswordField passwordField;

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

	public Login() {
		initialize();
	}

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
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSenha.setBounds(150, 130, 45, 20);
		frame.getContentPane().add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordField.setBounds(150, 150, 200, 30);
		frame.getContentPane().add(passwordField);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Arial", Font.PLAIN, 20));
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
		btnEntrar.setBounds(150, 220, 200, 30);
		frame.getContentPane().add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(150, 20, 200, 30);
		frame.getContentPane().add(lblNewLabel);
	}
}
