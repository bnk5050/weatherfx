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

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Brian Kirby
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField zipCodeField;
    @FXML
    private TextField cityStateField;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        //Use the Zipcode first
        if (!zipCodeField.getText().isEmpty()) {
            //TODO validate input for zip code and city state
            WeatherExtractor.getWeather(zipCodeField.getText());
        }
        else if (!cityStateField.getText().isEmpty()) {
            //TODO Validate the City and State
            WeatherExtractor.getWeather(cityStateField.getText());
        }
        else{
            Alert alertbox = new Alert(Alert.AlertType.WARNING, "You must enter a Zip Code or City and State");
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
