package control;


import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import entity.Airplane;
import entity.Airport;
import entity.Flight;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;


public class flighScreenMainManager implements Initializable {

	@FXML private TextField fid;
	@FXML private ComboBox<String> statusCombo = new ComboBox<>();;
	@FXML private ListView<Airport> src;
    @FXML private ListView<Airplane> tail;
	@FXML private DatePicker dd;
	@FXML private DatePicker ld;
	@FXML private Button createFlight;
	@FXML private Button clear;
	@FXML private Button h;
	@FXML private ListView<Airport> dest;
    @FXML private AnchorPane screen;
    @FXML
    private Button back;
    @FXML private Parent parent;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		LocalDate nowDate = LocalDate.now();
		
		if(FlightLogic.getInstance().getPlanes() != null) {
			for(Airplane p : FlightLogic.getInstance().getPlanes()) {
				tail.getItems().addAll(p);
			}
		}

		if(FlightLogic.getInstance().getPorts() != null) {
			for(Airport ds : FlightLogic.getInstance().getPorts()) {
				dest.getItems().addAll(ds);
			}
		}
		if(FlightLogic.getInstance().getPorts() != null) {
			for(Airport sc : FlightLogic.getInstance().getPorts()) {
				src.getItems().addAll(sc);
			}
		}

		statusCombo.getItems().addAll("on-time","delayed","cancelled");
		
		dd.setValue(nowDate);
		ld.setValue(nowDate);
	}


	@FXML
	void CreateFlight(ActionEvent event)  {      //This methods adds a flight to the system in condition the fields are not null.

		Date nowDate = Date.valueOf(LocalDate.now());
		String id = null;
		Airplane t = null;
		Airport s = null;
		Airport d = null;
		Date da = null;
		Date lda = null;
		String f = null;

		try {

			id = fid.getText();

//			if(id.length() > 5 || id.length() < 5) {
//				Alerts.alerts.showAlert(AlertType.WARNING, "Invaild  Flight Number","Flight Number must be Only 5 Numbers!" , ButtonType.OK);
//			}

			for(Flight fl : FlightLogic.getInstance().getFlights()) {
				if(fl.getFlightNum() == id) {
					Alerts.alerts.showAlert(AlertType.WARNING, "Invaild  ID","This ID is already Exists!!" , ButtonType.OK);

				}
			}
			t = tail.getSelectionModel().getSelectedItem();
			s = src.getSelectionModel().getSelectedItem();
			d = dest.getSelectionModel().getSelectedItem();
			f = statusCombo.getSelectionModel().getSelectedItem();
			da = Date.valueOf(dd.getValue());
			lda = Date.valueOf(ld.getValue());

			if( da.before(nowDate)) {
				Alerts.alerts.showAlert(AlertType.WARNING, "Invaild  Date","Please enter a valid date!" , ButtonType.OK);
			}
			if( lda.before(nowDate)) {
				Alerts.alerts.showAlert(AlertType.WARNING, "Invaild  Date","Please enter a valid date!" , ButtonType.OK);
			}
			if(da.after(lda)) {
				Alerts.alerts.showAlert(AlertType.WARNING, "Invaild  Date","Departure Date cannot be AFTER landing Date!" , ButtonType.OK);
			}

		}catch (NullPointerException e) {
			// TODO: handle exception
			Alerts.alerts.showAlert(AlertType.ERROR, "Add Flight To The System", "Please Fill in The Folowing Feilds", ButtonType.CLOSE);
		}

		if(fid == null) {
			Alerts.alerts.showAlert(AlertType.WARNING, "ADD Flight To The System",
					"Please enter the flight id.", ButtonType.OK);
		} else if(tail == null) {
			Alerts.alerts.showAlert(AlertType.WARNING, "ADD Flight To The System",
					"Please enter the flight airplane.", ButtonType.OK);
		}else if(src == null) {
			Alerts.alerts.showAlert(AlertType.WARNING, "ADD Flight To The System",
					"Please enter the flight source.", ButtonType.OK);
		}else if(dest == null) {
			Alerts.alerts.showAlert(AlertType.WARNING, "ADD Flight To The System",
					"Please enter the flight destination.", ButtonType.OK);
		}else if(dd == null) {
			Alerts.alerts.showAlert(AlertType.WARNING, "ADD Flight To The System",
					"Please enter flight departure date.", ButtonType.OK);
		}else if(ld == null) {
			Alerts.alerts.showAlert(AlertType.WARNING, "ADD Flight To The System",
					"Please enter flight landing date.", ButtonType.OK);
		}else {
			// add
			boolean res = FlightLogic.getInstance().addFlight(id, da, lda, f, s.getAirportNum(), d.getAirportNum(), t.getTailNum(),null,null);
			if(res) {
				Alerts.alerts.showAlert(AlertType.INFORMATION, "Adding Flight To The System",
						"Added Successfully, message has been sent to the Employees manager.", ButtonType.OK);

			}else {
				Alerts.alerts.showAlert(AlertType.ERROR, "ADD Flight To The System",
						"Failed to add the given Flight!",
						ButtonType.OK);
			}
		}
	}
	
	
	
	@FXML
	void clear(ActionEvent event) {
		clearing();
	}

	private void clearing() {
		
		LocalDate nowDate = LocalDate.now();
		
		fid.setText("");
		statusCombo.getSelectionModel().clearSelection();;
		tail.getSelectionModel().clearSelection();
		src.getSelectionModel().clearSelection();
		dest.getSelectionModel().clearSelection();
		dd.setValue(nowDate);
		ld.setValue(nowDate);
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
