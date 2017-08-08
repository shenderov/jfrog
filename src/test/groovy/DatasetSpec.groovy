import com.jayway.restassured.response.Response
import spock.lang.Specification

import static com.jayway.restassured.RestAssured.given
import spock.lang.Stepwise

@Stepwise
class DatasetSpec extends Specification {

    //Admin username
    String username = "admin"

    //Admin password
    String password = "JFrog1q2w3e"

    //Artifactory's url
    String url = "http://ec2-54-237-219-155.compute-1.amazonaws.com:8050/artifactory"

    //Repository name
    String repo = "generic-local"


    def "Deploy a dummy file"() {
        given:
        Response response
        Map <String, String> headers = new HashMap<>()
        headers.put("Authorization", "Basic " + (username + ":" + password).bytes.encodeBase64().toString())

        when:
        response =
                given().
                        body(new File('src/test/resources/jfrog.dummy').bytes).
                        headers(headers).
                        contentType(com.jayway.restassured.http.ContentType.BINARY).
                        when().
                        put(url + "/" + repo + "/com/jfrog/jfrog-1.0.dummy").
                        then().
                        extract().response()

        then:
        assert response.getStatusCode() == 201
    }
}
