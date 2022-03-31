package ej1;
import java.io.Serializable;
import java.util.Iterator;
	public class Llamada implements Serializable {
		private String origen;
		private String num;
		private int duracion;
		private String zonaHora;
		
		
		public Llamada() {
			super();
			
		}
		public Llamada(String origen, String num, int duracion, String zonaHora) {
			super();
			this.origen = origen;
			this.num = num;
			this.duracion = duracion;
			this.zonaHora = zonaHora;
		}
		public String getorigen() {
			return origen;
		}
		public void setorigen(String origen) {
			this.origen = origen;
		}
		public String getnum() {
			return num;
		}
		public void setnum(String num) {
			this.num = num;
		}
		public int getDuracion() {
			return duracion;
		}
		public void setDuracion(int duracion) {
			this.duracion = duracion;
		}
		public String getzonaHora() {
			return zonaHora;
		}
		public void setzonaHora(String zonaHora) {
			this.zonaHora = zonaHora;
		}
		
		@Override
		public String toString() {
			return "Llamada [origen=" + origen + ", num=" + num
					+ ", duracion=" + duracion + ", zonaHora=" + zonaHora + "]";
		}
		
		public double calcularPrecio(){
			String[] franja = { "A11", "B11", "C44", "R11", "Y22" };
			double numero[][] = { { 0.20, 0.30, 0.40},
								  { 0.10, 0.40, 0.50},
								  { 0.30, 0.50, 0.70},
								  { 1.22, 1.90, 1.98},
								  { 2.21, 2.25, 2.89} };
			double sumafila = 0;
			double[] guardar = new double[5];
			double precio = 0;
			// suma fila
			for (int filas = 0; filas < numero.length; filas++) {
				for (int columna = 0; columna < numero[filas].length; columna++) {
					sumafila += numero[filas][columna];
				}
				guardar[filas] = sumafila;
				sumafila = 0;

			}

			// busco que coincidad la velocidad con mi array donde he guardado las velocidad
			// y cuando la encuentro, la guardo en la variable precio
			for (int i = 0; i < numero.length; i++) {
				if ( zonaHora== franja[i]) {
					precio = guardar[i];
				}
			}
			
			// hago la media y la multiplico por la duracion
					precio = (precio / 3) * getDuracion();
					return precio;

		}
		public static Iterator<Llamada> iterator() {
			// TODO Auto-generated method stub
			return null;
		}}
