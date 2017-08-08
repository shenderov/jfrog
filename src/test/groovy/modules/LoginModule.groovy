package modules

import geb.Module
import org.openqa.selenium.By

class LoginModule extends Module {

    static content = {
        loginForm { $("#login-form") }
        titleContainer { loginForm.find("div.login-inner").find(By.tagName("h3")) }
        usernameField { loginForm.find("jf-field")}
        inputUsername { loginForm.find("#user") }
        inputPassword { loginForm.find("#password") }
        closeButton { loginForm.find("a.close-button") }
        rememberMeCheckbox { loginForm.find("#remember-me") }
        loginButton { loginForm.find("#login") }
    }

    void clickOnClose() {
        closeButton.click()
    }

    def getTitle() {
        return titleContainer.text()
    }

    void enterUsername(def username) {
        inputUsername = username
    }

    void enterPassword(def password) {
        inputPassword = password
    }

    void checkRememberMe() {
        if(rememberMeCheckbox.hasClass("ng-empty")){
            rememberMeCheckbox.click()
        }
    }

    void uncheckRememberMe() {
        if(rememberMeCheckbox.hasClass("ng-not-empty")){
            rememberMeCheckbox.click()
        }
    }

    void clickOnLoginButton() {
        loginButton.click()
    }

    void enterCredentialsAndLogin(def username, def password) {
        enterUsername(username)
        enterPassword(password)
        clickOnLoginButton()
    }

    def getFormErrorText(){
        waitFor {
            return  loginForm.find("div.jf-form-errors").text()
        }
    }

    def getInputUsernameErrorText(){
        return inputUsername.parent().parent().parent().find("#validation-label").text()
    }

    def getInputPasswordErrorText(){
        return inputPassword.parent().parent().parent().find("#validation-label").text()
    }

}