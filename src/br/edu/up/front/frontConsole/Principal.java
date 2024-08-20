package br.edu.up.front;

public class Principal {
	public static void main(String[] args) {
		int opcao = 0;
		
		do {
			System.out.println("\n\n***Menu Principal***");
			System.out.println("\n1 - Endereco");
			System.out.println("2 - Cliente");
			System.out.println("3 - Funcionário");
			System.out.println("4 - Livro");
			System.out.println("5 - Emprestimo");
			System.out.println("6 - Sair");
			opcao = Console.readInt("Informe a opção: ");
			
			switch(opcao) {
			case 1:
				new AppEndreco();				
			break;
			case 2:
				new AppCliente();	
			break;
			case 3:
				new AppFuncionario();				
			break;
			case 4:
				new AppLivro();
			break;
			case 5:
				new AppEmprestimo();
			break;
			}
		}while(opcao != 6);
		
	}
}
