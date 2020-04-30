package mySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dados.Elefante;

public class ElefanteDAO {
	public static void salvarElefanteDB(Elefante elefante) {
		// Atributos
		String sql = "INSERT INTO elefantes(tempMedioLactancia, tempMedioVida, tamMedioAdult, peso, habitatNatural) VALUES(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pdst = null;

		// Métodos
		try {
			// cria conexao com o DB
			conn = ConnectionFactory.criarConexaoComServidorMySql();

			// Conecta o preparedStatement com o DB
			pdst = conn.prepareStatement(sql);

			// indica as açoes do comando sql a serem tomadas
			pdst.setInt(1, elefante.getTempMedLactancia());
			pdst.setInt(2, elefante.getTempMedVida());
			pdst.setFloat(3, elefante.getTamMedAdulto());
			pdst.setFloat(4, elefante.getPeso());
			pdst.setString(5, elefante.getHabitatNatural());

			// executa as ações
			pdst.execute();

		} catch (Exception e) {
			// caso haja erro, retorna o log
			e.printStackTrace();
		} finally {
			// Fecha a conexao com o DB...
			try {
				// ...se ela estiver aberta
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

	public static void deletarElefantDB(Integer id) throws Exception {
		// Atributos
		String sql = "DELETE FROM elefantes WHERE id = ?"; // comando a executar no DB
		Connection conn = null;
		PreparedStatement pdst = null;

		// Métodos
		try {
			// cria conexao com o DB
			conn = ConnectionFactory.criarConexaoComServidorMySql();

			// conecta o pdst com o DB indicando o tipo de açao a tomar
			pdst = conn.prepareStatement(sql);

			// indica o objeto a ser deletado
			pdst.setInt(1, id);

			// executa a ação da variavel sql
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
					pdst.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void atualizarElefanteDB(Elefante elefante, Integer id) throws Exception {
		// Atributos
		String sql = "UPDATE elefantes SET tempMedioLactancia = ?, tempMedioVida = ?, tamMedioAdult = ?, peso = ?, habitatNatural = ? WHERE id = ?";
		Connection conn = null;
		PreparedStatement pdst = null;

		// Métodos
		try {
			// cria conexao com o DB
			conn = ConnectionFactory.criarConexaoComServidorMySql();

			// Conecta o preparedStatement com o DB
			pdst = conn.prepareStatement(sql);

			// indica as açoes do comando sql a serem tomadas
			pdst.setInt(1, elefante.getTempMedLactancia());
			pdst.setInt(2, elefante.getTempMedVida());
			pdst.setFloat(3, elefante.getTamMedAdulto());
			pdst.setFloat(4, elefante.getPeso());
			pdst.setString(5, elefante.getHabitatNatural());
			pdst.setInt(6, id);

			// executa as ações
			pdst.execute();

		} catch (Exception e) {
			// caso haja erro, retorna o log
			e.printStackTrace();
		} finally {
			// Fecha a conexao com o DB...
			try {
				// ...se ela estiver aberta
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

	public static ArrayList<Elefante> getElefantesFromDB() {
		// Atributos
		ArrayList<Elefante> elefantes = new ArrayList<Elefante>();
		String sql = "SELECT * FROM elefantes";
		Connection conn = null;
		PreparedStatement pdst = null;
		ResultSet rSet = null;

		// Métodos
		try {
			// cria conexao com DB
			conn = ConnectionFactory.criarConexaoComServidorMySql();

			// conecta o pdst com o DB e inidica a ação a tomar
			pdst = conn.prepareStatement(sql);

			// faz a leitura do DB e salva no rSet
			rSet = pdst.executeQuery();

			// Enquanto houver objetos, preenche dados na ram e salva em array
			while (rSet.next()) {
				// instancia objeto auxiliar e preenche com dados do DB
				Elefante elefante = new Elefante(rSet.getInt("tempMedioLactancia"), rSet.getInt("tempMedioVida"),
						rSet.getFloat("tamMedioAdult"), rSet.getFloat("peso"), rSet.getString("habitatNatural"));

				// Preenche o id fora do contrutor para nao ter que incluir o id no construtor
				elefante.setId(rSet.getInt("id"));

				// atribui o objeto auxiliar no vetor de objetos
				elefantes.add(elefante);
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
		return elefantes;
	}
}
