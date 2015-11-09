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
        return theWelcomeMsg
    }

    def getTotalPoints(customerInstance) {
        def totalAwards = 0
        customerInstance.awards.each {
            totalAwards = totalAwards + it.points
        }
        customerInstance.totalPoints = totalAwards
        return customerInstance
    }

    def processCheckin(lookupInstance) {
        //Lookup customer by phone number
        def customerInstance = Customer.findByPhone(lookupInstance.phone)
        if (!customerInstance) {
            //Set up new customer
            customerInstance = lookupInstance
            customerInstance.firstName = "Customer"
        }
        //Calculate current award points
        def totalAwards = 0
        customerInstance.awards.each {
            totalAwards = totalAwards + it.points
        }
        customerInstance.totalPoints = totalAwards

        //Create welcome message
        def firstName = customerInstance.firstName
        def welcomeMessage
        switch (totalAwards) {
            case 5:
                welcomeMessage = "Welcome back $firstName. This drink is on us."
                break
            case 4:
                welcomeMessage = "Welcome back $firstName. Your next drink is free."
                break
            case 1..3:
                welcomeMessage = "Welcome back $firstName. You now have ${totalAwards + 1} points."
                break
            default:
                welcomeMessage = "Welcome $firstName. Thanks you for registering."
                break
        }
        //Add new award
        if (totalAwards < 5) {
            customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Purchase", points: 1))
        } else {
            customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Reward", points: -5))
        }
        //Save customer
        customerInstance.save()

        return [customerInstance, welcomeMessage]
    }
}
