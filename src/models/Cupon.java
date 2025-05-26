package models;

public class Cupon {
	private String codigo;
	private double descuento;
	private int cantUsos;
	private double totalDescontado;

	// GETTERS
	public String getCodigo() {
		return this.codigo;
	}

	public double getDescuento() {
		return this.descuento;
	}

	public int getCantUsosRestantes() {
		return this.cantUsos;
	}

	public void aumentarUsos(Cupon cuponcitos) {
		this.cantUsos++;
	}
	
	public double getTotalDescontado() {
		return this.totalDescontado;
	}
	
	

	// SETTERS
	public void setCodigo(String code) {
		this.codigo = code;
	}

	public void setDescuento(double desc) {
		this.descuento = desc;
	}

	public void setCantUsos(int usos) {
		this.cantUsos = usos;
	}

	public void setTotalDescontado(double importe) {
		this.totalDescontado = importe;
	}
	
	public double usarCupon(double importe) {
		double precioConDescuento = importe - (this.getDescuento() / 100 * importe);
		this.cantUsos = this.cantUsos - 1;
		return precioConDescuento;
	}
	
	
}
