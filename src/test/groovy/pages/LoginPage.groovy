package pages

import dataentities.User
import geb.Page

/**
 * Created by nvonop on 06/05/2017.
 */
class LoginPage extends Page {

    static at = {
        title == "Login"
    }
    
    static content = {
        usernameInput {$()}
        passwordInput {$()}
        loginButton {$()}
    }

    def enterLoginDetails(User userDetails) {
        usernameInput.value(userDetails.username)
        passwordInput.value(userDetails.password)
    }

    def submitCredentials() {
        loginButton.click()
    }
}
