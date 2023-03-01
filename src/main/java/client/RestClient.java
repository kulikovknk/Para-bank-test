package client;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;

import static config.Config.getBasePath;
import static config.Config.getBaseUri;
import static io.restassured.http.ContentType.JSON;

public class RestClient {

    public RequestSpecification getDefaultRequestSpec() {

        RestAssured.defaultParser = Parser.JSON;

        return new RequestSpecBuilder()
                .setBaseUri(getBaseUri())
                .setBasePath(getBasePath())
                .setContentType(JSON)
                .setAccept(JSON)
                .build();
    }
}
