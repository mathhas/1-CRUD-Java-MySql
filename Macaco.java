package dados;

public final class Macaco extends Mamifero {
	// Atributos
	private String porteFisico;

	// Métodos

	// Construtor
	public Macaco(Integer tempMedLactancia, Integer tempMedVida, Float tamMedAdulto, String porteFisico) {
		super(tempMedLactancia, tempMedVida, tamMedAdulto);
		setPorteMacaco(porteFisico);
	}

	// Getter & Setter
	public String getPorteMacaco() {
		return this.porteFisico;
	}

	public void setPorteMacaco(String porteMacaco) {
		this.porteFisico = porteMacaco;
	}

	// Sobrescreve Object, para facilitar impressao de dados dos arrayList
	public String toString() {
		return ("\tID: " + getId() + "\tTempo med. Lactância: " + getTempMedLactancia() + " meses." + "\tTempo med. vida: "
				+ getTempMedVida() + " anos." + "\tTamanho Med. Adult: " + getTamMedAdulto() + " m" + "\tPorte Físico: "
				+ getPorteMacaco());
	}
}
