package tests

import dataentities.User
import geb.spock.GebSpec
import pages.LoginPage


/**
 * Created by nvonop on 06/05/2017.
 */
class LoginPageSpec extends GebSpec {

    def "User is able to log in with valid username and password"() {
        given: "A user"
        User userDetails = new User()

        and: "The user is on the Login page"
        to LoginPage

        when: "The user enters their login credentials"
        enterLoginDetails(userDetails)

        and: "Submits their credentials"
        submitCredentials()

        then: "The user is successfully logged in"
        title == "Welcome $userDetails.firstname $userDetails.surname"
    }

    def "User is not able to log in without specifying a password"() {
        given: "A user with no password specified"
        User userDetails = new User()
        userDetails.with {
            password = ""
        }

        and: "The user is on the Login page"
        to LoginPage

        when: "The user enters their login credentials"
        enterLoginDetails(userDetails)

        and: "Submits their credentials"
        submitCredentials()

        then: "The user is not logged in"
        title == "Login failed!"
    }
}