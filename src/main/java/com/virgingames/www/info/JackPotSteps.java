package com.virgingames.www.info;

import com.virgingames.www.constants.EndPoints;
import com.virgingames.www.constants.Path;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;


public class JackPotSteps {
    @Step("Getting all jackpots records")
    public ValidatableResponse getJackPort() {
        return SerenityRest.given().log().all()
                .queryParams("currency","GBP")
                .header("Connection", "keep-alive")
                .when()
                .get(EndPoints.GET_ALL_Jackpots)
                .then().log().all().statusCode(200);
    }
    @Step("Getting the JackPort information with currency : {0}")
    public HashMap<String, Object> getJackportInfoByCurrency(String currency) {
        String s1 = "data.findAll{it.currency == '";
        String s2 = "'}.get(0)";
        return SerenityRest.given()
                .basePath(Path.RESOURCE)
                .queryParam("currency", currency)
                .when()
                .get(EndPoints.GET_Jackport_By_ID)
                .then().log().all().statusCode(200)
                .extract()
                .path(s1 + currency + s2);


    }

}
