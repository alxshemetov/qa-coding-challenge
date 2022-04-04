package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setContentType("application/json")
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();
    }
}
