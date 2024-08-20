package br.edu.up.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTree;

import br.edu.up.entidades.Livro;
<<<<<<< HEAD
import br.edu.up.negocio.ConverteData;
import br.edu.up.presistencia.LivroPersistencia;
=======
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
<<<<<<< HEAD
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
=======
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11

public class AppLivro {

	JFrame frame;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtLancamento;
	private JTextField txtEditora;
	private JTextField txtGenero;
<<<<<<< HEAD
	private JTextField txtStatus;
	private JTextField txtCodigo;

=======
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
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
	public AppLivro() {
		initialize();
	}

<<<<<<< HEAD
	private Livro livro = new Livro();
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lucas\\eclipse-workspace\\Biblioteca_vrs2\\src\\assets\\book.png"));
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(110, 191, 45, 15);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 15));
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(110, 211, 250, 30);
		txtTitulo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTitulo.setColumns(10);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(370, 191, 120, 15);
		lblGenero.setFont(new Font("Arial", Font.BOLD, 15));
		
		txtGenero = new JTextField();
		txtGenero.setBounds(370, 211, 120, 30);
		txtGenero.setFont(new Font("Arial", Font.PLAIN, 15));
		txtGenero.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(310, 251, 45, 15);
		lblAutor.setFont(new Font("Arial", Font.BOLD, 15));
		
		txtAutor = new JTextField();
		txtAutor.setFont(new Font("Arial", Font.PLAIN, 15));
		txtAutor.setBounds(310, 271, 180, 30);
		txtAutor.setColumns(10);
		
		JLabel lblLancamento = new JLabel("Lançamento");
		lblLancamento.setBounds(240, 131, 120, 15);
		lblLancamento.setFont(new Font("Arial", Font.BOLD, 15));
		
		txtLancamento = new JTextField();
		txtLancamento.setBounds(240, 151, 120, 30);
		txtLancamento.setFont(new Font("Arial", Font.PLAIN, 15));
		txtLancamento.setColumns(10);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setBounds(110, 251, 60, 15);
		lblEditora.setFont(new Font("Arial", Font.BOLD, 15));
		

		txtEditora = new JTextField();
		txtEditora.setFont(new Font("Arial", Font.PLAIN, 15));
		txtEditora.setBounds(110, 271, 180, 30);
		txtEditora.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(370, 131, 120, 13);
		lblStatus.setFont(new Font("Arial", Font.BOLD, 15));
		
		JCheckBox chckbxInativarItem = new JCheckBox("Inativo");
		chckbxInativarItem.setBounds(110, 311, 100, 20);
		chckbxInativarItem.setFont(new Font("Arial", Font.BOLD, 15));

		txtStatus = new JTextField();
		txtStatus.setBounds(370, 151, 120, 30);
		txtStatus.setFont(new Font("Arial", Font.PLAIN, 15));
		txtStatus.setEnabled(false);
		txtStatus.setColumns(10);
		
		JLabel lblCodgio = new JLabel("Codigo");
		lblCodgio.setBounds(110, 131, 120, 15);
		lblCodgio.setFont(new Font("Arial", Font.BOLD, 15));
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(110, 151, 120, 30);
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCodigo.setColumns(10);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(20, 75, 100, 30);
		btnIncluir.setFont(new Font("Arial", Font.BOLD, 15));
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livro.setCodigo(txtCodigo.getText());
				if(LivroPersistencia.procurarPorCodigo(livro) == null) {
					livro.setTitulo(txtTitulo.getText());
					if(LivroPersistencia.procurarPorTitulo(livro) == null) {
						livro.setLancamento(ConverteData.converterData(txtLancamento.getText()));
						livro.setAutor(txtAutor.getText());
						livro.setEditora(txtEditora.getText());
						livro.setGenero(txtGenero.getText());
						livro.setEmprestado(false);
						livro.setInativo(false);
						if(LivroPersistencia.incluir(livro) == true) {
							JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");
						}else {
							JOptionPane.showMessageDialog(null, "Não foi possivel inserir os dados no momento!");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Titulo ja utilizado!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Codigo ja utilizado!");
				}
			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(460, 75, 100, 30);
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 15));
=======
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
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.frame.setVisible(true);
				frame.setVisible(false);
