package modules

import geb.Module

class SideMenuModule extends Module{

    static content = {
        sideMenueContainer { $("#jf-main-nav") }
        homeItem { sideMenueContainer.find("i.icon-home-new") }
        artifactsItem { sideMenueContainer.find("i.icon-artifacts-new") }
        searchItem { sideMenueContainer.find("i.icon-menu-search") }
        buildsItem { sideMenueContainer.find("i.icon-builds-new") }
        adminItem { sideMenueContainer.find("i.icon-admin-new") }
        }

    void clickOnHomeItem(){
        homeItem.click()
    }

    void clickOnArtifactsItem(){
        artifactsItem.click()
    }

    void clickOnSearchItem(){
        searchItem.click()
    }

    void clickOnBuildsItem(){
        buildsItem.click()
    }

    void clickOnAdminItem(){
        adminItem.click()
    }
}
