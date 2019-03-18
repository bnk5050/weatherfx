/*
 * The MIT License
 *
 * Copyright 2019 Brian.
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
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Brian
 */
public class FXMLShowWeatherController implements Initializable{

 
    private WeatherModel model;
    
    @FXML
    private Label cityLabel = new Label("null");
    
    @FXML
    private Label temperatureLabel = new Label("null");
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //Configure a binding between the label and the model.weather.city
        
        //Configure a binding between the temperature and the model.weather.temperature
        //
    }
   
    
    public WeatherModel getModel() {
        return model;
    }

    public void setModel(WeatherModel model) {
        this.model = model;
        cityLabel.textProperty().bind(model.getWeather().cityProperty());
        temperatureLabel.textProperty().bind(Bindings.convert(model.getWeather().temperatureProperty()));
    }
    
}
