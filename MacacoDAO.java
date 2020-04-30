package mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dados.Macaco;

public class MacacoDAO {
	public static void salvarMacacoDB(Macaco macaco) throws Exception {
		// -----------------------------Atributos

		// tipo de ação a tomar no DB
		String sql = "INSERT INTO macacos(tempMedioLactancia, tempMedioVida, tamMedioAdult, porteFisico) VALUES (?,?,?,?)";

		// cria a variavel de conexao com o banco
		Connection conn = null;

		// cria o preperedStatment
		PreparedStatement pdst = null;

		// Métodos
		try {
			// cria a conexao com o DB
			conn = ConnectionFactory.criarConexaoComServidorMySql();

			// conecta o preparedStatment com o DB
			pdst = conn.prepareStatement(sql);

			// ações a tomar após se conectar ao DB

			// Salva o primeiro parâmetro do objeto no DB
			pdst.setInt(1, macaco.getTempMedLactancia());

			// Salva o segundo parâmetro do objeto no DB
			pdst.setInt(2, macaco.getTempMedVida());

			// Salva o terceiro parametro do objeto no DB
			pdst.setFloat(3, macaco.getTamMedAdulto());

			// Salva o terceiro parametro do objeto no DB
			pdst.setString(4, macaco.getPorteMacaco());

			// inserir realmente no DB (Basta executar os comandos acima)
			pdst.execute();

		} catch (Exception e) {
			// caso haja algum erro de conexao com o banco, ou ao inserir os dados
			// o printStackTrace retorna o log do erro
			e.printStackTrace();
		} finally {
			// Feito a inserção ou o erro, fecha a conexao com o DB...
			try {
				// ...se ela estiver aberto
				if (pdst != null) {
					pdst.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				// retorna o log do erro ao fechar o DB caso exista
				e.printStackTrace();
			}
		}

	}

	public static void deletarMacacoDB(Integer id) throws Exception {
		// Atributos
		String sql = "DELETE FROM macacos WHERE id = ?"; // Ação a tomar no DB
		Connection conn = null;
		PreparedStatement pdst = null;

		// Métodos
		try {
			// criar conexao com o DB
			conn = ConnectionFactory.criarConexaoComServidorMySql();

			// conectar o preparedStatement com o DB
			pdst = conn.prepareStatement(sql);

			// aponta para o objeto a ser executada a ação (sql)
			pdst.setInt(1, id);

			// executa a açao informada em sql
			pdst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fecha as conexoes...
			try {
				// ...que estiverem abertas
				if (pdst != null) {
					pdst.close();
				}

				if (conn != null) {
					conn.close();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void atualizarMacacoDB(Macaco macaco, Integer id) throws Exception {
		// Atributos
		String sql = "UPDATE macacos SET tempMedioLactancia = ?, tempMedioVida = ?, tamMedioAdult = ?, porteFisico = ? WHERE id = ?";
		Connection conn = null;
		PreparedStatement pdst = null;

		// Métodos
		try {
			// cria conexao com o DB
			conn = ConnectionFactory.criarConexaoComServidorMySql();

			// conecta o preparedStatement com DB indicando a ação a tomar
			pdst = conn.prepareStatement(sql);

			// Indica o objeto a executar as ações slq a tomar
			pdst.setInt(1, macaco.getTempMedLactancia());
			pdst.setInt(2, macaco.getTempMedVida());
			pdst.setFloat(3, macaco.getTamMedAdulto());
			pdst.setString(4, macaco.getPorteMacaco());
			pdst.setInt(5, id);

			// executa as ações
			pdst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexoes...
			try {
				// ...se estiverem abertas
				if (pdst != null) {
					pdst.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static ArrayList<Macaco> getMacacosFromDB() {
		// Atributos
		ArrayList<Macaco> macacos = new ArrayList<Macaco>();
		String sql = "Select * FROM macacos";
		Connection conn = null;
		PreparedStatement pdst = null;
		ResultSet rSet = null; // Classe que pega os dados do DB

		// Métodos
		try {
			// Cria conexao com o DB
			conn = ConnectionFactory.criarConexaoComServidorMySql();

			// conecta o pdst com o DB indicando a ação a tomar
			pdst = conn.prepareStatement(sql);

			// efetuar pesquisa no DB
			rSet = pdst.executeQuery();

			// enquanto existir dados no DB, atribui ele no ArrayList<Macaco> macacos
			while (rSet.next()) {
				// instancia um objeto auxiliar, atribui os valores do objeto do index
				Macaco macaco = new Macaco(rSet.getInt("tempMedioLactancia"), rSet.getInt("tempMedioVida"),
						rSet.getFloat("tamMedioAdult"), rSet.getString("porteFisico"));

				// atribui o id por aqui para não precisar incluir no construtor padrao
				macaco.setId(rSet.getInt("id"));

				// adiciona o objeto preechido no arraylist
				macacos.add(macaco);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rSet != null) {

					rSet.close();
				}

				if (pdst != null) {

					pdst.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return macacos;
	}
}
