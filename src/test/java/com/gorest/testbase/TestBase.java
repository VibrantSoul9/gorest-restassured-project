package com.gorest.testbase;/**
 * @author VibrantSoul
 */

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

/**
 *@author VibrantSoul
 */
public class TestBase {
    @BeforeClass
    public void inIt() {

        RestAssured.baseURI = "https://gorest.co.in";               // RestAssured is a class
        // RestAssured.baseURI = PropertyReader.getInstance().getProperty("baseURI");

        RestAssured.basePath = "/public/v2" ;                                                      //Create property reader class as before
    }
}
