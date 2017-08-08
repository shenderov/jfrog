package pages

import geb.Page
import modules.MainViewModule
import modules.NavBarModule
import modules.SearchResultsModule
import modules.SideMenuModule
import org.openqa.selenium.By

class SearchResultPage extends Page {

    static at = { $("div.search-page-wrapper").find(By.tagName("h1")).text() == "Search Artifacts" }

    static content = {
        navbar { module(NavBarModule) }
        sideMenu { module(SideMenuModule) }
        searchResults {module(SearchResultsModule)}
    }

}
