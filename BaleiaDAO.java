package mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dados.Baleia;

public class BaleiaDAO {
	public static void salvaBaleiaDB(Baleia baleia) {
		// Atributos
		String sql = "INSERT INTO baleias(tempMedioLactancia, tempMedioVida, tamMedioAdult, peso) VALUES(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pdst = null;

		// Métodos
		try {
			// cria a conexao com o DB
			conn = ConnectionFactory.criarConexaoComServidorMySql();

			// Conecta o preparedStatement com o servidor
			pdst = conn.prepareStatement(sql);

			// indica os objetos a executar os comandos de sql
			pdst.setInt(1, baleia.getTempMedLactancia());
			pdst.setInt(2, baleia.getTempMedVida());
			pdst.setFloat(3, baleia.getTamMedAdulto());
			pdst.setFloat(4, baleia.getPeso());

			// executa os comandos de inserção
			pdst.execute();

		} catch (Exception e) {
			// Caso haja erro, retorna o log
			e.printStackTrace();
		} finally {
			// fecha as conexoes com o DB...
			try {
				// ...se elas estiverem abertas
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

	public static void deletarBaleiaDB(Integer id) throws Exception {
		// Atributos
		String sql = "DELETE FROM baleias WHERE id = ?";
		Connection conn = null;
		PreparedStatement pdst = null;

		// Métodos
		try {
			// cria conexao com o DB
			conn = ConnectionFactory.criarConexaoComServidorMySql();

			// Conecta o pdst com DB indicando a ação a tomar
			pdst = conn.prepareStatement(sql);

			// indica o objeto a executar a ação
			pdst.setInt(1, id);

			// executa a ação
			pdst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fecha as conexoes...
			try {
				// ...caso existam
				if (pdst != null) {
					pdst.close();
				}

				if (pdst != null) {
					pdst.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void atualizarBaleiaDB(Baleia baleia, Integer id) throws Exception {
		// Atributos
		String sql = "UPDATE baleias SET tempMedioLactancia = ?, tempMedioVida = ?, tamMedioAdult = ?, peso = ? WHERE id = ?";
		Connection conn = null;
		PreparedStatement pdst = null;

		// Métodos
		try {
			// cria a conexao com o DB
			conn = ConnectionFactory.criarConexaoComServidorMySql();

			// Conecta o preparedStatement com o servidor
			pdst = conn.prepareStatement(sql);

			// indica os objetos a executar os comandos de sql
			pdst.setInt(1, baleia.getTempMedLactancia());
			pdst.setInt(2, baleia.getTempMedVida());
			pdst.setFloat(3, baleia.getTamMedAdulto());
			pdst.setFloat(4, baleia.getPeso());
			pdst.setInt(5, id);

			// executa os comandos de inserção
			pdst.execute();

		} catch (Exception e) {
			// Caso haja erro, retorna o log
			e.printStackTrace();
		} finally {
			// fecha as conexoes com o DB...
			try {
				// ...se elas estiverem abertas
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

	public static ArrayList<Baleia> getBaleiasFromDB() {
		// Atributos
		ArrayList<Baleia> baleias = new ArrayList<Baleia>();
		String sql = "SELECT * FROM baleias";
		Connection conn = null;
		PreparedStatement pdst = null;
		ResultSet rSet = null;

		// Métodos
		try {
			// cria conexao com DB
			conn = ConnectionFactory.criarConexaoComServidorMySql();

			// conecta o pdst com DB e indica ação
			pdst = conn.prepareStatement(sql);

			// Faz a leitura do DB e armazena no objeto rSet
			rSet = pdst.executeQuery();

			// Equanto houver objetos no rSet salva no arrayList
			while (rSet.next()) {
				// instancia objeto baleia auxiliar
				Baleia baleia = new Baleia(rSet.getInt("tempMedioLactancia"), rSet.getInt("tempMedioVida"),
						rSet.getFloat("tamMedioAdult"), rSet.getFloat("peso"));

				// salva o id fora do construtor para ele nao precisar fazer parte do construtor
				baleia.setId(rSet.getInt("id"));

				// atribui o objeto preenchido no arrayList
				baleias.add(baleia);
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
		return baleias;
	}
}
