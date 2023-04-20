package co.uniquindio.agendaContactos.controller;

import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.uniquindio.agendaContactos.aplicacion.Aplicacion;
import co.uniquindio.agendaContactos.exceptions.ContactoException;
import co.uniquindio.agendaContactos.model.Agenda;
import co.uniquindio.agendaContactos.model.Categoria;
import co.uniquindio.agendaContactos.model.Contacto;
import co.uniquindio.agendaContactos.model.Grupo;
import co.uniquindio.agendaContactos.model.Reunion;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class AgendaContactosController implements Initializable {



	private Categoria categoria;


	/**
	 * Atributos pertenecientes a la interfaz de usuario
	 *
	 */
    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnCrearGrupo;

    @FXML
    private Button btnCrearReunion;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TextField fieldAlias;

    @FXML
    private TextField fieldDescripcion;

    @FXML
    private TextField fieldDireccion;

    @FXML
    private TextField fieldEmail;

    @FXML
    private TextField fieldFecha;

    @FXML
    private TextField fieldHora;

    @FXML
    private TextField fieldNombre;

    @FXML
    private TextField fieldNombreGrupo;

    @FXML
    private TextField fieldTelefono;

    @FXML
    private TextArea textAreaInformacion;

    @FXML
    private ComboBox<String> comboCategoria;
    @FXML
    private ComboBox<String> comboContactos;

    @FXML
    private ComboBox<String> comboBoxNombreGrupo;

    @FXML
    private Button btnAgregarContactoGrupo;


	private List <String> listaContactosAux = new ArrayList <String>();


	/**
	 * funcion que se encarga de crear un contatco cunaod se presiona el boton crear
	 *
	 * @param event
	 */

	Contacto newContacto1;
	@FXML
	    void funcionAgregar(ActionEvent event) {
	    	String nombre = fieldNombre.getText();
	    	String alias = fieldAlias.getText();
	    	String direccion = fieldDireccion.getText();
	    	String email = fieldEmail.getText();
	    	String telefono = fieldTelefono.getText();
	    	newContacto1 = new Contacto(nombre, alias, direccion, telefono, email, 0, 0);
	    	imprimirTextArea(nombre, alias, direccion, email, telefono);
	    	listaContactosAux.add(telefono);
	    	agregarContactoCombobox(listaContactosAux);
	    }

/**
 * funcion que se encarga de agragar los telefonos a una combo box para posteriormetne se utilizada
 * en funcionAgregar
 * @param listaContactosAux2
 */
	    private void agregarContactoCombobox(List<String> listaContactosAux2) {
	    ObservableList<String> lista = FXCollections.observableArrayList(listaContactosAux2);
		comboContactos.setItems(lista);

	}

	    /**
	     * funcion que guarda la informacion de la pestaña de contacto para luego imprimirla en
	     * el text area
	     * @param nombre
	     * @param alias
	     * @param direccion
	     * @param email
	     * @param telefono
	     */

		public void imprimirTextArea(String nombre, String alias, String direccion, String email, String telefono){
	    	String mensaje = "Nombre: " + nombre+" \n"
	                       + "Alias: "+ alias + " \n"
	    			       + "Direccion: "+ direccion +" \n"
	                       + "email: "+email +" \n"
	    			       + "Telefono: "+ telefono;
	    	textAreaInformacion.setText(mensaje);
	    }

		/**
		 * funcion que deja vacios de nuevo los espacios para dijitar nuevos datos
		 * @param event
		 */
	    @FXML
	    void funcionLimpiar(ActionEvent event) {
	    	textAreaInformacion.setText("");
	    	fieldNombre.setText("");
	    	fieldAlias.setText("");
	    	fieldTelefono.setText("");
	    	fieldEmail.setText("");
	    	fieldDireccion.setText("");
	    }


/**
 * funcion encargada de crear un grupo
 * @param event
 */

		private List <String> listaNombresGrupos = new ArrayList <String>();
	    @FXML
	    void funcionCrearGrupo(ActionEvent event)  {
	    	String nomGrugo = fieldNombreGrupo.getText();
	    	agregarNombreGrupoComboBox(nomGrugo);
	    	listaNombresGrupos.add(nomGrugo);
	    	JOptionPane.showMessageDialog(null, "Grupo creado");


	    }


/**
 * funion que desprende de crear grupo para mandar los nombres de los grupos a la parte de agragar contactos a grupos
 *
 * @param nomGrugo
 */

		private void agregarNombreGrupoComboBox(String nomGrugo) {
		    ObservableList<String> lista = FXCollections.observableArrayList(listaNombresGrupos);

	    comboBoxNombreGrupo.setItems(lista);

}


		/**
		 * Funcion encargada de crear una reunion
		 *
		 * @param event
		 */

		@FXML
	    void funcionCrearReunion(ActionEvent event) {
			Reunion reunion = new Reunion ();
			reunion.agendar();
	    }




		private Aplicacion aplicacion;
		private Agenda agenda;

		public void setAplicacion(Aplicacion aplicacion) {
			this.aplicacion = aplicacion;
	        this.agenda = aplicacion.getAgenda();
		}


		/**
		 * agregar contacto a grupo seleccionado por el usuario
		 *
		 * @param event
		 */

	    @FXML
	    void funcionAgregarContactoGrupoSeleccionado(ActionEvent event) {
	    	JOptionPane.showMessageDialog(null, "Contacto Agregado");

	    }




		/**
		 * encargada de inicializar datos al inicio del programa
		 *
		 */
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {

		ObservableList<String> lista = FXCollections.observableArrayList("Amigos", "Fiesta", "Oficina", "Familia");

		comboCategoria.setItems(lista);

		}


	}


