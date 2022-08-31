package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.sql.SQLException;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Json {

	 @FXML
	    private Button back;

	 @FXML
	    private Button flight;

	    @FXML
	    private AnchorPane screen;

	    @FXML
	    private Button seats;
	    
	    @FXML
	    private Parent parent;

	@FXML
	void importFlights(ActionEvent event) {

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(entity.Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(entity.Consts.SQL_SEL_FLIGHTS);
					ResultSet rs = stmt.executeQuery()) {
				JsonArray flights = new JsonArray();
				while (rs.next()) {
					JsonObject f = new JsonObject();

					for (int i = 1; i < rs.getMetaData().getColumnCount(); i++)
						f.put(rs.getMetaData().getColumnName(i), rs.getString(i));

					flights.add(f);
				}

				JsonObject doc = new JsonObject();
				doc.put("Flights_info", flights);

				File file = new File("json/flights.json");
				file.getParentFile().mkdir();

				try (FileWriter writer = new FileWriter(file)) {
					writer.write(Jsoner.prettyPrint(doc.toJson()));
					writer.flush();
					Alerts.alerts.showAlert(AlertType.INFORMATION, "Sending flights info to customerfly",
							"Sent Successfully, file has been sent to the customerfly.", ButtonType.OK);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void importSeats(ActionEvent event) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(entity.Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(entity.Consts.SQL_SEL_SEATS);
					ResultSet rs = stmt.executeQuery()) {
				JsonArray seats = new JsonArray();
				while (rs.next()) {
					JsonObject f = new JsonObject();

					for (int i = 1; i < rs.getMetaData().getColumnCount(); i++)
						f.put(rs.getMetaData().getColumnName(i), rs.getString(i));

					seats.add(f);
				}

				JsonObject doc = new JsonObject();
				doc.put("Seats_info", seats);

				File file = new File("json/seats.json");
				file.getParentFile().mkdir();

				try (FileWriter writer = new FileWriter(file)) {
					writer.write(Jsoner.prettyPrint(doc.toJson()));
					writer.flush();
					Alerts.alerts.showAlert(AlertType.INFORMATION, "Sending flights info to customerfly",
							"Sent Successfully, file has been sent to the customerfly.", ButtonType.OK);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
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

}
