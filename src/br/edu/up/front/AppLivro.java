package br.edu.up.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTree;

import br.edu.up.entidades.Livro;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class AppLivro {

	JFrame frame;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtLancamento;
	private JTextField txtEditora;
	private JTextField txtGenero;
	private JTextField textField;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppLivro window = new AppLivro();
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
	public AppLivro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame =  
				new JFrame();
		frame.setBounds(100, 100, 470, 290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(120, 70, 45, 15);
		frame.getContentPane().add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(120, 90, 210, 20);
		frame.getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(340, 70, 45, 15);
		frame.getContentPane().add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(340, 90, 100, 20);
		frame.getContentPane().add(txtGenero);
		txtGenero.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(285, 120, 45, 15);
		frame.getContentPane().add(lblAutor);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(285, 140, 155, 20);
		frame.getContentPane().add(txtAutor);
		txtAutor.setColumns(10);
		
		JLabel lblLancamento = new JLabel("Lançamento");
		lblLancamento.setBounds(230, 20, 80, 15);
		frame.getContentPane().add(lblLancamento);
		
		txtLancamento = new JTextField();
		txtLancamento.setBounds(230, 40, 100, 20);
		frame.getContentPane().add(txtLancamento);
		txtLancamento.setColumns(10);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setBounds(120, 120, 45, 15);
		frame.getContentPane().add(lblEditora);
		

		txtEditora = new JTextField();
		txtEditora.setBounds(120, 140, 155, 20);
		frame.getContentPane().add(txtEditora);
		txtEditora.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(340, 20, 45, 13);
		frame.getContentPane().add(lblStatus);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Livro livro = new Livro();
				livro.setCodigo(txtCodigo.getText());
				livro.setTitulo(txtTitulo.getText());
				livro.setAutor(txtAutor.getText());
				livro.setEditora(txtEditora.getText());
				livro.setGenero(txtGenero.getText());
				livro.setEmprestado(false);
				JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");
			}
		});
		btnIncluir.setBounds(10, 50, 80, 20);
		frame.getContentPane().add(btnIncluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnVoltar.setBounds(10, 20, 80, 20);
		frame.getContentPane().add(btnVoltar);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(340, 40, 100, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCodgio = new JLabel("Codigo");
		lblCodgio.setBounds(120, 20, 45, 15);
		frame.getContentPane().add(lblCodgio);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(120, 40, 100, 20);
		frame.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(10, 140, 80, 20);
		frame.getContentPane().add(btnFiltrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(10, 80, 80, 20);
		frame.getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(10, 110, 80, 20);
		frame.getContentPane().add(btnExcluir);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(100, 0, 2, 290);
		frame.getContentPane().add(separator);
		
		JCheckBox chckbxInativarItem = new JCheckBox("Inativo");
		chckbxInativarItem.setBounds(120, 170, 100, 20);
		frame.getContentPane().add(chckbxInativarItem);
	}
}
