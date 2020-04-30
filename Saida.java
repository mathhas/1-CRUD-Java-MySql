package saida;

import java.util.ArrayList;

import dados.*;

public class Saida {
	public static void mostrarCadastros(ArrayList<Macaco> macacos, ArrayList<Elefante> elefantes,
			ArrayList<Baleia> baleias) {
		System.out.println("\t\t------------------------TODOS--OS--CADASTROS------------------------");

		if (macacos.size() > 0) {
			System.out.println("MACACO:");
			for (Integer index = 0; index < macacos.size(); index++) {
				System.out.println(macacos.get(index));
			}
		}

		if (elefantes.size() > 0) {
			System.out.println("ELEFANTE:");
			for (Integer index = 0; index < elefantes.size(); index++) {
				System.out.println(elefantes.get(index));
			}
		}

		if (baleias.size() > 0) {
			System.out.println("BALEIA:");
			for (Integer index = 0; index < baleias.size(); index++) {
				System.out.println(baleias.get(index));
			}
		}
	}
}
