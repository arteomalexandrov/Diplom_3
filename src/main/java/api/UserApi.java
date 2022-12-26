package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import user.Identity;

import static io.restassured.RestAssured.given;

public class UserApi {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String PATH_USER = "/api/auth/user";
    private static final String PATH_LOGIN = "/api/auth/login";


    public UserApi() {
    }

    private RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .setContentType("application/json")
                .setBaseUri(BASE_URL)
                .build();
    }

    public ValidatableResponse login(Identity identity) {
        return given()
                .spec(getSpec())
                .log().all()
                .body(identity)
                .post(PATH_LOGIN)
                .then()
                .log().all();
    }

    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .spec(getSpec())
                .auth().oauth2(accessToken)
                .log().all()
                .delete(PATH_USER)
                .then();
    }
}
