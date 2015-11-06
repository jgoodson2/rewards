package rewards

import grails.transaction.Transactional

@Transactional
class CalculationsService {

    def welcome() {
        def firstName = params.first
        def totalPoints = params.points.toInteger()
        def welcomeMessage = ""

        switch(totalPoints){
            case 5:
                welcomeMessage = "Welcome back $firstName. This drink is on us."
            case 4:
                welcomeMessage = "Welcome back $firstName. Your next drink is free."
            case 2..3:
                welcomeMessage = "Welcome back $firstName. You now have $totalPoints points."
            default:
                welcomeMessage = "Welcome $firstName. Thanks you for registering."
        }
    }
}
