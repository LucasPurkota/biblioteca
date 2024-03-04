package br.edu.up.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class AppEmprestimo {

	JFrame frame;
	private JTextField txtCodigoEmprestimo;
	private JTextField txtDataEmprestimo;
	private JLabel lblDataDevolução;
	private JTextField txtDataDevolução;
	private JLabel lblCliente;
	private JTextField txtCliente;
	private JButton btnFiltrarCliente;
	private JTextField txtNomeCliente;
	private JLabel lblFuncionario;
	private JTextField txtFuncionario;
	private JButton btnFiltrarFuncionario;
	private JTextField txtNomeFuncionario;
	private JLabel lblLivro;
	private JTextField txtLivro;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppEmprestimo window = new AppEmprestimo();
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
	public AppEmprestimo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCodigoEmprestimo = new JLabel("Codigo");
		lblCodigoEmprestimo.setBounds(20, 20, 45, 15);
		frame.getContentPane().add(lblCodigoEmprestimo);
		
		txtCodigoEmprestimo = new JTextField();
		txtCodigoEmprestimo.setBounds(20, 40, 100, 20);
		frame.getContentPane().add(txtCodigoEmprestimo);
		txtCodigoEmprestimo.setColumns(10);
		
		JLabel lblDataEmprestimo = new JLabel("Data Emprestimo");
		lblDataEmprestimo.setBounds(130, 20, 90, 15);
		frame.getContentPane().add(lblDataEmprestimo);
		
		txtDataEmprestimo = new JTextField();
		txtDataEmprestimo.setBounds(130, 40, 100, 20);
		frame.getContentPane().add(txtDataEmprestimo);
		txtDataEmprestimo.setColumns(10);
		
		lblDataDevolução = new JLabel("Data Devolução");
		lblDataDevolução.setBounds(240, 20, 90, 15);
		frame.getContentPane().add(lblDataDevolução);
		
		txtDataDevolução = new JTextField();
		txtDataDevolução.setBounds(240, 40, 100, 20);
		frame.getContentPane().add(txtDataDevolução);
		txtDataDevolução.setColumns(10);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(20, 70, 45, 15);
		frame.getContentPane().add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(20, 90, 100, 20);
		frame.getContentPane().add(txtCliente);
		txtCliente.setColumns(10);
		
		btnFiltrarCliente = new JButton("...");
		btnFiltrarCliente.setBounds(120, 90, 20, 20);
		frame.getContentPane().add(btnFiltrarCliente);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setEnabled(false);
		txtNomeCliente.setBounds(150, 90, 190, 20);
		frame.getContentPane().add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		lblFuncionario = new JLabel("Funcionario");
		lblFuncionario.setBounds(20, 120, 90, 15);
		frame.getContentPane().add(lblFuncionario);
		
		txtFuncionario = new JTextField();
		txtFuncionario.setBounds(20, 140, 100, 20);
		frame.getContentPane().add(txtFuncionario);
		txtFuncionario.setColumns(10);
		
		btnFiltrarFuncionario = new JButton("...");
		btnFiltrarFuncionario.setBounds(120, 140, 20, 20);
		frame.getContentPane().add(btnFiltrarFuncionario);
		
		txtNomeFuncionario = new JTextField();
		txtNomeFuncionario.setEnabled(false);
		txtNomeFuncionario.setBounds(150, 140, 190, 20);
		frame.getContentPane().add(txtNomeFuncionario);
		txtNomeFuncionario.setColumns(10);
		
		lblLivro = new JLabel("Livro");
		lblLivro.setBounds(20, 170, 45, 15);
		frame.getContentPane().add(lblLivro);
		
		txtLivro = new JTextField();
		txtLivro.setBounds(20, 190, 100, 20);
		frame.getContentPane().add(txtLivro);
		txtLivro.setColumns(10);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(130, 190, 210, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
