import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.os.ExecutableFinder

import static org.apache.commons.lang3.SystemUtils.IS_OS_LINUX
import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS

//Admin username
username = "admin"

//Admin password
password = "JFrog1q2w3e"

//Artifactory's url
baseUrl = "http://ec2-54-237-219-155.compute-1.amazonaws.com:8050/artifactory"

File findDriverExecutable() {
    def defaultExecutable = new ExecutableFinder().find("chromedriver")
    if (defaultExecutable) {
        new File(defaultExecutable)
    } else {
        new File("drivers").listFiles().findAll {
            !it.name.endsWith(".version")
        }.find {
            if (IS_OS_LINUX) {
                it.name.contains("linux")
            } else if (IS_OS_MAC) {
                it.name.contains("mac")
            }else if (IS_OS_WINDOWS) {
                it.name.contains("windows")
            }
        }
    }
}

driver = {
    ChromeDriverService.Builder serviceBuilder = new ChromeDriverService.Builder()
            .usingAnyFreePort()
            .usingDriverExecutable(findDriverExecutable())
    new ChromeDriver(serviceBuilder.build())
}


