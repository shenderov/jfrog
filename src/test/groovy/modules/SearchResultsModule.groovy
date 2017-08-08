package modules

import geb.Module

class SearchResultsModule extends Module {

    static content = {
        contentContainer { $("#jf-content") }
        toasterContainer { $("#toast-container") }
        toastMessageContainer { toasterContainer.find("div.toast-message")}
        resultsTableGrid { contentContainer.find("div.ui-grid-viewport")}
    }

    String getToastMessage(){
        waitFor {
            return toastMessageContainer.find("div").text()
        }
    }

    String getResultsCountMessage(){
        waitFor {
            return contentContainer.find("div.search-results-title").text()
        }
    }

    def getResultsCount(){
        waitFor {
            return resultsTableGrid.find("div.ui-grid-canvas").size()
        }
    }


}
