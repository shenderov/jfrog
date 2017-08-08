package pages

import geb.Page
import modules.LoginModule
import modules.NavBarModule

class LoginPage extends Page {

    static at = { module(LoginModule).getTitle() == "Welcome to JFrog Artifactory!" }

    static content = {
        navbar { module(NavBarModule) }
        loginForm { module(LoginModule) }
    }

}
