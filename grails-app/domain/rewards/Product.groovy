package rewards

class Product {
    String name
    String sku
    Float price
    static hasMany = [orderItem:OrderItem]

    static constraints = {
    }
}
