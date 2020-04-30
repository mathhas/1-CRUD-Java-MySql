package dados;

public final class Baleia extends Mamifero {
	// Atributos
	private Float peso;

	// Métodos

	// Construtor
	public Baleia(Integer tempMedLactancia, Integer tempMedVida, Float tamMedAdulto, Float peso) {
		super(tempMedLactancia, tempMedVida, tamMedAdulto);
		setPeso(peso);
	}

	// Getter & Setter
	public Float getPeso() {
		return this.peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	// Sobrescreve Object, para facilitar impressao de dados dos arrayList
	public String toString() {
		return ("\tID: " + getId() + "\tTempo med. Lactância: " + getTempMedLactancia() + " meses" + "\tTempo med. vida: " + getTempMedVida()
				+ " anos" + "\tTamanho Med. Adult: " + getTamMedAdulto() + " m" + "\tPeso: " + getPeso() + " kg");
	}
}