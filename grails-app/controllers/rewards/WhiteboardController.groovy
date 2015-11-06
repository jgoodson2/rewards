package rewards

class WhiteboardController {
    def calculationsService

    def index() {}

    def variables(){
        def myTotal = 1
        render myTotal

    }

    def conditions(){
        def welcomeMessage = calculationsService.welcome(params)
        render welcomeMessage
    }
}
