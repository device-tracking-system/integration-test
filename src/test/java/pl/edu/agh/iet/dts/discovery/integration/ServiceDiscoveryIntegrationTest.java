package pl.edu.agh.iet.dts.discovery.integration;

import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

/**
 * @author Bartłomiej Grochal
 */
public class ServiceDiscoveryIntegrationTest {

    @Test
    public void serviceDiscoveryShouldBeUp() {
        when()
                .get("http://localhost:8080/")
        .then()
                .statusCode(SC_OK);
    }

    @Test
    public void serviceDiscoveryShouldHaveTwoServicesRegistered() {
        when()
                .get("http://localhost:8080/eureka/apps")
        .then()
                .statusCode(SC_OK)
                .body("applications.application.size()", equalTo(2));
    }

    @Test
    public void serviceDiscoveryShouldHaveEdgeServerRegistered() {
        when()
                .get("http://localhost:8080/eureka/apps")
        .then()
                .statusCode(SC_OK)
                .body("applications.application.name", hasItem("EDGE-SERVER"))
                .body("applications.application.find{it.name == 'EDGE-SERVER'}.instance.port", equalTo("80"));
    }

    @Test
    public void serviceDiscoveryShouldHaveUIServiceRegistered() {
        when()
                .get("http://localhost:8080/eureka/apps")
        .then()
                .statusCode(SC_OK)
                .body("applications.application.name", hasItem("UI-SERVICE"))
                .body("applications.application.find{it.name == 'UI-SERVICE'}.instance.port", equalTo("8081"));
    }

}
