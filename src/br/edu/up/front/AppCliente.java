package br.edu.up.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.up.entidades.Cliente;
import br.edu.up.entidades.Endereco;
import br.edu.up.negocio.ConverteData;
import br.edu.up.negocio.ValidaCPF;
import br.edu.up.presistencia.ClientePersistencia;
import br.edu.up.presistencia.EnderecoPersistencia;
import br.edu.up.presistencia.LivroPersistencia;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JEditorPane;

public class AppCliente {

	JFrame frame;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtNascimento;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtComplemento;
	private JTextField txtNumero;
	private JTextField txtCep;

	public AppCliente() {
		initialize();
	}

	private Cliente cliente = new Cliente();
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lucas\\eclipse-workspace\\Biblioteca_vrs2\\src\\assets\\book.png"));
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Arial", Font.BOLD, 15));
		lblCpf.setBounds(110, 131, 45, 15);
		frame.getContentPane().add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCpf.setBounds(110, 151, 120, 30);
		frame.getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Arial", Font.BOLD, 15));
		lblRg.setBounds(240, 131, 45, 15);
		frame.getContentPane().add(lblRg);
		
		txtRg = new JTextField();
		txtRg.setFont(new Font("Arial", Font.PLAIN, 15));
		txtRg.setBounds(240, 151, 120, 30);
		frame.getContentPane().add(txtRg);
		txtRg.setColumns(10);
		
		JLabel lblNascimento = new JLabel("Data Nascimento");
		lblNascimento.setFont(new Font("Arial", Font.BOLD, 15));
		lblNascimento.setBounds(370, 131, 130, 15);
		frame.getContentPane().add(lblNascimento);
		
