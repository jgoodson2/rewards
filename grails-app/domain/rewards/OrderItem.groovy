package rewards

class OrderItem {
    Integer qty
    Float total
    static belongsTo = [orders:OnlineOrder, product:Product]

    static constraints = {
    }
}
