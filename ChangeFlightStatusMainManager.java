package control;



import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import entity.Consts;
import entity.Flight;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChangeFlightStatusMainManager implements Initializable {

	@FXML
	private Button back;

	@FXML
	private ComboBox<Flight> flights;

	@FXML
	private AnchorPane screen;

	@FXML
	private ComboBox<String> status;

	@FXML
	private Button updateButton;

	@FXML
	private Parent parent;

	@FXML
	void Back(ActionEvent event) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					parent = FXMLLoader.load(getClass().getResource("/view/MainFlightsManager.fxml"));
					Stage stage = new Stage();
					Scene scene = new Scene(parent);
					stage.setScene(scene);
					stage.show();
					screen.getScene().getWindow().hide();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	@FXML
	void UpdateButton(ActionEvent event) {

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmnt = conn.prepareCall(Consts.UPDATE_STATUS)) {


			stmnt.setString(1, status.getSelectionModel().getSelectedItem());

			stmnt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		if (FlightLogic.getInstance().getFlights() != null) {
			for (Flight f : FlightLogic.getInstance().getFlights()) {
				flights.getItems().addAll(f);
			}
		}

		status.getItems().addAll("on-time", "delayed", "cancelled");

	}

}
