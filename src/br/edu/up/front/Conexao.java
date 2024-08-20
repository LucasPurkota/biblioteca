package br.edu.up.front;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private String url;
    private String usuario;
    private String senha;
    private Connection con;

    public Conexao(){
        url = "jdbc:mysql://127.0.0.1:3306/biblioteca?serverTimezone=UTC";
        usuario = "root";
        senha = "Lucas.2410";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,usuario,senha);

            System.out.println("Conexão realizada!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
