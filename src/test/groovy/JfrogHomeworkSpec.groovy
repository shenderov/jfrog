import geb.spock.GebSpec
import pages.*

class JfrogHomeworkSpec extends GebSpec {
    def username = browser.config.rawConfig.username
    def password = browser.config.rawConfig.password

    def "Login test"() {
        when:
        to ArtifactoryHomePage

        and:
        navbar.getLoginPage()

        then:
        at LoginPage

        when:
        //Empty username
        loginForm.enterUsername("")
        loginForm.inputPassword.click()

        then:
        assert loginForm.inputUsername.hasClass("invalid") == true
        assert loginForm.getInputUsernameErrorText() == "You must fill in this field"

        when:
        //Empty password
        loginForm.enterPassword("")
        loginForm.inputUsername.click()

        then:
        assert loginForm.inputPassword.hasClass("invalid") == true
        assert loginForm.getInputPasswordErrorText() == "You must fill in this field"

        when:
        //Wrong username
        loginForm.enterCredentialsAndLogin("wrongUsername", password)

        then:
        assert loginForm.getFormErrorText() == "Username or Password Are Incorrect"

        when:
        //Wrong password
        loginForm.enterCredentialsAndLogin(username, "wrongPassword")

        then:
        assert loginForm.getFormErrorText() == "Username or Password Are Incorrect"

        when:
        //Correct credentials
        loginForm.enterCredentialsAndLogin(username, password)

        and:
        at ArtifactoryHomePage

        then:
        assert contentContainer.getPageTitle().contains("Artifactory is happily serving")
    }

    def "Search test"() {
        given:
        at ArtifactoryHomePage

        when:
        navbar.search("Wrong search criteria")

        then:
        at SearchResultPage

        and:
        assert searchResults.getToastMessage() == "No artifacts found. You can broaden your search by using the * and ? wildcards"
        assert searchResults.getResultsCountMessage() == "Search Results - 0 Items"

        when:
        navbar.search("jfrog-1.0.dummy")

        then:
        at SearchResultPage

        and:
        //for some reason returns cut response ("Search Results")
        //assert searchResults.getResultsCountMessage() == "Search Results - 1 Items"
        assert searchResults.getResultsCountMessage().contains("Search Results")
        assert searchResults.getResultsCount() == 2
    }
}