<<<<<<< HEAD
			}
		});
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(350, 75, 100, 30);
		btnFiltrar.setFont(new Font("Arial", Font.BOLD, 15));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livro.setCodigo(txtCodigo.getText());
				livro = LivroPersistencia.procurarPorCodigo(livro);
				if(livro != null) {
					txtTitulo.setText(livro.getTitulo());
					txtGenero.setText(livro.getGenero());
					txtEditora.setText(livro.getEditora());
					txtAutor.setText(livro.getAutor());
					txtLancamento.setText(ConverteData.converteDataString(livro.getLancamento()));
					if(livro.getInativo() == true) {
						txtStatus.setText("Inativo");
						chckbxInativarItem.setSelected(true);
					}else if(livro.getEmprestado() == true) {
						txtStatus.setText("Emprestado");
					}else {
						txtStatus.setText("Em estoque");
					}
					JOptionPane.showMessageDialog(null, "Livro encotrado!");
				}else {
					JOptionPane.showMessageDialog(null, "Livro inesistente!");
				}
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(130, 75, 100, 30);
		btnEditar.setFont(new Font("Arial", Font.BOLD, 15));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livro.setCodigo(txtCodigo.getText());
				if(LivroPersistencia.procurarPorCodigo(livro) == null) {
					livro.setTitulo(txtTitulo.getText());
					if(LivroPersistencia.procurarPorTitulo(livro) == null) {
						livro.setLancamento(ConverteData.converterData(txtLancamento.getText()));
						livro.setAutor(txtAutor.getText());
						livro.setEditora(txtEditora.getText());
						livro.setGenero(txtGenero.getText());
						livro.setEmprestado(false);
						livro.setInativo(false);
						if(LivroPersistencia.editar(livro) == true) {
							JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!");
						}else {
							JOptionPane.showMessageDialog(null, "Não foi possivel inserir os dados no momento!");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Titulo ja utilizado!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Codigo ja utilizado!");
				}
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(240, 75, 100, 30);
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 15));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcoes[] = {"Confrimar","Cancelar"}; 
				int confrimar = JOptionPane.showOptionDialog(null, "Deseja confirmar a exclusão?","Confirmação",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcoes,opcoes[1]);
				if(confrimar == 0) {
					if(LivroPersistencia.excluir(livro)) {
						JOptionPane.showMessageDialog(null, "Livro excluido com sucesso!");
					}else {
						JOptionPane.showMessageDialog(null, "Impossivel excluir o livro no momento!");
					}
				}
			}
		});
		
		JLabel lblCadastroLivro = new JLabel("Cadastro de Livro");
		lblCadastroLivro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroLivro.setBounds(200, 20, 200, 40);
		lblCadastroLivro.setFont(new Font("Arial", Font.BOLD, 20));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblTitulo);
		frame.getContentPane().add(txtTitulo);
		frame.getContentPane().add(lblGenero);
		frame.getContentPane().add(txtGenero);
		frame.getContentPane().add(lblAutor);
		frame.getContentPane().add(txtAutor);
		frame.getContentPane().add(lblLancamento);
		frame.getContentPane().add(txtLancamento);
		frame.getContentPane().add(lblEditora);
		frame.getContentPane().add(txtEditora);
		frame.getContentPane().add(lblStatus);
		frame.getContentPane().add(chckbxInativarItem);
		frame.getContentPane().add(txtStatus);
		frame.getContentPane().add(lblCodgio);
		frame.getContentPane().add(txtCodigo);
		frame.getContentPane().add(btnIncluir);
		frame.getContentPane().add(btnVoltar);
		frame.getContentPane().add(btnFiltrar);
		frame.getContentPane().add(btnEditar);
		frame.getContentPane().add(btnExcluir);
		frame.getContentPane().add(lblCadastroLivro);
=======
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
>>>>>>> 368718c369f3db21fd76b2b6d83b7614e46e3a11
	}
}
