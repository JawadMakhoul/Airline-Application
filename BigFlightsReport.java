package control;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

//import java.util.ArrayList;
//import java.util.HashMap;

import entity.Flight;
import entity.Seat;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BigFlightsReport {

    @FXML
    private ListView<Flight> bigFlights;

    @FXML
    private DatePicker from;

    @FXML
    private Button getFlights;

    @FXML
    private AnchorPane screen;

    @FXML
    private TextField seatsNum;

    @FXML
    private DatePicker until;
    
    @FXML
    private Button back;
    
    @FXML
    private Parent parent;

    @FXML
    void GetFlights(ActionEvent event) {

    	
    	int count=0;
    	HashMap<String, Integer> CountSeats = new HashMap<>();
    	HashMap<String, Flight> MoreThanX = new HashMap<>();
    	
    	ArrayList<Seat> returnedSeats = FlightLogic.getInstance().getSeats();
    	ArrayList<Flight> returnedFlights = FlightLogic.getInstance().getFlights();
    	
    
    		
    	for(Seat s: returnedSeats)
    	{
    		if(s.getSeatClass().equals("EconomyClass"))
    		{
    			if(!CountSeats.containsKey(s.getTailNum()))
    			{
    				CountSeats.put(s.getTailNum(), 1);
    			}
    			
    			else if(CountSeats.containsKey(s.getTailNum()))
    			{
    				count = CountSeats.get(s.getTailNum());
    				CountSeats.put(s.getTailNum(), count+1);
    			}
    			
    		}
    		
    	}
    	
    	for(Flight f: returnedFlights)
    	{
    		for(String s: CountSeats.keySet())
    		{
    			int X=Integer.parseInt(seatsNum.getText());
    			if(f.getTailNum().equals(s) && CountSeats.get(s)> X) {
    				MoreThanX.put(s, f);
    			}
    		}
    	}

    	
    	for(String s: MoreThanX.keySet()) {
    		bigFlights.getItems().add(MoreThanX.get(s));
    	}
    	
    	
    	
    	

    }
    
    @FXML
    void Back(ActionEvent event) {

    	Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					parent = FXMLLoader.load(getClass().getResource("/view/FlightsManager.fxml"));
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
