package co.uniquindio.agendaContactos.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import co.uniquindio.agendaContactos.exceptions.ContactoException;

public class Agenda implements Serializable {

	/**
	 *
	 */
	//private static final long serialVersionUID = 1L;
	private String nombre;
	private Contacto[] listaContactos;
	private Grupo[] listaGrupos;
	private Reunion[] listaReuniones;


	public Agenda(String nombre, int numeroContactos,int numeroGrupos,int numeroReuniones) {
		super();
		this.nombre = nombre;
		this.listaContactos = new Contacto[numeroContactos];
		this.listaGrupos = new Grupo[numeroGrupos];
		this.listaReuniones = new Reunion[numeroReuniones];
	}


	public Agenda() {
		super();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Contacto[] getListaContactos() {
		return listaContactos;
	}


	public void setListaContactos(Contacto[] listaContactos) {
		this.listaContactos = listaContactos;
	}


	public Grupo[] getListaGrupos() {
		return listaGrupos;
	}


	public void setListaGrupos(Grupo[] listaGrupos) {
		this.listaGrupos = listaGrupos;
	}


	public Reunion[] getListaReuniones() {
		return listaReuniones;
	}


	public void setListaReuniones(Reunion[] listaReuniones) {
		this.listaReuniones = listaReuniones;
	}


	@Override
	public String toString() {
		return "Agenda [nombre=" + nombre + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


	public void aniadirContacto(Contacto newContacto) throws ContactoException{

		Contacto contacto = buscarContacto(newContacto);
		int posDisponible = 0;

		if(contacto != null){
			throw new ContactoException("El contacto ya existe");
		}
		posDisponible = obtenerPosicion(listaContactos);

		if(posDisponible == -1){
			throw new ContactoException("Agenda llena");
		}
		listaContactos[posDisponible] = newContacto;

	}



	/**
	 * funcion encargada de retornar la posicion disonible en un arreglo
	 *
	 * @param listaContactos
	 * @return
	 */

	private int obtenerPosicion(Contacto[] listaContactos)  {
		for (int i = 0 ; i<10; i++){
			if(listaContactos[i] == null){
				return i;
		}


	}
		return -1;
	}



/**
 * funcion que busca a un contacto que es ingresado por parametro y lo compara con
 * cada uno de los contactos pertenecientes a la listaContactos
 * @param newContacto
 * @return
 */
	private Contacto buscarContacto(Contacto newContacto) {
		for (Contacto contacto2 : listaContactos) {
			if(newContacto.getTelefono().equals(contacto2.getTelefono())){
				return newContacto;
			}


		}
		return null;


	}

	private boolean existeContacto(Contacto newContacto) {

		List<Contacto> asList = Arrays.asList(listaContactos);
		return asList.stream().filter(c -> c.equals(newContacto)).findFirst().isPresent();
	}


	/**
	 * metodo que retorna el telefono de un contacto buscandolo por su nombre
	 * @param nombre
	 * @return
	 */
	public String buscarContacto (String nombre){
		String telefono = "";
		for (Contacto contacto : listaContactos) {
			if(contacto.getNombre().equals(nombre)){
				telefono += contacto.getTelefono();
			}
			else{
				telefono+="0000000000";
			}
		}
		return telefono;
	}

	public Contacto buscarContactoTelefono ( String telefono){
		for (Contacto contacto : listaContactos) {
			if(contacto.getTelefono().equals(telefono)){
				return contacto;
			}

		}
		return null;
	}



	/**
	 * este metodo se encarga de eliminar un contacto
	 * el proceso que hace es comparar los numeros de telefonos de ambos objetos
	 * si coinciden entonces se efectua la eliminacion, de lo contrario el contacto no existe
	 * @param newContacto
	 * @return
	 */
	public String eliminarContacto (Contacto newContacto){
		String mensaje = "";
		for (Contacto contacto : listaContactos) {
			if(newContacto.getTelefono().equals(contacto.getTelefono())){
				mensaje += "contacto eliminado";
			}
			else{
				mensaje +="el contacto no existe o ya ha sido eliminado";
			}
		}
		return mensaje;
	}

}
