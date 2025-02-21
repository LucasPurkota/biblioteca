package br.edu.up.front;


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
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

import br.edu.up.entidades.Cliente;
import br.edu.up.entidades.Emprestimo;
import br.edu.up.entidades.Funcionario;
import br.edu.up.entidades.ItemEmprestimo;
import br.edu.up.entidades.Livro;
import br.edu.up.negocio.ConverteData;
import br.edu.up.presistencia.ClientePersistencia;
import br.edu.up.presistencia.EmprestimoPersistencia;
import br.edu.up.presistencia.FuncionarioPersistencia;
import br.edu.up.presistencia.ItemEmprestimoPersistencia;
import br.edu.up.presistencia.LivroPersistencia;
import net.bytebuddy.implementation.bytecode.collection.ArrayLength;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class AppEmprestimo {

	JFrame frame;
	private JTextField txtCodigoEmprestimo;
	private JTextField txtDataEmprestimo;
	private JLabel lblDataDevolucao;
	private JTextField txtDataDevolucao;
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
	private List<Livro> livros = new ArrayList<Livro>(); 
	private DefaultListModel<Livro> listModel = new DefaultListModel<>();
	private DefaultListModel<ItemEmprestimo> listModel1 = new DefaultListModel<>();
	private JTextField txtStatus;
	private JLabel lblLivrosEmprestados;

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
		
		lblDataDevolucao = new JLabel("Data Devolução");
		lblDataDevolucao.setFont(new Font("Arial", Font.BOLD, 15));
		lblDataDevolucao.setBounds(455, 131, 120, 15);
		frame.getContentPane().add(lblDataDevolucao);
		
		txtDataDevolucao = new JTextField();
		txtDataDevolucao.setEditable(false);
		txtDataDevolucao.setEnabled(false);
		txtDataDevolucao.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDataDevolucao.setBounds(455, 151, 160, 30);
		frame.getContentPane().add(txtDataDevolucao);
		txtDataDevolucao.setColumns(10);
		
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
		btnFiltrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setCpf(txtCliente.getText());
				cliente = ClientePersistencia.procurarPorCPF(cliente);
				if(cliente != null) {
					txtNomeCliente.setText(cliente.getNome());
				}else {
					JOptionPane.showMessageDialog(null, "Cliente inexistente!");
				}
			}
		});
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
		btnFiltrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();
				funcionario.setCpf(txtCliente.getText());
				funcionario = FuncionarioPersistencia.procuraPorCPF(funcionario);
				if(funcionario != null) {
					txtNomeFuncionario.setText(funcionario.getNome());
				}else {
					JOptionPane.showMessageDialog(null, "Funcionario inexistente!");
				}
			}
		});
		btnFiltrarFuncionario.setFont(new Font("Arial", Font.BOLD, 15));
		btnFiltrarFuncionario.setBounds(275, 271, 30, 30);
		frame.getContentPane().add(btnFiltrarFuncionario);
		
		txtNomeFuncionario = new JTextField();
		txtNomeFuncionario.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNomeFuncionario.setEnabled(false);
		txtNomeFuncionario.setBounds(315, 271, 300, 30);
		frame.getContentPane().add(txtNomeFuncionario);
		txtNomeFuncionario.setColumns(10);
		
		lblLivro = new JLabel("Livros Disponiveis");
		lblLivro.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivro.setFont(new Font("Arial", Font.BOLD, 15));
		lblLivro.setBounds(95, 371, 200, 15);
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
							emprestimo.setFuncionario(funcionario);
							if(EmprestimoPersistencia.incluir(emprestimo)) {
								JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso!");
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
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emprestimo.setCodigoEmprestimo(txtCodigoEmprestimo.getText());
				emprestimo.setDataEmprestimo(ConverteData.converterData(txtDataEmprestimo.getText()));
				Cliente cliente = new Cliente();
				cliente.setCpf(txtCliente.getText());
				cliente = ClientePersistencia.procurarPorCPF(cliente);
				if (cliente != null) {
					emprestimo.setCliente(cliente);
					Funcionario funcionario = new Funcionario();
					funcionario.setCpf(txtFuncionario.getText());
					funcionario = FuncionarioPersistencia.procuraPorCPF(funcionario);
					if (funcionario != null) {
						emprestimo.setFuncionario(funcionario);
						if(EmprestimoPersistencia.editar(emprestimo)) {
							JOptionPane.showMessageDialog(null, "Emprestimo editado com sucesso!");
						}else {
							JOptionPane.showMessageDialog(null, "Não foi possivel editar os dados no momento!");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Funcionario não cadastrado!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
				}
			}
		});
		btnEditar.setFont(new Font("Arial", Font.BOLD, 15));
		btnEditar.setBounds(195, 75, 100, 30);
		frame.getContentPane().add(btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Confirmar exlusão?", "Excluir", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					if(EmprestimoPersistencia.excluir(emprestimo)) {
						JOptionPane.showMessageDialog(null, "Emprestimo excluido com sucesso!");
					}else {
						JOptionPane.showMessageDialog(null, "Impossivel excluir o Emprestimo no momento!");	
					}
				}
			}
		});
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 15));
		btnExcluir.setBounds(305, 75, 100, 30);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.setEnabled(false);
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date atual = new Date();
//				JOptionPane.showMessageDialog(null, atual);
				emprestimo.setDevolvido(true);
				emprestimo.setDataDevolucao(atual);
				if(EmprestimoPersistencia.editar(emprestimo)) {
					for(int i = 0; i < listModel1.getSize(); i++) {
						Livro livro = listModel1.getElementAt(i).getLivro();
						livro.setEmprestado(false);
						LivroPersistencia.editar(livro);
					}
					btnDevolver.setEnabled(false);
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Devolução realizada com sucesso!");
				}else {
					JOptionPane.showMessageDialog(null, "Não foi possivel realizar a devolução no momento!");
				}
			}
		});
		btnDevolver.setFont(new Font("Arial", Font.BOLD, 15));
		btnDevolver.setBounds(275, 331, 100, 30);
		frame.getContentPane().add(btnDevolver);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emprestimo.setCodigoEmprestimo(txtCodigoEmprestimo.getText());
				emprestimo = EmprestimoPersistencia.procurarPorCodigo(emprestimo);
				if(emprestimo != null) {
					txtCodigoEmprestimo.setText(emprestimo.getCodigoEmprestimo());
					txtDataEmprestimo.setText(ConverteData.converteDataString(emprestimo.getDataEmprestimo()));
					txtDataDevolucao.setText(ConverteData.converteDataString(emprestimo.getDataDevolucao()));
					txtCliente.setText(emprestimo.getCliente().getCpf());
					txtNomeCliente.setText(emprestimo.getCliente().getNome());
					txtFuncionario.setText(emprestimo.getFuncionario().getCpf());
					txtNomeFuncionario.setText(emprestimo.getFuncionario().getNome());
					ItemEmprestimo item = new ItemEmprestimo();
					item.setEmprestimo(emprestimo);
					List<ItemEmprestimo> itens = new ArrayList<ItemEmprestimo>();
					itens = ItemEmprestimoPersistencia.listarItens(item);
					for(ItemEmprestimo itemEmp : itens) {						
						listModel1.addElement(itemEmp);
					}
					if(emprestimo.getDevolvido()) {
						txtStatus.setText("Devolvido");
						btnEditar.setEnabled(false);
						btnExcluir.setEnabled(false);
						btnIncluir_1.setEnabled(false);
						btnExcluir_1.setEnabled(false);
					}else {
						txtStatus.setText("Em Aberto");
						btnEditar.setEnabled(true);
						btnExcluir.setEnabled(true);
						btnIncluir_1.setEnabled(true);
						btnExcluir_1.setEnabled(true);
					}
					btnDevolver.setEnabled(true);
					JOptionPane.showMessageDialog(null, "Emprestimo encontrado com sucesso!" + emprestimo.getIdEmprestimo());
				}else {
					JOptionPane.showMessageDialog(null, "Emprestimo não encontrado!");
				}
			}
		});
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
		
		
		JList<Livro> list = new JList<Livro>();
		list.setBounds(95, 391, 200, 250);
		frame.getContentPane().add(list);
		livros = LivroPersistencia.listarLivro();
		for(Livro livro : livros) {
			listModel.addElement(livro);
		}
		list.setModel(listModel);
		
		JList<ItemEmprestimo> list_1 = new JList<ItemEmprestimo>();
		list_1.setBounds(415, 391, 200, 250);
		frame.getContentPane().add(list_1);
		list_1.setModel(listModel1);
		
		btnIncluir_1 = new JButton(">");
		btnIncluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
				if (selectedIndex != -1) {
					Livro selectedItem = listModel.getElementAt(selectedIndex);
					ItemEmprestimo item = new ItemEmprestimo();
					item.setLivro(selectedItem);
					item.setEmprestimo(emprestimo);
					if(ItemEmprestimoPersistencia.incluir(item)) {
						JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso!");
						selectedItem.setEmprestado(true);
						LivroPersistencia.editar(selectedItem);
						listModel.remove(selectedIndex);
						listModel1.addElement(item);
					}else {
						JOptionPane.showMessageDialog(null, "Livro não pode ser adicionado no momento!");
					}
				}
			}
		});
		btnIncluir_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnIncluir_1.setBounds(305, 482, 100, 30);
		frame.getContentPane().add(btnIncluir_1);
		
		btnExcluir_1 = new JButton("<");
		btnExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list_1.getSelectedIndex();
				if (selectedIndex != -1) {
					ItemEmprestimo selectedItem = listModel1.getElementAt(selectedIndex);
					Livro livro = selectedItem.getLivro();
					if(ItemEmprestimoPersistencia.excluir(selectedItem)) {
						JOptionPane.showMessageDialog(null, "Item excluido com sucesso!");
						livro.setEmprestado(false);
						LivroPersistencia.editar(livro);
						listModel1.remove(selectedIndex);
						listModel.addElement(livro);						
					}else {
						JOptionPane.showMessageDialog(null, "Item não pode ser excluido no momento!");
					}
				}
			}
		});
		btnExcluir_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnExcluir_1.setBounds(305, 522, 100, 30);
		frame.getContentPane().add(btnExcluir_1);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Arial", Font.BOLD, 15));
		lblStatus.setBounds(95, 311, 120, 15);
		frame.getContentPane().add(lblStatus);
		
		txtStatus = new JTextField();
		txtStatus.setFont(new Font("Arial", Font.PLAIN, 15));
		txtStatus.setEnabled(false);
		txtStatus.setEditable(false);
		txtStatus.setColumns(10);
		txtStatus.setBounds(95, 331, 160, 30);
		frame.getContentPane().add(txtStatus);
		
		lblLivrosEmprestados = new JLabel("Livros Emprestados");
		lblLivrosEmprestados.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivrosEmprestados.setFont(new Font("Arial", Font.BOLD, 15));
		lblLivrosEmprestados.setBounds(415, 373, 200, 15);
		frame.getContentPane().add(lblLivrosEmprestados);
	}
}
