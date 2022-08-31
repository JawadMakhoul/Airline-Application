package control;


import java.io.File;
import java.io.IOException;

import javax.swing.text.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Element;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class XML {

	@FXML
    private Button back;

    @FXML
    private AnchorPane screen;

    @FXML
    private Button xml;
    
    @FXML
    private Parent parent;

	 @FXML
	    void getXML(ActionEvent event) {
		 
		 String xmlFilePath = "/xml/flights.xml";
		try {
			// creating a constructor of file class and parsing an XML file
			File file = new File(xmlFilePath);
			// an instance of factory that gives a document builder
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// an instance of builder to parse the specified xml file
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = (Document) db.parse(file);
			//doc.getDefaultRootElement().normalize();
			System.out.println("Root element: " + doc.getDefaultRootElement().getName());
			NodeList nodeList = ((Element) doc).getElementsByTagName("Flight");
			// nodeList is not iterable, so we are using for loop
			for (int itr = 0; itr < nodeList.getLength(); itr++) {
				Node node = nodeList.item(itr);
				System.out.println("\nNode Name :" + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					System.out.println("flight id: " + eElement.getElementsByTagName("flightNum").item(0).getTextContent());
					System.out.println(
							"First Name: " + eElement.getElementsByTagName("departureDate").item(0).getTextContent());
					System.out.println(
							"Last Name: " + eElement.getElementsByTagName("landingDate").item(0).getTextContent());
					System.out.println("Subject: " + eElement.getElementsByTagName("status").item(0).getTextContent());
					System.out.println("Marks: " + eElement.getElementsByTagName("srcAirport").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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

//	private static InputStream readXmlFileIntoInputStream(final String fileName) {
//	      return ReadXmlDomParserLoop.class.getClassLoader().getResourceAsStream(fileName);
//	  }
//
//	private static void printNote(NodeList nodeList) {
//
//	      for (int count = 0; count < nodeList.getLength(); count++) {
//
//	          Node tempNode = nodeList.item(count);
//
//	          // make sure it's element node.
//	          if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
//
//	              // get node name and value
//	              System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
//	              System.out.println("Node Value =" + tempNode.getTextContent());
//
//	              if (tempNode.hasAttributes()) {
//
//	                  // get attributes names and values
//	                  NamedNodeMap nodeMap = tempNode.getAttributes();
//	                  for (int i = 0; i < nodeMap.getLength(); i++) {
//	                      Node node = nodeMap.item(i);
//	                      System.out.println("attr name : " + node.getNodeName());
//	                      System.out.println("attr value : " + node.getNodeValue());
//	                  }
//
//	              }
//
//	              if (tempNode.hasChildNodes()) {
//	                  // loop again if has child nodes
//	                  printNote(tempNode.getChildNodes());
//	              }
//
//	              System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
//
//	          }
//
//	      }
//
//	  }

