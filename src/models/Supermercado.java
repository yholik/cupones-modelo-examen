package models;

public class Supermercado {
	private double acumuladoVtas;
	private double acumuladoDto;
	
	public double getAcumuladoVtas() {
		return acumuladoVtas;
	}
	public void setAcumuladoVtas(double acumuladoVtas) {
		this.acumuladoVtas = acumuladoVtas;
	}
	public double getAcumuladoDto() {
		return acumuladoDto;
	}
	public void setAcumuladoDto(double acumuladoDto) {
		this.acumuladoDto = acumuladoDto;
	}
	
	public void acumularVTa(double importe) {
		this.acumuladoVtas += importe;
	}
	
	public void acumularDto(double descontado) {
		this.acumuladoDto += descontado;
	}
	
}
