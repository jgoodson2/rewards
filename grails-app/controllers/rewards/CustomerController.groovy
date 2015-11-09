package rewards

class CustomerController {
    static scaffold = true

    def lookup() {
        def customerInstance = Customer.findAllByTotalPointsGreaterThan(3, [sort: "totalPoints", order: "desc"])
        [customerInstanceList: customerInstance]
    }

    def index() {
        params.max = 10
        [customerInstanceList: Customer.list(params), customerInstanceCount: Customer.count()]
    }

    def create() {
        [customerInstance: new Customer()]
    }

    def checkin() {

    }
}
