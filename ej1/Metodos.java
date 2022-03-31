package ej1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Metodos {
private ArrayList<Llamada> arrayLlamadas = new ArrayList<Llamada>();
	
	public  void resgistraLlamadas(){
		
		 arrayLlamadas.add (new Llamada("98 5112233","98 5332211",10,"R11"));
		 arrayLlamadas.add (new Llamada("98 5112233","98 1234567",15,"C44"));
		 arrayLlamadas.add (new Llamada("98 5112233","91 3333333",5,"Y22"));
		 arrayLlamadas.add (new Llamada("98 5112233","91 5555555",13,"C44"));
		 arrayLlamadas.add (new Llamada("98 5112233","91 5555555",2,"A11"));
		 arrayLlamadas.add (new Llamada("98 5112233","91 5555555",33,"R11"));
	}
	
	public  double visualizarListin( ) { 
		
		DecimalFormat formateador = new DecimalFormat("###0.00");
		 double costeLlamada,costeTotal=0.0;
        
        for (Llamada ll: arrayLlamadas) { 
        	
         if (ll instanceof Llamada){// instanceof odetermina  si un objeto es de una clase derterminada
        	 costeLlamada=ll.calcularPrecio();//llamada al metodo calcularPrecio de la clase Llamada
        	 System.out.println("Llamada :"+ll.toString()+" - Coste: "+formateador.format (costeLlamada)+ "\n"); 
        	 costeTotal+=costeLlamada;
         } 
        }
        return costeTotal;
	}

	public void factura() {
		Scanner sc = new Scanner(System.in);

		double cuota = 0;
		double suma = 0;

		System.out.println("Introducir cuota");
		cuota = sc.nextDouble();

		for (Llamada ord : arrayLlamadas) {
			if (ord instanceof Llamada) {
				suma = suma + (((Llamada) ord).calcularPrecio());

			} 
		}
		suma = suma + cuota;
		System.out.println(suma);

	}

	public void grabar() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("llamadas.dat"));
			os.writeObject(arrayLlamadas);
			System.out.println("Los datos se han guardado correctamente");
			os.close();

		} catch (FileNotFoundException ex) {
			System.out.println("No se ha encontrado el fichero");
		} catch (IOException ex) {
			System.out.println("Ha ocurrido un error de escritura");
		}
	}
/*
	public void leer() {
		Iterator<Llamada> it = arrayLlamadas.iterator();
		DecimalFormat df = new DecimalFormat("0.00");

		try {
			ObjectInputStream leerput = new ObjectInputStream(new FileInputStream("llamadas.dat"));
			arrayLlamadas = (ArrayList) leerput.readObject();
			leerput.close();
		} catch (ClassNotFoundException a) {
			System.out.println("No se puede acceder a la clase.");
		} catch (FileNotFoundException b) {
			System.out.println("El archivo no es accesible");
		} catch (IOException c) {
			System.out.println("Noooooo tieeeenes el serializable.");
		}

		while (it.hasNext()) {
			Llamadas listado = it.next();

			if (arrayLlamadas instanceof Llamada) {
				System.out.println(((Llamada) listado).toString() + "\nEl precio es: ");
				System.out.println(df.format(((L) listado).calcularprecio()));
			}

		}
		
	}
	*/

	public void eliminar() {
		Scanner sc = new Scanner(System.in);
		Iterator<Llamada> it = arrayLlamadas.iterator();
		String cod;
		String resp = "si";
		boolean bol = false;
		while (resp.equalsIgnoreCase("si")) {
			System.out.println("***Borrado lista con iterator***");
			it = Llamada.iterator();
			System.out.println("Teclee el destino");
			cod = sc.next();
			while (it.hasNext()) {
				Llamada aux = it.next();
				if (aux.getnum().equals(cod)) {
					it.remove();
					System.out.println("codigo borrado");
					bol = true;
				}

			}
			if (bol == false) {
				System.out.println(cod + " no está en la lista");
			}
			System.out.print("¿Quiere introducir otro codigo? (si/no): ");
			resp = sc.next();
			bol = false;
		}

	}

}