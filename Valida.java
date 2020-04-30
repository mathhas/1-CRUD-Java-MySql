package validacao;

import javax.swing.JOptionPane;

public class Valida {
	public static Integer menuInicial() {
		Integer escolhaInicial;
		String opcaoInicial[] = { "Cadastrar Mam�fero", "Deletar Mam�fero", "Alterar um Cadastro",
				"Vizualizar cadastros" };
		Boolean erro;

		do {
			erro = false;
			// janela de dialogo com op��es iniciais
			escolhaInicial = JOptionPane.showOptionDialog(null, "Escolha uma Op��o para continuar:", "Menu inicial",
					JOptionPane.DEFAULT_OPTION, 3, null, opcaoInicial, opcaoInicial[0]);
			// valida��o de op��es
			if (escolhaInicial == null
					|| (escolhaInicial != 0 && escolhaInicial != 1 && escolhaInicial != 2 && escolhaInicial != 3)) {
				erro = true;
				JOptionPane.showMessageDialog(null, "Escolha uma op��o v�lida para continuar!", "ERRO", 2);
			}
		} while (erro);
		return escolhaInicial;
	}

	public static Integer menuMamiferos(Integer escolhaInicial) {
		// Atributos
		Integer escolha = null;
		String mamiferos[] = { "Macaco", "Elefante", "Baleia" };
		String mensagem = null;
		Boolean erro;

		// M�todos
		if (escolhaInicial == 0) {
			mensagem = "Deseja CADASTRAR Qual tipo de Mam�fero abaixo";
		} else if (escolhaInicial == 1) {
			mensagem = "Deseja DELETAR Qual tipo de Mam�fero abaixo";
		} else if (escolhaInicial == 2) {
			mensagem = "Deseja ALTERAR Qual tipo de Mam�fero abaixo";
		} else if (escolhaInicial == 3) {
			return 3;
		}

		do {
			erro = false;
			escolha = JOptionPane.showOptionDialog(null, mensagem, "Menu De Mam�feros", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, mamiferos, mamiferos[0]);

			if (escolha == null || (escolha != 0 && escolha != 1 && escolha != 2)) {
				erro = true;
				JOptionPane.showMessageDialog(null, "� permitido fechar o programa apenas se fizer um cadastro.",
						"ERRO", 2);
			}
		} while (erro);

		return escolha;
	}

