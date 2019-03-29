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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Brian
 */
public class WeatherExtractorTest {
    
    public WeatherExtractorTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of requestByZipCode method, of class WeatherExtractor.
     */
    @Test
    public void testRequestByZipCode() {
        System.out.println("requestByZipCode"); //identifies the method being tested
        String zipCode = "29483"; //sets the text to provide to the method
        WeatherExtractor instance = new WeatherExtractor(); //instantiates the class
        WeatherObject expResult = null; //
        WeatherObject result = instance.requestByZipCode(zipCode);
        assertNotNull(result);
        //assertEquals(expResult, result); //compares result to expected
        
        

    }

    /**
     * Test of requestByCity method, of class WeatherExtractor.
     */
    @Test
    public void testRequestByCity() {
        System.out.println("requestByCity");
        String cityAndState = "Charleston";
        WeatherExtractor instance = new WeatherExtractor();
        WeatherObject expResult = null;
        WeatherObject result = instance.requestByCity(cityAndState);
        assertNotNull(result);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    
}
