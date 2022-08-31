package control;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

import Exceptions.EmptyFieldException;
import Exceptions.UserNameNotFoundException;
import Exceptions.wrongPasswordException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login implements Initializable, Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@FXML
    private Button login;

    @FXML
    private TextField password;

    @FXML
    private TextField username;
       
	@FXML
	private AnchorPane screen;
	
	@FXML
	private Parent parent;

	
	public static Login instance;
	public static Login getInstance() 
	{
		if (instance == null)
			instance = new Login();
		return instance;
	}
	
  @FXML
  void login(ActionEvent event) {


		try {
			if (username.getText()==null || password.getText()==null)
				throw new EmptyFieldException();
			
			if (username.getText().equals("employeesmanager")&& password.getText().equals("employeesmanager"))
			{
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
			
			if (username.getText().equals("flightsmanager")&& password.getText().equals("flightsmanager"))
			{
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
			
			if (username.getText().equals("mainflightsmanager")&& password.getText().equals("mainflightsmanager"))
			{
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

			else if(!username.getText().equals("employeesmanager")&&!username.getText().equals("fightsmanager")&&!username.getText().equals("mainflightsmanager"))
				throw new UserNameNotFoundException();
			
			else if((username.getText().equals("employeesmanager")&& !password.getText().equals("employeesmanager"))||(username.getText().equals("fightsmanager")&& !password.getText().equals("fightsmanager"))||(username.getText().equals("mainflightsmanager")&& !password.getText().equals("mainflightsmanager")))
				throw new wrongPasswordException();

		} catch (EmptyFieldException e) {
			e.setTitle("Error");
		}catch (wrongPasswordException e) {
			e.getMessage();
		}catch (UserNameNotFoundException e) {
			e.getMessage();
		}
  }



    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}

