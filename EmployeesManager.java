package control;

import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import entity.AirAttendant;
import entity.AirAttendantInFlight;
import entity.Airplane;
import entity.Consts;
import entity.Flight;
import entity.Pilot;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EmployeesManager implements Initializable {

	   @FXML
	    private Button AddAir;

	    @FXML
	    private Button AddPilot;


	@FXML
	private ListView<AirAttendant> airAttendants;

	@FXML
	private ComboBox<Flight> flights;

	@FXML
	private ListView<Pilot> mainPilot;

	@FXML
	private AnchorPane screen;
	
	 @FXML
	    private Button back;

	@FXML
	private ListView<Pilot> secondPilot;

	@FXML
	private Text NumOfAirAttendants;

	@FXML
	private Parent parent;

	

	    @FXML
	    void AddPilotToFlight(ActionEvent event) {

	    	Flight f = flights.getSelectionModel().getSelectedItem();

//			f.setMainPilot(mainPilot.getSelectionModel().getSelectedItem().getPilotID());
//			f.setSecondPilot(secondPilot.getSelectionModel().getSelectedItem().getPilotID());
			
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmnt = conn.prepareCall(Consts.SET_PILOTS)) {


				stmnt.setString(1, mainPilot.getSelectionModel().getSelectedItem().getPilotID());
				stmnt.setString(2, secondPilot.getSelectionModel().getSelectedItem().getPilotID());
				stmnt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	@FXML
	void AddAirToFlight(ActionEvent event) {
		
		

		for (Airplane a : FlightLogic.getInstance().getPlanes()) {
			

			if (a.getTailNum().equals(flights.getSelectionModel().getSelectedItem().getTailNum())) {
				switch (a.getNumOfAttendants()) {

				case "1": {
					boolean res = FlightLogic.getInstance().addAirAttendantsInFlight(
							airAttendants.getSelectionModel().getSelectedItem().getId(), a.getTailNum());
					if (res) {
						Alerts.alerts.showAlert(AlertType.INFORMATION, "Adding AirAttendatns To The FLIGHT",
								"Added Successfully", ButtonType.OK);
					}
				}

				case "2": {
					System.out.println("90");
					AirAttendantInFlight A1 = new AirAttendantInFlight(
							airAttendants.getSelectionModel().getSelectedItem().getId(), a.getTailNum());
					AirAttendantInFlight A2 = new AirAttendantInFlight(
							airAttendants.getSelectionModel().getSelectedItem().getId(), a.getTailNum());

					boolean res1 = FlightLogic.getInstance().addAirAttendantsInFlight(A1.getId(), A1.getFlightNum());
					boolean res2 = FlightLogic.getInstance().addAirAttendantsInFlight(A2.getId(), A2.getFlightNum());
					if (res1 && res2) {
						Alerts.alerts.showAlert(AlertType.INFORMATION, "Adding AirAttendatns To The FLIGHT",
								"Added Successfully", ButtonType.OK);
					}
				}

				case "3": {
					
					 AirAttendantInFlight A1 = new
					 AirAttendantInFlight(airAttendants.getSelectionModel().getSelectedItem().getId(),a.getTailNum());
					 AirAttendantInFlight A2 = new
					 AirAttendantInFlight(airAttendants.getSelectionModel().getSelectedItem().getId(),a.getTailNum());
					 AirAttendantInFlight A3 = new
					 AirAttendantInFlight(airAttendants.getSelectionModel().getSelectedItem().getId(),a.getTailNum());
				
					boolean res1 = FlightLogic.getInstance().addAirAttendantsInFlight(
							airAttendants.getSelectionModel().getSelectedItem().getId(), a.getTailNum());	
					boolean res2 = FlightLogic.getInstance().addAirAttendantsInFlight(A2.getId(), A2.getFlightNum());
					boolean res3 = FlightLogic.getInstance().addAirAttendantsInFlight(A3.getId(), A3.getFlightNum());
			
					if (res1&&res2&&res3) {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								try {
									parent = FXMLLoader
											.load(getClass().getResource("/view/AssignGroundAttendants.fxml"));
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
				}
			}
		}


	}

	@FXML
	void GetNumOfAttendants(ActionEvent event) {

		for (Airplane a : FlightLogic.getInstance().getPlanes()) {
			if (a.getTailNum().equals(flights.getSelectionModel().getSelectedItem().getTailNum())) {
				NumOfAirAttendants.setText(a.getNumOfAttendants());
			}
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		if (FlightLogic.getInstance().getFlights() != null) {
			for (Flight f : FlightLogic.getInstance().getFlights()) {
				flights.getItems().addAll(f);
			}
		}

		if (FlightLogic.getInstance().getPilots() != null) {
			for (Pilot p : FlightLogic.getInstance().getPilots()) {
				mainPilot.getItems().addAll(p);
			}
		}

		if (FlightLogic.getInstance().getPilots() != null) {
			for (Pilot p : FlightLogic.getInstance().getPilots()) {
				secondPilot.getItems().addAll(p);
			}
		}

		if (FlightLogic.getInstance().getAirAttendants() != null) {
			for (AirAttendant a : FlightLogic.getInstance().getAirAttendants()) {
				airAttendants.getItems().addAll(a);

			}
			airAttendants.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		}

	}
	
	@FXML
    void Back(ActionEvent event) {

    	Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					parent = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
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
