package dados;

public class Mamifero {
	// Atributos
	protected Integer id;
	protected Integer tempMedLactancia;
	protected Integer tempMedVida;
	protected Float tamMedAdulto;

	// Métodos

	// Construtor
	public Mamifero(Integer tempMedLactancia, Integer tempMedVida, Float tamMedAdulto) {
		setTempMedLactancia(tempMedLactancia);
		setTempMedVida(tempMedVida);
		setTamMedAdulto(tamMedAdulto);
	}

	// Getters & Setters

	// id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// tempMedLactancia
	public Integer getTempMedLactancia() {
		return this.tempMedLactancia;
	}

	public void setTempMedLactancia(Integer tempMedLactancia) {
		this.tempMedLactancia = tempMedLactancia;
	}

	// tempMedVida
	public Integer getTempMedVida() {
		return this.tempMedVida;
	}

	public void setTempMedVida(Integer tempMedVida) {
		this.tempMedVida = tempMedVida;
	}

	// tamMedAdulto
	public Float getTamMedAdulto() {
		return this.tamMedAdulto;
	}

	public void setTamMedAdulto(Float tamMedAdulto) {
		this.tamMedAdulto = tamMedAdulto;
	}
}