		txtNascimento = new JTextField();
		txtNascimento.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNascimento.setBounds(370, 151, 120, 30);
		frame.getContentPane().add(txtNascimento);
		txtNascimento.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.BOLD, 15));
		lblNome.setBounds(110, 191, 45, 15);
		frame.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNome.setBounds(110, 211, 380, 30);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 15));
		lblTelefone.setBounds(110, 251, 120, 15);
		frame.getContentPane().add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTelefone.setBounds(110, 271, 120, 30);
		frame.getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Arial", Font.BOLD, 15));
		lblComplemento.setBounds(240, 251, 120, 15);
		frame.getContentPane().add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Arial", Font.PLAIN, 15));
		txtComplemento.setBounds(240, 271, 120, 30);
		frame.getContentPane().add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Arial", Font.BOLD, 15));
		lblNumero.setBounds(370, 251, 120, 15);
		frame.getContentPane().add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNumero.setBounds(370, 271, 120, 30);
		frame.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Arial", Font.BOLD, 15));
		lblCep.setBounds(111, 311, 45, 15);
		frame.getContentPane().add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCep.setBounds(111, 331, 158, 30);
		frame.getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		
		JEditorPane txtEndereco = new JEditorPane();
		txtEndereco.setFont(new Font("Arial", Font.PLAIN, 15));
		txtEndereco.setEnabled(false);
		txtEndereco.setBounds(110, 371, 380, 60);
		frame.getContentPane().add(txtEndereco);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setFont(new Font("Arial", Font.BOLD, 15));
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dataNascimento;
				Endereco endereco = new Endereco();
				cliente.setCpf(txtCpf.getText());
				if(ValidaCPF.isCPF(cliente.getCpf())) {
					if(ClientePersistencia.procurarPorCPF(cliente) == null) {
						cliente.setRg(txtRg.getText());
						cliente.setNome(txtNome.getText());
						dataNascimento = ConverteData.converterData(txtNascimento.getText());
						if(dataNascimento != null) {
							cliente.setDataNascimento(dataNascimento);
							cliente.setTelefone(txtTelefone.getText());
							endereco.setCep(txtCep.getText());
							endereco = EnderecoPersistencia.pequisarPorCEP(endereco);
							if(endereco != null) {
								cliente.setEndereco(endereco);
								cliente.setComplemento(txtComplemento.getText());
								cliente.setNumero(Integer.parseInt(txtNumero.getText()));
								if(ClientePersistencia.incluir(cliente) == true) {
									JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");
								}else {									
									JOptionPane.showMessageDialog(null, "Dados não podem ser inseridos no momento!");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Endereço não cadastrado!");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Data Invalida!");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Cliente ja Cadastrado!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "CPF Invalido!");
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
				cliente.setCpf(txtCpf.getText());
				cliente = ClientePersistencia.procurarPorCPF(cliente);
				if(cliente != null) {
					String dataNasc;
					txtCpf.setText(cliente.getCpf());
					txtNome.setText(cliente.getNome());
					txtRg.setText(cliente.getRg());
					dataNasc = ConverteData.converteDataString(cliente.getDataNascimento());
					txtNascimento.setText(dataNasc);
					txtTelefone.setText(cliente.getTelefone());
					txtComplemento.setText(cliente.getComplemento());
					txtNumero.setText(Integer.toString(cliente.getNumero()));
					txtCep.setText(cliente.getEndereco().getCep());
					txtEndereco.setText(cliente.getEndereco().getLogradouro() + " , " + cliente.getEndereco().getBairro() + " , " + 
							cliente.getEndereco().getCidade());
				}
				else { 
					JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
				}
			}
		});
		btnFiltrar.setBounds(350, 75, 100, 30);
		frame.getContentPane().add(btnFiltrar);
		
		JLabel lblCadastroDeCliente = new JLabel("Cadastro de Cliente");
		lblCadastroDeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeCliente.setFont(new Font("Arial", Font.BOLD, 20));
		lblCadastroDeCliente.setBounds(200, 20, 200, 40);
		frame.getContentPane().add(lblCadastroDeCliente);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dataNascimento;
				Endereco endereco = new Endereco();
				cliente.setCpf(txtCpf.getText());
				if(ValidaCPF.isCPF(cliente.getCpf())) {
					cliente.setRg(txtRg.getText());
					cliente.setNome(txtNome.getText());
					dataNascimento = ConverteData.converterData(txtNascimento.getText());
					if(dataNascimento != null) {
						cliente.setDataNascimento(dataNascimento);
						cliente.setTelefone(txtTelefone.getText());
						endereco.setCep(txtCep.getText());
						endereco = EnderecoPersistencia.pequisarPorCEP(endereco);
						if(endereco != null) {
							cliente.setEndereco(endereco);
							cliente.setComplemento(txtComplemento.getText());
							cliente.setNumero(Integer.parseInt(txtNumero.getText()));
							if(ClientePersistencia.editar(cliente) == true) {
								JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!");
							}else {									
								JOptionPane.showMessageDialog(null, "Dados não podem ser alterados no momento!");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Endereço não cadastrado!");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Data Invalida!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "CPF Invalido!");
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
					if(ClientePersistencia.excluir(cliente)) {
						JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
					}else {
						JOptionPane.showMessageDialog(null, "Impossivel excluir o cliente no momento!");	
					}
				}
			}
		});
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 15));
		btnExcluir.setBounds(240, 75, 100, 30);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnBuscarCEP = new JButton("Buscar");
		btnBuscarCEP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Endereco endereco = new Endereco();
				endereco.setCep(txtCep.getText());
				endereco = EnderecoPersistencia.pequisarPorCEP(endereco);
				if (endereco != null) {
					txtEndereco.setText(endereco.getLogradouro() + " , " + endereco.getBairro() + " , " + 
							endereco.getCidade());
				}else {
					JOptionPane.showMessageDialog(null, "Cep não encontrado!");
				}
			}
		});
		btnBuscarCEP.setFont(new Font("Arial", Font.BOLD, 15));
		btnBuscarCEP.setBounds(281, 331, 100, 30);
		frame.getContentPane().add(btnBuscarCEP);
	}
}
