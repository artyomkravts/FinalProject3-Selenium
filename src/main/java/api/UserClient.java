package api;

import api.requestPOJOs.LoginUser;
import api.requestPOJOs.RegisterUser;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    @Step("Register user")
    public static Response registerUser(RegisterUser user) {
        return
                RestAssured.given().log().all()
                        .contentType(ContentType.JSON)
                        .and()
                        .body(user)
                        .when()
                        .post(Constants.BASE_URI + Constants.REGISTER_PATH);
    }

    @Step("Log in user")
    public static Response logInUser(LoginUser loginUser) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .and()
                .body(loginUser)
                .when()
                .post(Constants.BASE_URI + Constants.LOGIN_PATH);
    }

    @Step("Delete user")
    public static Response deleteUser(String accessToken) {
        return given().log().all()
                .auth().oauth2(accessToken)
                .when()
                .delete(Constants.BASE_URI + Constants.USER_PATH);
    }

    @Step("Get access token without 'Bearer ' part")
    public static String getAccessTokenWithoutBearer(Response response) {
        String accessToken = response.then().log().all()
                .extract()
                .path("accessToken");
        if (accessToken != null) {
            return accessToken.replace("Bearer ", "");
        } else return null;
    }
}
