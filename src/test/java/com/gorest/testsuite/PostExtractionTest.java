package com.gorest.testsuite;/**
 * @author VibrantSoul
 */

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

/**
 *@author VibrantSoul
 */
public class PostExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";
    }

    @Test
    public void usersAssert() {
        response =
                given()
                        .queryParam("page", 1)                                //after ? params after & 2nd params
                        .queryParam("per_page", 25)
                        .when()
                        .get("/posts")
                        .then()
                        .statusCode(200);

//        1. Verify  if the total record is 25
        response.body("size()" ,equalTo(25));

//        2. Verify if the title of id = 93997 is equal to ”Demitto conqueror atavus argumentum corrupti
//        cohaero libero.”
        response.body("[1].title" ,equalTo("Textus nihil voluptatem autem totam consectetur accusantium."));

//        3. Check the single user_id in the Array list (5914184)
        response.body("[2].user_id" ,equalTo(5914184));

//        4. Check the multiple ids in the ArrayList (5914161 , 5914161 ,5914070)
        response.body("user_id" ,hasItems(5914181 , 5914161 ,5914070));

//        5. Verify the body of userid = 5914197 is equal "Demonstro cubo curia. Canonicus fuga arcus. Culpo sub rerum.
//        Armarium deporto peccatus. Arguo vilitas absens. Sublime crux suscipio. Eaque somnus recusandae. Sursum usque deleo.
//        Alioqui vacuus contigo. Pel vorax adduco. Deleniti velit suggero. Culpo cibo illo. Volaticus altus constans."

        response.body("[5].body" ,equalTo("Acidus consequatur tantillus. Quaerat conservo dapifer. Amoveo culpa dedecor. Titulus suasoria audio. Culpo addo ascit. Alias odit apostolus. Aut comitatus voluntarius. Adultus creator tendo. Vaco suffoco demum. Sapiente torrens adaugeo. Strues vallum dolorem. Averto amita claudeo. Solvo repellendus reiciendis. Vae modi solium. Accedo conduco volo. Commodi caelum depono"));

    }
}
