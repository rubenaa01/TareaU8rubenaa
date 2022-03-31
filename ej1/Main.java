package ej1;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Metodos a = new Metodos ();
		a.resgistraLlamadas();
		int opcion=1;
		while (opcion >=1 && opcion<=5) {
		System.out.println("1.- MOSTRAR DATOS.");
		System.out.println("2.- CALCULAR FACTURA");
		System.out.println("3.- GRABAR");
		System.out.println("4.- Leer las llamadas grabadas en el fichero y visualizar solo las “Horaria”.");
		System.out.println("5.- Eliminar todas las llamadas realizadas a un determinado número de destino");
		System.out.println("6.- Salir");
		System.out.print("Introduzca una opción: ");
		opcion=sc.nextInt();
		switch(opcion) {
		case 1:
		//	a.ver_datos();;
			break;
		case 2:
			a.factura();
			break;
		case 3:
			a.grabar();
			break;
			
		case 4:
		//	a.leer();
			break;
		case 5:
			a.eliminar();
			break;
		default:
			break;

	}
		
	}
	
	}

}
