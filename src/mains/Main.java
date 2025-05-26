package mains;
import models.Cupon;
import models.Supermercado;
import utils.Mostrador;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Mostrador mostrador = new Mostrador();
		Supermercado cajaSupermercado = new Supermercado(); 

		Cupon cuponcitos[] = new Cupon[1];
		
		mostrador.mostraBienvenida();
		mostrador.configurarCupones(cuponcitos);
		
		int seleccion;
		do {
		mostrador.menuCupones();
		seleccion = sc.nextInt();
		mostrador.seleccionarMenu(seleccion, cuponcitos, cajaSupermercado);
		}while(seleccion != 6);
		
		sc.close();
	}

}
