package br.edu.up.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.UIManager;

import br.edu.up.entidades.Cliente;
import br.edu.up.entidades.Emprestimo;
import br.edu.up.entidades.Funcionario;
import br.edu.up.entidades.Livro;
import br.edu.up.negocio.ConverteData;
import br.edu.up.presistencia.ClientePersistencia;
import br.edu.up.presistencia.EmprestimoPersistencia;
import br.edu.up.presistencia.FuncionarioPersistencia;
import br.edu.up.presistencia.LivroPersistencia;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	private JLabel lblEmpretimo;
	private JButton btnIncluir;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnFiltrar;
	private JButton btnVoltar;
	private JButton btnIncluir_1;
	private JButton btnExcluir_1;

	public AppEmprestimo() {
		initialize();
	}

	private Emprestimo emprestimo = new Emprestimo();
	private List<Livro> livros = new ArrayList();
	private DefaultListModel<Livro> listModel = new DefaultListModel<>();
	private DefaultListModel<Livro> listModel1 = new DefaultListModel<>();

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lucas\\eclipse-workspace\\Biblioteca_vrs2\\src\\assets\\book.png"));
		frame.setBounds(100, 100, 710, 700);
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
		txtCodigoEmprestimo.setBounds(95, 151, 160, 30);
		frame.getContentPane().add(txtCodigoEmprestimo);
		txtCodigoEmprestimo.setColumns(10);
		
		JLabel lblDataEmprestimo = new JLabel("Data Emprestimo");
		lblDataEmprestimo.setFont(new Font("Arial", Font.BOLD, 15));
		lblDataEmprestimo.setBounds(275, 131, 151, 15);
		frame.getContentPane().add(lblDataEmprestimo);
		
		txtDataEmprestimo = new JTextField();
		txtDataEmprestimo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDataEmprestimo.setBounds(275, 151, 160, 30);
		frame.getContentPane().add(txtDataEmprestimo);
		txtDataEmprestimo.setColumns(10);
		
		lblDataDevolução = new JLabel("Data Devolução");
		lblDataDevolução.setFont(new Font("Arial", Font.BOLD, 15));
		lblDataDevolução.setBounds(455, 131, 120, 15);
		frame.getContentPane().add(lblDataDevolução);
		
		txtDataDevolução = new JTextField();
		txtDataDevolução.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDataDevolução.setBounds(455, 151, 160, 30);
		frame.getContentPane().add(txtDataDevolução);
		txtDataDevolução.setColumns(10);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Arial", Font.BOLD, 15));
		lblCliente.setBounds(95, 191, 120, 15);
		frame.getContentPane().add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCliente.setBounds(95, 211, 180, 30);
		frame.getContentPane().add(txtCliente);
		txtCliente.setColumns(10);
		
		btnFiltrarCliente = new JButton("...");
		btnFiltrarCliente.setFont(new Font("Arial", Font.BOLD, 15));
		btnFiltrarCliente.setBounds(275, 211, 30, 30);
		frame.getContentPane().add(btnFiltrarCliente);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNomeCliente.setEnabled(false);
		txtNomeCliente.setBounds(315, 211, 300, 30);
		frame.getContentPane().add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		lblFuncionario = new JLabel("Funcionario");
		lblFuncionario.setFont(new Font("Arial", Font.BOLD, 15));
		lblFuncionario.setBounds(95, 251, 90, 15);
		frame.getContentPane().add(lblFuncionario);
		
		txtFuncionario = new JTextField();
		txtFuncionario.setFont(new Font("Arial", Font.PLAIN, 15));
		txtFuncionario.setBounds(95, 271, 180, 30);
		frame.getContentPane().add(txtFuncionario);
		txtFuncionario.setColumns(10);
		
		btnFiltrarFuncionario = new JButton("...");
		btnFiltrarFuncionario.setFont(new Font("Arial", Font.BOLD, 15));
		btnFiltrarFuncionario.setBounds(275, 271, 30, 30);
		frame.getContentPane().add(btnFiltrarFuncionario);
		
		txtNomeFuncionario = new JTextField();
		txtNomeFuncionario.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNomeFuncionario.setEnabled(false);
		txtNomeFuncionario.setBounds(315, 271, 300, 30);
		frame.getContentPane().add(txtNomeFuncionario);
		txtNomeFuncionario.setColumns(10);
		
		lblLivro = new JLabel("Livros");
		lblLivro.setFont(new Font("Arial", Font.BOLD, 15));
		lblLivro.setBounds(95, 311, 60, 15);
		frame.getContentPane().add(lblLivro);
		
		lblEmpretimo = new JLabel("Emprestimo");
		lblEmpretimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpretimo.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmpretimo.setBounds(255, 20, 200, 40);
		frame.getContentPane().add(lblEmpretimo);
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emprestimo.setCodigoEmprestimo(txtCodigoEmprestimo.getText());
				if (EmprestimoPersistencia.procurarPorCodigo(emprestimo) == null) {
					emprestimo.setDataEmprestimo(ConverteData.converterData(txtDataEmprestimo.getText()));
					emprestimo.setDevolvido(false);
					Cliente cliente = new Cliente();
					cliente.setCpf(txtCliente.getText());
					cliente = ClientePersistencia.procurarPorCPF(cliente);
					if (cliente != null) {
						emprestimo.setCliente(cliente);
						Funcionario funcionario = new Funcionario();
						funcionario.setCpf(txtFuncionario.getText());
						funcionario = FuncionarioPersistencia.procuraPorCPF(funcionario);
						if (funcionario != null) {
							emprestimo.setFuncionario(null);
							List<Livro> livros1 = new ArrayList<>();
							for (int i = 0; i <  listModel1.getSize(); i++) {
								livros1.add(listModel.getElementAt(i));
							}
							if(EmprestimoPersistencia.incluir(emprestimo)) {
								JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso");
							}else {
								JOptionPane.showMessageDialog(null, "Não foi possivel inserir os dados no momento!");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Funcionario não cadastrado!");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Codigo ja utilizado!");
				}				
			}
		});
		btnIncluir.setFont(new Font("Arial", Font.BOLD, 15));
		btnIncluir.setBounds(85, 75, 100, 30);
		frame.getContentPane().add(btnIncluir);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.BOLD, 15));
		btnEditar.setBounds(195, 75, 100, 30);
		frame.getContentPane().add(btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 15));
		btnExcluir.setBounds(305, 75, 100, 30);
		frame.getContentPane().add(btnExcluir);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Arial", Font.BOLD, 15));
		btnFiltrar.setBounds(415, 75, 100, 30);
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
		btnVoltar.setBounds(525, 75, 100, 30);
		frame.getContentPane().add(btnVoltar);
		
		
		JList list = new JList();
		list.setBounds(95, 331, 200, 300);
		frame.getContentPane().add(list);
		livros = LivroPersistencia.listarLivro();
		for(Livro livro : livros) {
			listModel.addElement(livro);
		}
		list.setModel(listModel);
		
		JList list_1 = new JList(listModel1);
		list_1.setBounds(415, 331, 200, 300);
		frame.getContentPane().add(list_1);
		
		btnIncluir_1 = new JButton(">");
		btnIncluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
				if (selectedIndex != -1) {
					
					Livro selectedItem = listModel.getElementAt(selectedIndex);
					listModel.remove(selectedIndex);
					listModel1.addElement(selectedItem);
				}
			}
		});
		btnIncluir_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnIncluir_1.setBounds(305, 446, 100, 30);
		frame.getContentPane().add(btnIncluir_1);
		
		btnExcluir_1 = new JButton("<");
		btnExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list_1.getSelectedIndex();
				if (selectedIndex != -1) {
					
					Livro selectedItem = listModel1.getElementAt(selectedIndex);
					listModel1.remove(selectedIndex);
					listModel.addElement(selectedItem);
				}
			}
		});
		btnExcluir_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnExcluir_1.setBounds(305, 486, 100, 30);
		frame.getContentPane().add(btnExcluir_1);
	}
}
