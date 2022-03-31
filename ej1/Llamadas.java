package ej1;
import java.io.Serializable;
public class Llamadas implements Serializable {

	private String origen;
	private String num;
	private int duracion;
	public Llamadas(String origen, String num, int duracion) {
		super();
		this.origen = origen;
		this.num = num;
		this.duracion = duracion;
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
	public int getduracion() {
		return duracion;
	}
	public void setduracion(int duracion) {
		this.duracion = duracion;
	}
	@Override
	public String toString() {
		return "Llamadas [origen=" + origen + ", num=" + num
				+ ", duracion=" + duracion + "]";
	}
	
}
