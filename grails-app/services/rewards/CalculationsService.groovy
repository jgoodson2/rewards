package rewards

import grails.transaction.Transactional

@Transactional
class CalculationsService {

    def welcome(params) {
        def firstName = params.first
        def totalPoints = params.points.toInteger()
        def theWelcomeMsg

        switch (totalPoints) {
            case 5:
                theWelcomeMsg = "Welcome back $firstName. This drink is on us."
                break
            case 4:
                theWelcomeMsg = "Welcome back $firstName. Your next drink is free."
                break
            case 2..3:
                theWelcomeMsg = "Welcome back $firstName. You now have $totalPoints points."
                break
            default:
                theWelcomeMsg = "Welcome $firstName. Thanks you for registering."
                break
        }

    }
}
