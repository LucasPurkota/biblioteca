package br.edu.up.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTree;

import br.edu.up.entidades.Livro;
import br.edu.up.negocio.ConverteData;
import br.edu.up.presistencia.LivroPersistencia;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;

public class AppLivro {

	JFrame frame;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtLancamento;
	private JTextField txtEditora;
	private JTextField txtGenero;
	private JTextField txtStatus;
	private JTextField txtCodigo;

	public AppLivro() {
		initialize();
	}

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
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.frame.setVisible(true);
				frame.setVisible(false);
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
	}
}
