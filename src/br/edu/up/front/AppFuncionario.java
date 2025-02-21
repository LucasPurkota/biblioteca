package br.edu.up.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.up.entidades.Endereco;
import br.edu.up.entidades.Funcionario;
import br.edu.up.presistencia.EnderecoPersistencia;
import br.edu.up.presistencia.FuncionarioPersistencia;
import br.edu.up.negocio.*;

import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class AppFuncionario {

	JFrame frame;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtNascimento;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtSenha;
	private JTextField txtCep;
	private JTextField txtComplemento;
	private JTextField txtNumero;
	private JTextField textField;

	public AppFuncionario() {
		initialize();
	}
	
	private Funcionario funcionario = new Funcionario();
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lucas\\eclipse-workspace\\Biblioteca_vrs2\\src\\assets\\book.png"));
		frame.setBounds(100, 100, 600, 500 );
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
		lblNascimento.setBounds(370, 131, 150, 15);
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
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 15));
		lblSenha.setBounds(110, 311, 120, 15);
		frame.getContentPane().add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		txtSenha.setBounds(110, 331, 140, 30);
		frame.getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Arial", Font.BOLD, 15));
		lblCep.setBounds(260, 311, 45, 15);
		frame.getContentPane().add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCep.setBounds(260, 331, 120, 30);
		frame.getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
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
				funcionario.setCpf(txtCpf.getText());
				if(ValidaCPF.isCPF(funcionario.getCpf())) {
					if(FuncionarioPersistencia.procuraPorCPF(funcionario) == null) {
						funcionario.setRg(txtRg.getText());
						funcionario.setNome(txtNome.getText());
						dataNascimento = ConverteData.converterData(txtNascimento.getText());
						if(dataNascimento != null) {
							funcionario.setDataNascimento(dataNascimento);
							funcionario.setTelefone(txtTelefone.getText());
							funcionario.setSenha(txtSenha.getText());
							endereco.setCep(txtCep.getText());
							endereco = EnderecoPersistencia.pequisarPorCEP(endereco);
							if(endereco != null) {
								funcionario.setEndereco(endereco);
								funcionario.setComplemento(txtComplemento.getText());
								funcionario.setNumero(Integer.parseInt(txtNumero.getText()));
								if(FuncionarioPersistencia.incluir(funcionario) == true) {
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
						JOptionPane.showMessageDialog(null, "Funcionario ja Cadastrado!");
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
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionario.setCpf(txtCpf.getText());
				funcionario = FuncionarioPersistencia.procuraPorCPF(funcionario);
				if(funcionario != null) {
					String dataNasc;
					txtCpf.setText(funcionario.getCpf());
					txtRg.setText(funcionario.getRg());
					dataNasc = ConverteData.converteDataString(funcionario.getDataNascimento());
					txtNascimento.setText(dataNasc);
					txtNome.setText(funcionario.getNome());
					txtTelefone.setText(funcionario.getTelefone());
					txtComplemento.setText(funcionario.getComplemento());
					txtNumero.setText(Integer.toString(funcionario.getNumero()));
					txtSenha.setText(funcionario.getSenha());
					txtCep.setText(funcionario.getEndereco().getCep());
					txtEndereco.setText(funcionario.getEndereco().getLogradouro() + " , " + funcionario.getEndereco().getBairro() + " , " + 
							funcionario.getEndereco().getCidade());
				}else {
					JOptionPane.showMessageDialog(null, "Funcionario não encontrado!");
				}
			}
		});
		btnFiltrar.setFont(new Font("Arial", Font.BOLD, 15));
		btnFiltrar.setBounds(350, 75, 100, 30);
		frame.getContentPane().add(btnFiltrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dataNascimento;
				Endereco endereco = new Endereco();
				funcionario.setCpf(txtCpf.getText());
				if(ValidaCPF.isCPF(funcionario.getCpf())) {
					funcionario.setRg(txtRg.getText());
					funcionario.setNome(txtNome.getText());
					dataNascimento = ConverteData.converterData(txtNascimento.getText());
					if(dataNascimento != null) {
						funcionario.setDataNascimento(dataNascimento);
						funcionario.setTelefone(txtTelefone.getText());
						funcionario.setSenha(txtSenha.getText());
						endereco.setCep(txtCep.getText());
						endereco = EnderecoPersistencia.pequisarPorCEP(endereco);
						if(endereco != null) {
							funcionario.setEndereco(endereco);
							funcionario.setComplemento(txtComplemento.getText());
							funcionario.setNumero(Integer.parseInt(txtNumero.getText()));
							if(FuncionarioPersistencia.editar(funcionario) == true) {
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
					if(FuncionarioPersistencia.excluir(funcionario)) {
						JOptionPane.showMessageDialog(null, "Funcionario excluido com sucesso!");
					}else {
						JOptionPane.showMessageDialog(null, "Impossivel excluir o Funcionario no momento!");	
					}
				}
			}
		});
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 15));
		btnExcluir.setBounds(240, 75, 100, 30);
		frame.getContentPane().add(btnExcluir);
		
		JLabel lblCadastaroFuncionario = new JLabel("Cadastro Funcionario");
		lblCadastaroFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastaroFuncionario.setFont(new Font("Arial", Font.BOLD, 20));
		lblCadastaroFuncionario.setBounds(190, 20, 220, 40);
		frame.getContentPane().add(lblCadastaroFuncionario);
		
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
		btnBuscarCEP.setBounds(390, 331, 100, 30);
		frame.getContentPane().add(btnBuscarCEP);
	}
}
