package br.edu.up.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.up.entidades.Endereco;
import br.edu.up.presistencia.EnderecoPersistencia;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AppEndereco {

	JFrame frame;
	private JTextField txtCep;
	private JTextField txtLogradouro;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtPais;

	public AppEndereco() {
		initialize();
	}
	
	private Endereco endereco = new Endereco();

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lucas\\eclipse-workspace\\Biblioteca_vrs2\\src\\assets\\book.png"));
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Arial", Font.BOLD, 15));
		lblCep.setBounds(110, 131, 45, 15);
		frame.getContentPane().add(lblCep);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Arial", Font.BOLD, 15));
		lblLogradouro.setBounds(110, 191, 100, 15);
		frame.getContentPane().add(lblLogradouro);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Arial", Font.BOLD, 15));
		lblBairro.setBounds(110, 251, 80, 15);
		frame.getContentPane().add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Arial", Font.BOLD, 15));
		lblCidade.setBounds(110, 311, 80, 15);
		frame.getContentPane().add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Arial", Font.BOLD, 15));
		lblEstado.setBounds(240, 131, 120, 15);
		frame.getContentPane().add(lblEstado);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setFont(new Font("Arial", Font.BOLD, 15));
		lblPais.setBounds(370, 131, 45, 15);
		frame.getContentPane().add(lblPais);
		
		txtCep = new JTextField();
		txtCep.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCep.setBounds(110, 151, 120, 30);
		frame.getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setFont(new Font("Arial", Font.PLAIN, 15));
		txtLogradouro.setBounds(110, 211, 380, 30);
		frame.getContentPane().add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Arial", Font.PLAIN, 15));
		txtBairro.setBounds(110, 271, 380, 30);
		frame.getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCidade.setBounds(110, 331, 380, 30);
		frame.getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Arial", Font.PLAIN, 15));
		txtEstado.setBounds(240, 151, 120, 30);
		frame.getContentPane().add(txtEstado);
		txtEstado.setColumns(10);
		
		txtPais = new JTextField();
		txtPais.setFont(new Font("Arial", Font.PLAIN, 15));
		txtPais.setBounds(370, 151, 120, 30);
		frame.getContentPane().add(txtPais);
		txtPais.setColumns(10);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setFont(new Font("Arial", Font.BOLD, 15));
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtCep.getText().isEmpty()) {	
					endereco.setCep(txtCep.getText());
					if(EnderecoPersistencia.pequisarPorCEP(endereco) == null) {
						endereco.setLogradouro(txtLogradouro.getText());
						endereco.setBairro(txtBairro.getText());
						endereco.setCidade(txtCidade.getText());
						endereco.setEstado(txtEstado.getText());
						endereco.setPais(txtPais.getText());
						if(EnderecoPersistencia.incluir(endereco) == true) {
							JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");
						}else {
							JOptionPane.showMessageDialog(null, "Dados não podem ser inseridos no momento!");
						}
					}else {
						JOptionPane.showMessageDialog(null, "CEP ja cadastrado!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Campo cep é obrigatorio!");
				}
			}
		});
		btnIncluir.setBounds(20, 75, 100, 30);
		frame.getContentPane().add(btnIncluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 15));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnVoltar.setBounds(460, 75, 100, 30);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Arial", Font.BOLD, 15));
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endereco.setCep(txtCep.getText());
				endereco = EnderecoPersistencia.pequisarPorCEP(endereco);
				if(endereco != null) {
					txtLogradouro.setText(endereco.getLogradouro());
					txtBairro.setText(endereco.getBairro());
					txtCidade.setText(endereco.getCidade());
					txtEstado.setText(endereco.getEstado());
					txtPais.setText(endereco.getPais());
					JOptionPane.showMessageDialog(null, "CEP localizado!");
				}else {
					JOptionPane.showMessageDialog(null, "CEP não encontrado!");
				}
			}
		});
		btnFiltrar.setBounds(350, 75, 100, 30);
		frame.getContentPane().add(btnFiltrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtCep.getText().isEmpty()) {	
					endereco.setCep(txtCep.getText());
					endereco.setLogradouro(txtLogradouro.getText());
					endereco.setBairro(txtBairro.getText());
					endereco.setCidade(txtCidade.getText());
					endereco.setEstado(txtEstado.getText());
					endereco.setPais(txtPais.getText());
					if(EnderecoPersistencia.editar(endereco) == true) {
						JOptionPane.showMessageDialog(null, "Dados alterados com Sucesso!");
					}else {
						JOptionPane.showMessageDialog(null, "Dados não podem ser alterados no momento!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Campo cep é obrigatorio!");
				}
			}
		});
		btnEditar.setFont(new Font("Arial", Font.BOLD, 15));
		btnEditar.setBounds(130, 75, 100, 30);
		frame.getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Confirmar exlusão?", "Excluir", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					if(EnderecoPersistencia.excluir(endereco) == true) {
						JOptionPane.showMessageDialog(null, "Endereço excluido com Sucesso!");
					}else {
						JOptionPane.showMessageDialog(null, "Endereço não pode ser excluido no momento!");
					}
				}
			}
		});
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 15));
		btnExcluir.setBounds(240, 75, 100, 30);
		frame.getContentPane().add(btnExcluir);
		
		JLabel lblCadastroEndereco = new JLabel("Cadastro de Endereco");
		lblCadastroEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroEndereco.setFont(new Font("Arial", Font.BOLD, 15));
		lblCadastroEndereco.setBounds(200, 20, 200, 40);
		frame.getContentPane().add(lblCadastroEndereco);
	}
}
