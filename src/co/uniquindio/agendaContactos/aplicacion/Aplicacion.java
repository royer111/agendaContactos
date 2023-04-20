package co.uniquindio.agendaContactos.aplicacion;

import java.util.ArrayList;
import co.uniquindio.agendaContactos.controller.AgendaContactosController;
import co.uniquindio.agendaContactos.model.Agenda;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Aplicacion extends Application {
	Stage primaryStage;
	private Agenda agenda;


	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;

		mostrarVentanaPrincipal();

	}

	private void mostrarVentanaPrincipal() {
		try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Aplicacion.class.getResource("/co/uniquindio/agendaContactos/views/AgendaContactosViews.fxml"));
        BorderPane borderPane = (BorderPane)loader.load();
        AgendaContactosController agendaContactosController = loader.getController();
        agendaContactosController.setAplicacion(this);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}


	public static void main(String [] arg){
		launch(arg);
	}

}
