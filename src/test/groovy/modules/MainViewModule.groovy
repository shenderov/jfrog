package modules

import geb.Module

class MainViewModule extends Module {

    static content = {
        contentContainer { $("#jf-content") }
    }

    String getPageTitle(){
        waitFor {
            return contentContainer.find("h1.home-header-happily").text()
        }
    }
}
