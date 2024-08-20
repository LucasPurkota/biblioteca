package br.edu.up.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
<<<<<<< HEAD
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.UIManager;
=======
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11

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
<<<<<<< HEAD
	private JLabel lblEmpretimo;
	private JButton btnFiltrarLivro;
	private JButton btnIncluir;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnFiltrar;
	private JButton btnVoltar;
	private JButton btnIncluir_1;
	private JButton btnExcluir_1;
	private JTable table;

	public AppEmprestimo() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lucas\\eclipse-workspace\\Biblioteca_vrs2\\src\\assets\\book.png"));
		frame.setBounds(100, 100, 600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JLabel lblCodigoEmprestimo = new JLabel("Codigo");
		lblCodigoEmprestimo.setFont(new Font("Arial", Font.BOLD, 15));
		lblCodigoEmprestimo.setBounds(95, 131, 120, 15);
		frame.getContentPane().add(lblCodigoEmprestimo);
		
		txtCodigoEmprestimo = new JTextField();
		txtCodigoEmprestimo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCodigoEmprestimo.setBounds(95, 151, 120, 30);
=======

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
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		frame.getContentPane().add(txtCodigoEmprestimo);
		txtCodigoEmprestimo.setColumns(10);
		
		JLabel lblDataEmprestimo = new JLabel("Data Emprestimo");
<<<<<<< HEAD
		lblDataEmprestimo.setFont(new Font("Arial", Font.BOLD, 15));
		lblDataEmprestimo.setBounds(225, 131, 160, 15);
		frame.getContentPane().add(lblDataEmprestimo);
		
		txtDataEmprestimo = new JTextField();
		txtDataEmprestimo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDataEmprestimo.setBounds(225, 151, 130, 30);
=======
		lblDataEmprestimo.setBounds(130, 20, 90, 15);
		frame.getContentPane().add(lblDataEmprestimo);
		
		txtDataEmprestimo = new JTextField();
		txtDataEmprestimo.setBounds(130, 40, 100, 20);
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		frame.getContentPane().add(txtDataEmprestimo);
		txtDataEmprestimo.setColumns(10);
		
		lblDataDevolução = new JLabel("Data Devolução");
<<<<<<< HEAD
		lblDataDevolução.setFont(new Font("Arial", Font.BOLD, 15));
		lblDataDevolução.setBounds(365, 131, 120, 15);
		frame.getContentPane().add(lblDataDevolução);
		
		txtDataDevolução = new JTextField();
		txtDataDevolução.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDataDevolução.setBounds(365, 151, 120, 30);
=======
		lblDataDevolução.setBounds(240, 20, 90, 15);
		frame.getContentPane().add(lblDataDevolução);
		
		txtDataDevolução = new JTextField();
		txtDataDevolução.setBounds(240, 40, 100, 20);
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		frame.getContentPane().add(txtDataDevolução);
		txtDataDevolução.setColumns(10);
		
		lblCliente = new JLabel("Cliente");
<<<<<<< HEAD
		lblCliente.setFont(new Font("Arial", Font.BOLD, 15));
		lblCliente.setBounds(95, 191, 120, 15);
		frame.getContentPane().add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCliente.setBounds(95, 211, 120, 30);
=======
		lblCliente.setBounds(20, 70, 45, 15);
		frame.getContentPane().add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(20, 90, 100, 20);
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		frame.getContentPane().add(txtCliente);
		txtCliente.setColumns(10);
		
		btnFiltrarCliente = new JButton("...");
<<<<<<< HEAD
		btnFiltrarCliente.setFont(new Font("Arial", Font.BOLD, 15));
		btnFiltrarCliente.setBounds(215, 211, 30, 30);
		frame.getContentPane().add(btnFiltrarCliente);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNomeCliente.setEnabled(false);
		txtNomeCliente.setBounds(255, 211, 230, 30);
=======
		btnFiltrarCliente.setBounds(120, 90, 20, 20);
		frame.getContentPane().add(btnFiltrarCliente);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setEnabled(false);
		txtNomeCliente.setBounds(150, 90, 190, 20);
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		frame.getContentPane().add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		lblFuncionario = new JLabel("Funcionario");
<<<<<<< HEAD
		lblFuncionario.setFont(new Font("Arial", Font.BOLD, 15));
		lblFuncionario.setBounds(95, 251, 90, 15);
		frame.getContentPane().add(lblFuncionario);
		
		txtFuncionario = new JTextField();
		txtFuncionario.setFont(new Font("Arial", Font.PLAIN, 15));
		txtFuncionario.setBounds(95, 271, 120, 30);
=======
		lblFuncionario.setBounds(20, 120, 90, 15);
		frame.getContentPane().add(lblFuncionario);
		
		txtFuncionario = new JTextField();
		txtFuncionario.setBounds(20, 140, 100, 20);
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		frame.getContentPane().add(txtFuncionario);
		txtFuncionario.setColumns(10);
		
		btnFiltrarFuncionario = new JButton("...");
<<<<<<< HEAD
		btnFiltrarFuncionario.setFont(new Font("Arial", Font.BOLD, 15));
		btnFiltrarFuncionario.setBounds(215, 271, 30, 30);
		frame.getContentPane().add(btnFiltrarFuncionario);
		
		txtNomeFuncionario = new JTextField();
		txtNomeFuncionario.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNomeFuncionario.setEnabled(false);
		txtNomeFuncionario.setBounds(255, 271, 230, 30);
=======
		btnFiltrarFuncionario.setBounds(120, 140, 20, 20);
		frame.getContentPane().add(btnFiltrarFuncionario);
		
		txtNomeFuncionario = new JTextField();
		txtNomeFuncionario.setEnabled(false);
		txtNomeFuncionario.setBounds(150, 140, 190, 20);
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		frame.getContentPane().add(txtNomeFuncionario);
		txtNomeFuncionario.setColumns(10);
		
		lblLivro = new JLabel("Livro");
<<<<<<< HEAD
		lblLivro.setFont(new Font("Arial", Font.BOLD, 15));
		lblLivro.setBounds(95, 311, 45, 15);
		frame.getContentPane().add(lblLivro);
		
		txtLivro = new JTextField();
		txtLivro.setFont(new Font("Arial", Font.PLAIN, 15));
		txtLivro.setBounds(95, 331, 120, 30);
=======
		lblLivro.setBounds(20, 170, 45, 15);
		frame.getContentPane().add(lblLivro);
		
		txtLivro = new JTextField();
		txtLivro.setBounds(20, 190, 100, 20);
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		frame.getContentPane().add(txtLivro);
		txtLivro.setColumns(10);
		
		textField = new JTextField();
<<<<<<< HEAD
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setEnabled(false);
		textField.setBounds(255, 331, 230, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblEmpretimo = new JLabel("Emprestimo");
		lblEmpretimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpretimo.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmpretimo.setBounds(200, 20, 200, 40);
		frame.getContentPane().add(lblEmpretimo);
		
		btnFiltrarLivro = new JButton("...");
		btnFiltrarLivro.setFont(new Font("Arial", Font.BOLD, 15));
		btnFiltrarLivro.setBounds(215, 331, 30, 30);
		frame.getContentPane().add(btnFiltrarLivro);
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.setFont(new Font("Arial", Font.BOLD, 15));
		btnIncluir.setBounds(20, 75, 100, 30);
		frame.getContentPane().add(btnIncluir);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.BOLD, 15));
		btnEditar.setBounds(130, 75, 100, 30);
		frame.getContentPane().add(btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 15));
		btnExcluir.setBounds(240, 75, 100, 30);
		frame.getContentPane().add(btnExcluir);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Arial", Font.BOLD, 15));
		btnFiltrar.setBounds(350, 75, 100, 30);
		frame.getContentPane().add(btnFiltrar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 15));
		btnVoltar.setBounds(460, 75, 100, 30);
		frame.getContentPane().add(btnVoltar);
		
		btnIncluir_1 = new JButton("Incluir");
		btnIncluir_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnIncluir_1.setBounds(95, 371, 100, 30);
		frame.getContentPane().add(btnIncluir_1);
		
		btnExcluir_1 = new JButton("Excluir");
		btnExcluir_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnExcluir_1.setBounds(205, 371, 100, 30);
		frame.getContentPane().add(btnExcluir_1);
		
		table = new JTable();
		table.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		table.setBounds(95, 411, 390, 220);
		frame.getContentPane().add(table);
=======
		textField.setEnabled(false);
		textField.setBounds(130, 190, 210, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
	}
}
