package control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import entity.Flight;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FlightsByCountryReport implements Initializable{

	

	   @FXML
	    private Button get;

	    @FXML
	    private ListView<String> percent;

	    @FXML
	    private AnchorPane screen;
	    
	    @FXML
	    private Button back;
	    
	    @FXML
	    private Parent parent;

    public int count=0;
    public
  

    @FXML
    void GetFlights(ActionEvent event) {

    	//int count=0;
    	ArrayList<Flight> returnedFlights = FlightLogic.getInstance().getFlights();
    	HashMap<String, Integer> PercentFlights = new HashMap<String,Integer>();
    	
    	HashMap<String,String> toShow = new HashMap<String,String>();
    	ArrayList<String> toShowFinal = new ArrayList<String>();
    	
    	for(Flight f: returnedFlights)
    	{
    		if(f!=null&& !PercentFlights.containsKey(f.getDestAirport()))
    			{
    				count++;
    				PercentFlights.put(f.getDestAirport(), 1);
    			}
    		
    		else if(PercentFlights.containsKey(f.getDestAirport())) {
    			int X=PercentFlights.get(f.getDestAirport());
    			PercentFlights.put(f.getDestAirport(), ++X);
    		}
    	}
    	
    	for(String s: PercentFlights.keySet())
    	{
    		double d = (PercentFlights.get(s)*100)/count;
    		toShow.put(s, d+"%");
    	}
    	
    	for(String s: toShow.keySet())
    	{
    		toShowFinal.add("Airport Number: "+s+"         contains "+toShow.get(s)+" from all the flights");
    	}
    	
    	for(String s: toShowFinal) {
    		percent.getItems().add(s);
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
   

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
//		HashMap<Integer,Flight> lastMonthFlights = new HashMap<>();
//		countryName.setCellValueFactory(new PropertyValueFactory<>("Country Name"));
//		percent.setCellValueFactory(new PropertyValueFactory<>("Percent of flights"));
		//table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		//for(Flight f: )
	}

}
