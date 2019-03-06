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

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 *
 * @author Brian
 */
public class WeatherExtractor {

    private final String API_KEY = "0b398274ec45a0d76da946f036f74b38";
    
    public WeatherExtractor() {
        
    }
   
    public static weatherObject makeApiRequest(String locationString) throws IOException{
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://api.openweathermap.org/data/2.5/weather?zip=94040,us&appid=0b398274ec45a0d76da946f036f74b38");

        try(CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
            System.out.println("The information received from the API is: ");
            System.out.println(response1.getStatusLine().getStatusCode());
            HttpEntity responseEntity = response1.getEntity();
            //System.out.println(EntityUtils.toString(responseEntity, "UTF-8"));

            //InputStream messageBody = responseEntity.getContent();
           
            
            //Use Jackson to Parse the XML file for the information
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(responseEntity.getContent());
            EntityUtils.consume(responseEntity);
            weatherObject currentWeather = new weatherObject();
            currentWeather.setCity(rootNode.get("name").asText());
            currentWeather.setTemp(rootNode.path("main").get("temp").asDouble());
            
            System.out.println(currentWeather.toString());
            return currentWeather;
        }

    }
}

