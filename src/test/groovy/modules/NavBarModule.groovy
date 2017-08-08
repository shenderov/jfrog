package modules

import geb.Module
import org.openqa.selenium.Keys

class NavBarModule extends Module {

    static content = {
        navbarBrandingContainer { $("div.navbar-header") }
        navbarRightMenu { $("div.navbar-right") }
        searchContainer { navbarRightMenu.find("div.icon-search-container") }
        searchInput { navbarRightMenu.find("input.search-input") }
        loginButton { navbarRightMenu.find("#login-link") }
        helpLink { navbarRightMenu.find("div.header-help") }
        loginForm { module(LoginModule) }
    }

    void clickOnLogo() {
        navbarBrandingContainer.find("img.logo-picture").click()
    }

    void search(def criteria) {
        interact {
            moveToElement(searchContainer)
        }
        waitFor {searchContainer.hasClass("active")}
        searchInput.click()
        searchInput = criteria
        interact {
            sendKeys(Keys.ENTER)
        }
    }

    void getLoginPage() {
        loginButton.click()
    }

}