	public static Integer escolhaId() {
		// Atributos
		String escolhaString;
		Integer escolhaID = null;
		Boolean erro;

		// M�todos
		do {
			erro = false;
			escolhaString = JOptionPane.showInputDialog(null, "Digite o ID do mam�fero a ser deletado ou alterado",
					"Dados do Mam�fero", JOptionPane.QUESTION_MESSAGE);
			if (escolhaString == null || escolhaString.length() <= 0) {
				erro = true;
				JOptionPane.showMessageDialog(null, "Insira algum valor para continuar com o cadastro!", "ERRO",
						JOptionPane.WARNING_MESSAGE);
			} else {

				try {
					escolhaID = Integer.parseInt(escolhaString);
				} catch (NumberFormatException e) {
					erro = true;
					JOptionPane.showMessageDialog(null, "Insira apenas valores Inteiros!", "ERRO",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} while (erro);
		return escolhaID;
	}

	public static Boolean continua(Integer totalCadastros, final Integer TOTAL_CADASTROS) {
		Integer opcao = JOptionPane.showConfirmDialog(null, "Deseja continuar Utilizando o programa?",
				"Continuar Programa?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (opcao == 0 && totalCadastros <= TOTAL_CADASTROS) {
			return true;
		} else {
			return false;
		}
	}

	// Valida Integer
	public static Integer dadosInteger(Integer tipoMamifero, Integer tipoPergunta) {
		// Atributos
		Integer dadoInteger = null;
		String dadoString;
		Boolean erro;
		String tipoMamiferoString = null;
		String tipoPerguntaString = null;

		// M�todos

		// Ajuste de pergunta de acordo com construtor de mamifero da main
		if (tipoMamifero == 0) {
			tipoMamiferoString = " Macaco";
		} else if (tipoMamifero == 1) {
			tipoMamiferoString = " Elefante";
		} else if (tipoMamifero == 2) {
			tipoMamiferoString = "a Baleia";
		}

		if (tipoPergunta == 0) {
			tipoPerguntaString = "Insira o tempo m�dio de Lact�ncia de um" + tipoMamiferoString + " (Meses)";
		} else if (tipoPergunta == 1) {
			tipoPerguntaString = "Insira o tempo m�dio de vida de um" + tipoMamiferoString + " (Anos)";
		}

		// Valida��o propriamente dita
		do {
			erro = false;

			dadoString = JOptionPane.showInputDialog(null, tipoPerguntaString, "Dados do Mam�fero",
					JOptionPane.QUESTION_MESSAGE);

			if (dadoString == null || dadoString.length() <= 0) {
				erro = true;
				JOptionPane.showMessageDialog(null, "Insira algum valor para continuar com o cadastro!", "ERRO",
						JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					dadoInteger = Integer.parseInt(dadoString);
				} catch (NumberFormatException e) {
					erro = true;
					JOptionPane.showMessageDialog(null, "Insira apenas valores Inteiros!", "ERRO",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		} while (erro);

		return dadoInteger;
	}

	// Valida Float
	public static Float dadosFloat(Integer tipoMamifero, Integer tipoPergunta) {
		// Atributos
		Float dadoFloat = null;
		String dadoString;
		String tipoMamiferoString = null;
		String tipoPerguntaString = null;
		Boolean erro;

		// Ajuste de pergunta de acordo com construtor de mamifero da main
		if (tipoMamifero == 0) {
			tipoMamiferoString = " Macaco";
		} else if (tipoMamifero == 1) {
			tipoMamiferoString = " Elefante";
		} else if (tipoMamifero == 2) {
			tipoMamiferoString = "a Baleia";
		}

		if (tipoPergunta == 2) {
			tipoPerguntaString = "Insira o tamanho m�dio de um" + tipoMamiferoString + " adulto (m).";
		} else if (tipoPergunta == 5) {
			tipoPerguntaString = "Insira o peso m�dio de um" + tipoMamiferoString + " adulto (kg).";
		}

		// Valida��o propriamente dita
		do {
			erro = false;

			dadoString = JOptionPane.showInputDialog(null, tipoPerguntaString, "Dados do Mam�fero",
					JOptionPane.QUESTION_MESSAGE);

			if (dadoString == null || dadoString.length() <= 0) {
				erro = true;
				JOptionPane.showMessageDialog(null, "Insira algum valor para continuar com o cadastro!", "ERRO",
						JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					dadoFloat = Float.parseFloat(dadoString);
				} catch (NumberFormatException e) {
					erro = true;
					JOptionPane.showMessageDialog(null, "Insira apenas valores Inteiros!", "ERRO",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} while (erro);

		return dadoFloat;
	}

	// Valida String
	public static String dadosString(Integer tipoMamifero, Integer tipoPergunta) {
		// Atributos
		String dadoString = null;
		Integer escolhaPorte;
		String escolhas[] = { "Pequeno", "M�dio", "Grande" };
		Boolean erro;

		// M�todos
		do {
			erro = false;

			if (tipoPergunta == 3) {
				escolhaPorte = JOptionPane.showOptionDialog(null, "Escolha o porte f�sico do macaco a cadastrar:",
						"Dados do Mam�fero", JOptionPane.DEFAULT_OPTION, 3, null, escolhas, escolhas[0]);
				dadoString = escolhas[escolhaPorte];

			} else if (tipoPergunta == 4) {
				dadoString = JOptionPane.showInputDialog(null, "Digite o habitat natural do Elefante:",
						"Dados do Mam�fero", 3);
			}

			if (dadoString == null || dadoString.length() <= 0) {
				erro = true;
				JOptionPane.showMessageDialog(null, "Insira algum valor para continuar com o cadastro!", "ERRO",
						JOptionPane.WARNING_MESSAGE);
			}

		} while (erro);
		return dadoString;
	}

}
