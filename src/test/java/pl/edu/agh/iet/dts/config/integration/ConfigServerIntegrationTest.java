package pl.edu.agh.iet.dts.config.integration;

import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.apache.http.HttpStatus.SC_OK;

/**
 * @author Bartłomiej Grochal
 */
public class ConfigServerIntegrationTest {

    @Test
    public void configServerShouldHaveEdgeServerConfiguration() {
        when()
                .get("http://localhost:8888/edge-server/native")
        .then()
                .statusCode(SC_OK);

        when()
                .get("http://localhost:8888/edge-server/production")
        .then()
                .statusCode(SC_OK);

        when()
                .get("http://localhost:8888/edge-server/test")
        .then()
                .statusCode(SC_OK);
    }

    @Test
    public void configServerShouldHaveUIServiceConfiguration() {
        when()
                .get("http://localhost:8888/edge-server/native")
        .then()
                .statusCode(SC_OK);

        when()
                .get("http://localhost:8888/ui-service/production")
        .then()
                .statusCode(SC_OK);

        when()
                .get("http://localhost:8888/ui-service/test")
        .then()
                .statusCode(SC_OK);
    }

    @Test
    public void configServerShouldHaveServiceDiscoveryConfiguration() {
        when()
                .get("http://localhost:8888/service-discovery/native")
        .then()
                .statusCode(SC_OK);

        when()
                .get("http://localhost:8888/service-discovery/production")
        .then()
                .statusCode(SC_OK);
    }

}
