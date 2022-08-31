package control;

import java.io.IOException;
import java.net.URL;

import java.util.HashMap;
import java.util.ResourceBundle;

import entity.Airplane;
import entity.Flight;
import entity.GroundAttendant;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AssignGroundAttendants implements Initializable {

	@FXML
	private Button AddButton;

	@FXML
	private TextField endOfShift;

	@FXML
	private TextField role;

	@FXML
	private ComboBox<Flight> flights;

	@FXML
	private ListView<GroundAttendant> groundAttendants;

	@FXML
	private AnchorPane screen;

	@FXML
	private TextField shiftId;
	
	 @FXML
	    private Parent parent;
	    
	    @FXML
	    private Button back;

	@FXML
	private TextField startOfShift;

	private HashMap<String, Integer> numOfGroundAttendantsInFlight = new HashMap<String, Integer>();
	private static int count = 0;

	@FXML
	void AddToFlight(ActionEvent event) {

		for (Airplane a : FlightLogic.getInstance().getPlanes()) {
			String s = String.valueOf(
					numOfGroundAttendantsInFlight.get(flights.getSelectionModel().getSelectedItem().getFlightNum()));
			if (flights.getSelectionModel().getSelectedItem().getTailNum().equals(a.getTailNum())
					&& a.getNumOfAttendants().equals(s)) {
				Alerts.alerts.showAlert(AlertType.INFORMATION, "Full of ground attendants for this flight",
						"Failed to add", ButtonType.OK);
			}
		}

		
		FlightLogic.getInstance().addShift(shiftId.getText(), startOfShift.getText(), endOfShift.getText());
		FlightLogic.getInstance().addGroundInShift(groundAttendants.getSelectionModel().getSelectedItem().getId(), shiftId.getText(),
				role.getText());

		if (!numOfGroundAttendantsInFlight.containsKey(flights.getSelectionModel().getSelectedItem().getFlightNum())) {
			
			numOfGroundAttendantsInFlight.put(flights.getSelectionModel().getSelectedItem().getFlightNum(),

					++count);
		} else {
			

			numOfGroundAttendantsInFlight.replace(flights.getSelectionModel().getSelectedItem().getFlightNum(),
					numOfGroundAttendantsInFlight.get(flights.getSelectionModel().getSelectedItem().getFlightNum()));
		}

		clearing();

	}

	private void clearing() {

		flights.getSelectionModel().clearSelection();
		groundAttendants.getSelectionModel().clearSelection();
		shiftId.setText(null);
		startOfShift.setText(null);
		endOfShift.setText(null);
		role.setText(null);
	}

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		if (FlightLogic.getInstance().getFlights() != null) {
			for (Flight f : FlightLogic.getInstance().getFlights()) {
				flights.getItems().addAll(f);
			}
		}

		if (FlightLogic.getInstance().getGroundAttendant() != null) {
			for (GroundAttendant g : FlightLogic.getInstance().getGroundAttendant()) {
				groundAttendants.getItems().addAll(g);

			}
			groundAttendants.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		}
	}
	
	@FXML
    void Back(ActionEvent event) {

    	Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					parent = FXMLLoader.load(getClass().getResource("/view/EmployeesManager.fxml"));
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
