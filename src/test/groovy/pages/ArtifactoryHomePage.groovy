package pages

import geb.Page
import modules.MainViewModule
import modules.NavBarModule
import modules.SideMenuModule

class ArtifactoryHomePage extends Page {

    static at = { title == "Artifactory"}

    static content = {
        navbar { module(NavBarModule) }
        sideMenu { module(SideMenuModule) }
        contentContainer {module(MainViewModule)}
    }

}