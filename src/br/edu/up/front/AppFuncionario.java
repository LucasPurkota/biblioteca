package br.edu.up.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.up.entidades.Endereco;
import br.edu.up.entidades.Funcionario;
import br.edu.up.presistencia.FuncionarioPersistencia;
import br.edu.up.negocio.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppFuncionario window = new AppFuncionario();
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
	public AppFuncionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 311);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(20, 20, 45, 15);
		frame.getContentPane().add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(20, 40, 100, 20);
		frame.getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(130, 20, 45, 15);
		frame.getContentPane().add(lblRg);
		
		txtRg = new JTextField();
		txtRg.setBounds(130, 40, 100, 20);
		frame.getContentPane().add(txtRg);
		txtRg.setColumns(10);
		
		JLabel lblNascimento = new JLabel("Data Nascimento");
		lblNascimento.setBounds(240, 20, 100, 15);
		frame.getContentPane().add(lblNascimento);
		
		txtNascimento = new JTextField();
		txtNascimento.setBounds(240, 40, 100, 20);
		frame.getContentPane().add(txtNascimento);
		txtNascimento.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(20, 70, 45, 15);
		frame.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(20, 90, 320, 19);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(20, 120, 60, 15);
		frame.getContentPane().add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(20, 140, 150, 20);
		frame.getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(190, 119, 45, 15);
		frame.getContentPane().add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(190, 140, 150, 19);
		frame.getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(20, 170, 45, 15);
		frame.getContentPane().add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(20, 190, 100, 20);
		frame.getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(130, 170, 80, 15);
		frame.getContentPane().add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(130, 190, 100, 20);
		frame.getContentPane().add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(240, 170, 45, 15);
		frame.getContentPane().add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(240, 190, 100, 20);
		frame.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dataNascimento;
				Endereco endereco = new Endereco();
				Funcionario funcionario = new Funcionario();
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
		btnConfirmar.setBounds(20, 230, 100, 30);
		frame.getContentPane().add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnVoltar.setBounds(130, 230, 100, 30);
		frame.getContentPane().add(btnVoltar);
	}
}
