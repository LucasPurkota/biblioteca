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

public class AppEndereco {

	JFrame frame;
	private JTextField txtCep;
	private JTextField txtLogradouro;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtPais;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppEndereco window = new AppEndereco();
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
	public AppEndereco() {
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
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(20, 20, 45, 15);
		frame.getContentPane().add(lblCep);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setBounds(20, 70, 80, 15);
		frame.getContentPane().add(lblLogradouro);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(20, 120, 45, 15);
		frame.getContentPane().add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(20, 170, 45, 15);
		frame.getContentPane().add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(130, 20, 45, 15);
		frame.getContentPane().add(lblEstado);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(240, 20, 45, 15);
		frame.getContentPane().add(lblPais);
		
		txtCep = new JTextField();
		txtCep.setBounds(20, 40, 100, 20);
		frame.getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(20, 90, 320, 20);
		frame.getContentPane().add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(20, 140, 320, 20);
		frame.getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(20, 190, 320, 20);
		frame.getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(130, 40, 100, 20);
		frame.getContentPane().add(txtEstado);
		txtEstado.setColumns(10);
		
		txtPais = new JTextField();
		txtPais.setBounds(240, 40, 100, 20);
		frame.getContentPane().add(txtPais);
		txtPais.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Endereco endereco = new Endereco();
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
			}
		});
		btnConfirmar.setBounds(20, 220, 100, 30);
		frame.getContentPane().add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnVoltar.setBounds(130, 220, 100, 30);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Endereco endereco = new Endereco();
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
		btnFiltrar.setBounds(240, 220, 100, 30);
		frame.getContentPane().add(btnFiltrar);
	}
}
