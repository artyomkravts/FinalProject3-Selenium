package api;

import api.requestPOJOs.LoginUser;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
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
