package principal;

import java.util.ArrayList;
import dados.*;
import mySql.BaleiaDAO;
import mySql.ElefanteDAO;
import mySql.MacacoDAO;
import saida.*;
import validacao.*;

public class Principal {

	public static void main(String[] args) throws Exception {
		// Atributos
		final Integer MAXIMO_CADASTROS = 500;
		Integer totalCadastros = 0;
		Integer tipoMamifero = null, escolhaInicial, idDelAlt;
		ArrayList<Macaco> macacos = new ArrayList<Macaco>();
		ArrayList<Elefante> elefantes = new ArrayList<Elefante>();
		ArrayList<Baleia> baleias = new ArrayList<Baleia>();

		// tipo de mamifero : macaco = 0
		// tipo de mamifero : elefante = 1
		// tipo de mamifero : baleia = 2
		// -----------------------------------------------
		// tipo de pergunta = posição do parametro no construtor
		// tipo de pergunta : tempo medio de lactancia = 0
		// tipo de pergunta : tempo medio de vida = 1
		// tipo de pergunta : tamanho medio adulto = 2
		// tipo de pergunta : porte fisico = 3
		// tipo de pergunta : habitat natural = 4
		// tipo de pergunta : peso = 5

		// Métodos
		do {
			// ler objetos do DB e preencher os arrayList para trabalhar na RAM
			macacos = MacacoDAO.getMacacosFromDB();
			elefantes = ElefanteDAO.getElefantesFromDB();
			baleias = BaleiaDAO.getBaleiasFromDB();

			escolhaInicial = Valida.menuInicial();// retorna o tipo de ação a tomar (add,del,alt)
			tipoMamifero = Valida.menuMamiferos(escolhaInicial); // retorna o número da opção de mamífero

			if (escolhaInicial == 0) {
				// ---------------------------------CADASTRO-----------------------------------------
				if (tipoMamifero == 0) {
					// instancia Macaco
					Macaco macaco = new Macaco(Valida.dadosInteger(0, 0), Valida.dadosInteger(0, 1),
							Valida.dadosFloat(0, 2), Valida.dadosString(tipoMamifero, 3));

					// Salva no arrayList para comparar com o resultado do DB
					macacos.add(macaco);

					// Salva o objeto macaco no DB
					MacacoDAO.salvarMacacoDB(macaco);

				} else if (tipoMamifero == 1) {
					// instancia Elefante
					Elefante elefante = new Elefante(Valida.dadosInteger(1, 0), Valida.dadosInteger(1, 1),
							Valida.dadosFloat(1, 2), Valida.dadosFloat(1, 5), Valida.dadosString(1, 4));

					// Atribui ao arrayList de elefantes para comparar com DB
					elefantes.add(elefante);

					// Salva o objeto elefante no DB
					ElefanteDAO.salvarElefanteDB(elefante);

				} else if (tipoMamifero == 2) {
					// instanciaBaleia
					Baleia baleia = new Baleia(Valida.dadosInteger(2, 0), Valida.dadosInteger(2, 1),
							Valida.dadosFloat(2, 2), Valida.dadosFloat(2, 5));

					// Atribui ao arrayList de baleias para comparar com DB
					baleias.add(baleia);

					// Salva o objeto baleia no DB
					BaleiaDAO.salvaBaleiaDB(baleia);

				}
			} else if (escolhaInicial == 1) {
				// -----------------------------DELETAR----------------------------------------
				Saida.mostrarCadastros(macacos, elefantes, baleias);
				idDelAlt = Valida.escolhaId();

				if (tipoMamifero == 0) {
					MacacoDAO.deletarMacacoDB(idDelAlt);
				} else if (tipoMamifero == 1) {
					ElefanteDAO.deletarElefantDB(idDelAlt);
				} else if (tipoMamifero == 2) {
					BaleiaDAO.deletarBaleiaDB(idDelAlt);
				}
			} else if (escolhaInicial == 2) {
				// ----------------------------ALTERAR-----------------------------------------
				Saida.mostrarCadastros(macacos, elefantes, baleias);
				idDelAlt = Valida.escolhaId();

				if (tipoMamifero == 0) {
					// instancia Macaco
					Macaco macaco = new Macaco(Valida.dadosInteger(0, 0), Valida.dadosInteger(0, 1),
							Valida.dadosFloat(0, 2), Valida.dadosString(tipoMamifero, 3));

					// Salva no arrayList para comparar com o resultado do DB
					macacos.add(macaco);

					// Altera o objeto macaco no DB
					MacacoDAO.atualizarMacacoDB(macaco, idDelAlt);

				} else if (tipoMamifero == 1) {
					// instancia Elefante
					Elefante elefante = new Elefante(Valida.dadosInteger(1, 0), Valida.dadosInteger(1, 1),
							Valida.dadosFloat(1, 2), Valida.dadosFloat(1, 5), Valida.dadosString(1, 4));

					// Atribui ao arrayList de elefantes para comparar com DB
					elefantes.add(elefante);

					// Salva o objeto elefante no DB
					ElefanteDAO.atualizarElefanteDB(elefante, idDelAlt);

				} else if (tipoMamifero == 2) {
					// instanciaBaleia
					Baleia baleia = new Baleia(Valida.dadosInteger(2, 0), Valida.dadosInteger(2, 1),
							Valida.dadosFloat(2, 2), Valida.dadosFloat(2, 5));

					// Atribui ao arrayList de baleias para comparar com DB
					baleias.add(baleia);

					// Salva o objeto baleia no DB
					BaleiaDAO.atualizarBaleiaDB(baleia, idDelAlt);

				}
			} else {
				Saida.mostrarCadastros(macacos, elefantes, baleias);
			}

			totalCadastros += (macacos.size() + elefantes.size() + baleias.size());
		} while (Valida.continua(totalCadastros, MAXIMO_CADASTROS));

	}
}
