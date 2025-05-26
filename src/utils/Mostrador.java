package utils;

import java.util.Scanner;
import models.Cupon;
import models.Supermercado;
public class Mostrador {
	Scanner sc = new Scanner(System.in);

	public void mostraBienvenida() {
		System.out.println("Bienvenido al programa de gestion de Cupones");
		System.out.println("Tenes 5 lugares para guardar los cupones, aprovechalos capo");
	}

	public void configurarCupones(Cupon cuponcitos[]) {
		for (int i = 0; i < cuponcitos.length; i++) {
			Cupon cuponActual = new Cupon();
			boolean confirmado = true;

			System.out.println("Pone el nº" + (i + 1));

			do {
				System.out.println("Codigo de cupon");
				String ingresoCode = sc.next();
				if (ingresoCode.length() == 6) {
					cuponActual.setCodigo(ingresoCode);
					confirmado = true;
				} else {
					System.out.println("La patente tiene que tener 6 caracteres");
					System.out.println("Ingresalo de nuevo");
					confirmado = false;
				}
			} while (!confirmado);

			do {
				System.out.println("Descuento: ");
				double ingresoDescuento = sc.nextDouble();
				if (ingresoDescuento != 0) {
					cuponActual.setDescuento(ingresoDescuento);
					confirmado = true;
				} else {
					System.out.println("No puede ser 0");
					System.out.println("Ingresa de nuevo:");
					confirmado = false;
				}
			} while (!confirmado);

			do {
				System.out.println("Cantidad de usos: ");
				int ingresoUsos = sc.nextInt();
				if (ingresoUsos > 0) {
					cuponActual.setCantUsos(ingresoUsos);
					confirmado = true;
				} else {
					System.out.println("No puede ser menos a 0");
					System.out.println("Ingresa de nuevo");
					confirmado = false;
				}
			} while (!confirmado);

			// Asignamos toda la informacion a un espacio en el array
			cuponcitos[i] = cuponActual;
		}

	}

	public void mostrarListadoCompletoCupones(Cupon cuponcitos[]) {
		for (int i = 0; i < cuponcitos.length; i++) {
			Cupon cuponActual = cuponcitos[i];

			System.out.println("Cupon: " + cuponActual.getCodigo());
			System.out.println("Descuento: " + cuponActual.getDescuento() + "%");
			System.out.println("Cantidad de usos restantes: " + cuponActual.getCantUsosRestantes() + "u.");
			System.out.println("---------------------------------");
		}

	}

	public void mostrarCupon(Cupon cuponcitos) {
		Cupon cuponActual = cuponcitos;
		System.out.println("Cupon: " + cuponActual.getCodigo());
		System.out.println("Descuento: " + cuponActual.getDescuento() + "%");
		System.out.println("Cantidad de usos restantes: " + cuponActual.getCantUsosRestantes() + "u.");
		System.out.println("Importe descontado por este cupon: " + cuponActual.getTotalDescontado());
		System.out.println("---------------------------------");
	}

	public void menuCupones() {
			System.out.println("Elegi una opcion del menu:");
			System.out.println("1- Mostrar todos los cupones \n" + "2- Mostrar informacion de cupon \n"
					+ "3- Mostrar total recaudado y descontado hasta ahora \n" + "4- Aumentar cantidad de usos \n"
					+ "5- Usar cupon \n" + "6- Salir");
	}

	public void seleccionarMenu(int seleccion, Cupon cuponcitos[], Supermercado cajaSupermercado) {
		int indiceIngresado; // PARA ELEGIR EL CUPON DENTRO DEL MENU
		int opcion = seleccion;// SELECTOR DE OPCION DE MENU
		double importe; // PARA EL IMPORTE DE USAR CUPON
		double precioFinal;
		double descontado; 
		Cupon cuponActual;
		
		
		switch (opcion) {
		case 1: // MOSTRAR TODOS LOS CUPONES
			this.mostrarListadoCompletoCupones(cuponcitos);
			break;
		case 2: // MOSTRAR CUPON
			System.out.println("Que nº de cupon es(no es el codigo)");
			indiceIngresado = sc.nextInt() - 1;
			this.mostrarCupon(cuponcitos[indiceIngresado]);
			break;
		case 3: // MOSTRAR TOTAL RECAUDADO
			System.out.println("Caja de Supermercado:");
			System.out.println("Total recaudado: $" + cajaSupermercado.getAcumuladoVtas());
			System.out.println("Total descuentos aplicados: $"+ cajaSupermercado.getAcumuladoDto());
			break;
		case 4: //AUMENTAR USOS
			System.out.println("Que nº de cupon es(no es el codigo)");
			indiceIngresado = sc.nextInt() - 1;
			cuponActual = cuponcitos[indiceIngresado];
			cuponActual.aumentarUsos(cuponActual);
			break;
		case 5: //USAR CUPON
			//TODO Validar que el cupon tenga usos restantes
			System.out.println("Que nº de cupon es(no es el codigo)");
			indiceIngresado = sc.nextInt() - 1;
			cuponActual = cuponcitos[indiceIngresado];
			int usos = cuponActual.getCantUsosRestantes();
			if(usos >= 1) {
				
			}else {
				System.out.println("No tiene usos disponibles este cupon.");
			}
			
			
			System.out.println("Que importe es?");
			importe = sc.nextInt();
			precioFinal = cuponActual.usarCupon(importe);
			
			descontado = importe - precioFinal;
			descontado += cuponActual.getTotalDescontado();
			cuponActual.setTotalDescontado(descontado);
			
			cajaSupermercado.acumularVTa(precioFinal);
			cajaSupermercado.acumularDto(descontado);
			
			System.out.println("Precio Final: " + precioFinal);
			break;
		case 6: // MOSTRAR MENSAJE DE SALIDA
			System.out.println("Gracias por usar el programa");
			break;
		default:
			System.out.println("ERROR 404 HAHAHA ROMPISTE EL PROGRAMA TE ODIO");
			break;
		}
		
	}
}
