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

    def save(Customer customerInstance) {
        customerInstance.save()
        redirect(action: "show", id: customerInstance.id)
    }

    def show(Long id) {
        def customerInstance = Customer.get(id)
        [customerInstance: customerInstance]
    }

    def edit(Long id) {
        def customerInstance = Customer.get(id)
        [customerInstance: customerInstance]
    }

    def update(Long id) {
        def customerInstance = Customer.get(id)
        customerInstance.properties = params
        customerInstance.save()
        redirect(action: "show", id: customerInstance.id)
    }

    def delete(Long id) {
        def customerInstance = Customer.get(id)
        customerInstance.delete()
        redirect(action: "index")

    }

    def checkin() {

    }
}
