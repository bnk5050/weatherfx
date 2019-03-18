/*
 * The MIT License
 *
 * Copyright 2019 Brian Kirby.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package weatherfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Brian Kirby
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField zipCodeField;
    @FXML
    private TextField cityStateField;
    
    private WeatherModel model = new WeatherModel();
    
    private void createShowWeatherScene(){
        
        
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
            
        try {
            cityStateField.setText("testing");
            //Use the Zipcode first
            if (!zipCodeField.getText().isEmpty()) {
                //TODO validate input for zip code and city state
                model.getWeatherByZip(zipCodeField.getText());
            }
            else if (!cityStateField.getText().isEmpty()) {
                //TODO Validate the City and State
                model.getWeatherByCity(zipCodeField.getText());
            }
            else{
                Alert alertbox = new Alert(Alert.AlertType.WARNING, "You must enter a Zip Code or City and State");
                alertbox.showAndWait();
            }
            
            }   catch (IOException e) {
            System.out.println("Error during API call");
            System.out.println("The cause is" + e.getCause());
            System.out.println("The message is" + e.getMessage());
        }
                        
            /**
             * Creates a loader object containing the new scene and controller
             * Loads the XML hierarchy into the parent/root node
             * Creates a new scene for the weatherViewParent root node
             */
            
 try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLShowWeather.fxml"));
                
                Parent weatherViewParent = loader.load();
                Scene weatherViewScene = new Scene(weatherViewParent);


                //Get a copy of the controller and pass in the model object
                FXMLShowWeatherController controller = loader.getController();
                controller.setModel(model);
                                
                //controller.setWeatherObject(currentWeather);

                /**
                 * Gets the current window where the event occurred
                 * Casts the return object to a Node, then casts that to a Stage
                 * Use that stage to set the scene to my new view/window
                 */

                Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();      
                currentStage.setScene(weatherViewScene);
                currentStage.show();
                
            } catch (IOException e) {
                System.out.println("Error Controller Load");
                System.out.println("The cause is" + e.getCause());
                System.out.println("The message is" + e.getMessage());
                e.printStackTrace();
            }
            

        
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

}
