package dados;

public final class Elefante extends Mamifero {
	// Atributos
	private Float peso;
	private String habitatNatural;

	// Métodos

	// Construtor
	public Elefante(Integer tempMedLactancia, Integer tempMedVida, Float tamMedAdulto, Float peso,
			String habitatNatural) {
		super(tempMedLactancia, tempMedVida, tamMedAdulto);
		setPeso(peso);
		setHabitatNatural(habitatNatural);
	}

	// Getters & Setters

	// Peso
	public Float getPeso() {
		return this.peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	// HabitatNatural
	public String getHabitatNatural() {
		return this.habitatNatural;
	}

	public void setHabitatNatural(String habitatNatural) {
		this.habitatNatural = habitatNatural;
	}

	// Sobrescreve Object, para facilitar impressao de dados dos arrayList
	public String toString() {
		return ("\tID: " + getId() + "\tTempo med. Lactância: " + getTempMedLactancia() + " meses"
				+ "\tTempo med. vida: " + getTempMedVida() + " anos" + "\tTamanho Med. Adult: " + getTamMedAdulto()
				+ " m" + "\tPeso: " + getPeso() + " kg" + "\t\tHabitat Natural: " + getHabitatNatural());
	}
}
